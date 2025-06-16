package minevalley.regions.api.structures;


import lombok.Setter;
import minevalley.core.api.localization.PlayerLocation;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Street {

    /**
     * Gets the id of this street which can be used to refer to the street.
     *
     * @return id as integer.
     */
    int getId();

    /**
     * Gets this streets name.
     * <p>
     * <b>Note:</b> Don't use it to refer to the street. Names might change in the future. Use getId instead!
     *
     * @return name as string.
     * @see #getId()
     * @see #getShortName()
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Gets this street's name in a shortened form (Friedrichstraße -> Friedrichstr.)
     *
     * @return shortened street name
     */
    @Nonnull
    @Contract(pure = true)
    String getShortName();

    /**
     * Gets the description of this street. Not every street does have a description. If the street doesn't have a description, this is null.
     *
     * @return description as string
     */
    @Nonnull
    @Contract(pure = true)
    String getDescription();

    @Setter
    class StreetHelper {
        private static IStreetHelper helper;

        public static List<NavigationPoint> getAllNavigationPoints() {
            return helper.getAllNavigationPoints();
        }

        public static List<NavigationPoint> getNavigationPoints(Street street) {
            return helper.getNavigationPoints(street);
        }

        public static void addNavigationPoint(NavigationPoint navigationPoint) {
            helper.addNavigationPoint(navigationPoint);
        }

        public static void removeNavigationPoint(NavigationPoint navigationPoint) {
            helper.removeNavigationPoint(navigationPoint);
        }

        public static NavigationPoint getNearest(Location location) {
            return helper.getNearest(location);
        }
    }

    interface IStreetHelper {

        List<NavigationPoint> getAllNavigationPoints();

        List<NavigationPoint> getNavigationPoints(Street street);

        void addNavigationPoint(NavigationPoint navigationPoint);

        void removeNavigationPoint(NavigationPoint navigationPoint);

        NavigationPoint getNearest(Location location);
    }

    @SuppressWarnings("ConstantValue")
    record NavigationPoint(Street street, Location location, String name,
                           List<Connection> connections) implements PlayerLocation {

        public double distance(@Nonnull Location location) throws IllegalArgumentException {
            if (location == null) throw new IllegalArgumentException("Location cannot be null");
            if (this.location.getWorld() != location.getWorld()) {
                throw new IllegalArgumentException("Locations must be in the same world");
            }
            return this.location.distance(location);
        }

        public double distance(@Nonnull NavigationPoint navigationPoint) throws IllegalArgumentException {
            return distance(navigationPoint.location());
        }

        public void addConnection(Connection connection) {
            connections.add(connection);
        }

        private void removeConnection(Connection connection) {
            connections.remove(connection);
        }
    }

    interface Connection {

        int weight();

        @SuppressWarnings("BooleanMethodIsAlwaysInverted")
        boolean isUsableFromHere(NavigationPoint navigationPoint);

        NavigationHint getNavigationHint(NavigationPoint from);

        void remove();
    }

    enum NavigationHint {
        NONE,
        TURN_RIGHT,
        TURN_LEFT,
        KEEP_TO_THE_RIGHT,
        KEEP_TO_THE_LEFT,
        ROUNDABOUT_FIRST_EXIT,
        ROUNDABOUT_SECOND_EXIT,
        ROUNDABOUT_THIRD_EXIT,
        ROUNDABOUT_FOURTH_EXIT,
        TURN
    }

    record OneWayConnection(@Nonnull NavigationPoint from, @Nonnull NavigationPoint to,
                            @Nonnegative int speedLimit, @Nonnull NavigationHint navigationHint) implements Connection {
        @Override
        public int weight() {
            return (int) Math.round(from.distance(to) * speedLimit);
        }

        @Override
        public boolean isUsableFromHere(NavigationPoint navigationPoint) {
            return from == navigationPoint;
        }

        @Override
        public NavigationHint getNavigationHint(NavigationPoint from) {
            if (!isUsableFromHere(from)) return NavigationHint.NONE;
            return navigationHint;
        }

        @Override
        public void remove() {
            from.removeConnection(this);
            to.removeConnection(this);
        }
    }

    record TwoWayConnection(@Nonnull NavigationPoint point1, @Nonnull NavigationPoint point2,
                            @Nonnegative int speedLimit,
                            @Nonnull NavigationHint point1To2,
                            @Nonnull NavigationHint point2To1) implements Connection {
        @Override
        public int weight() {
            return (int) Math.round(point1.distance(point2) * speedLimit);
        }

        @Override
        public boolean isUsableFromHere(NavigationPoint navigationPoint) {
            return point1 == navigationPoint || point2 == navigationPoint;
        }

        @Override
        public NavigationHint getNavigationHint(NavigationPoint from) {
            if (!isUsableFromHere(from)) return NavigationHint.NONE;
            return from == this.point1 ? point1To2 : point2To1;
        }

        @Override
        public void remove() {
            point1.removeConnection(this);
            point2.removeConnection(this);
        }
    }
}
