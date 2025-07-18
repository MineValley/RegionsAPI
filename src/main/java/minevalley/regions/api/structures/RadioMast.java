package minevalley.regions.api.structures;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;
import org.bukkit.World;
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
     * Gets the world, this radio mast lies in.
     *
     * @return world of this radio mast
     */
    @Nonnull
    @Contract(pure = true)
    World world();

    /**
     * Gets the x coordinate of this radio mast.
     *
     * @return x coordinate of this radio mast
     */
    @Contract(pure = true)
    int x();

    /**
     * Gets the y coordinate of this radio mast.
     *
     * @return y coordinate of this radio mast
     */
    @Contract(pure = true)
    int y();

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