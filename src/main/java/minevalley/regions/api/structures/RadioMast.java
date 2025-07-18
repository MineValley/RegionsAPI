package minevalley.regions.api.structures;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface RadioMast {

    /**
     * Gets the name of this radio mast.
     *
     * @return name as string
     */
    @Nonnull
    @Contract(pure = true)
    String name();

    /**
     * Gets this radio mast's location.
     *
     * @return radio mast's location
     */
    @Nonnull
    @Contract(pure = true)
    Location location();

    /**
     * Gets the range of this radio mast in blocks.
     * The range defines how far this radio mast reaches.
     *
     * @return range in blocks.
     */
    @Nonnegative
    @Contract(pure = true)
    int range();

    /**
     * Calculates the distance between a given location and this radio mast.
     *
     * @param location location to calculate the distance to
     * @return distance as integer
     * @throws IllegalArgumentException if location is null or not in the same world as this radio mast.
     */
    @Contract(pure = true)
    double distance(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Gets all the users that are currently connected to this radio mast.
     *
     * @return stream of all the connected users
     */
    @Nonnull
    @Contract(pure = true)
    Stream<OnlineUser> getConnectedUsers();
}