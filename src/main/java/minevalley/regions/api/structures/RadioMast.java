package minevalley.regions.api.structures;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
     * Gets the z coordinate of this radio mast.
     *
     * @return z coordinate of this radio mast
     */
    @Contract(pure = true)
    int z();

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
     * <p>
     * It is calculated in two dimensions (the y coordinate is neglected) and is rounded to full blocks.
     *
     * @param location location to calculate the distance to
     * @return distance as integer
     * @throws IllegalArgumentException if location is null or not in the same world as this radio mast.
     * @see #isInRange(Location)
     */
    @Nonnegative
    @Contract(pure = true)
    int distance(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Calculates the distance between the given coordinates and this radio mast, rounded in full blocks.
     *
     * @param x x coordinate to get the distance to
     * @param z z coordinate to get the distance to
     * @return distance as integer
     * @see #isInRange(int, int)
     */
    @Nonnegative
    @Contract(pure = true)
    int distance(int x, int z);

    /**
     * Gets whether a specific location is in range of this radio mast.
     *
     * @param location location to check
     * @return true, if the given location is in the same world as the radio mast and lies inside the radio mast's range
     * @see #range()
     * @see #distance(Location)
     */
    @Contract(value = "null -> false", pure = true)
    boolean isInRange(@Nullable Location location);

    /**
     * Gets whether specific coordinates lie in the range of this radio mast.
     *
     * @param x x coordinate to check
     * @param z z coordinate to check
     * @return true, if the given location lies inside the radio mast's range
     * @see #range()
     * @see #distance(int, int)
     */
    @Contract(pure = true)
    boolean isInRange(int x, int z);

    /**
     * Gets a stream of all the users that are in range of this radio mast.
     *
     * @return stream of all the users in range
     */
    @Nonnull
    @Contract(pure = true)
    Stream<OnlineUser> getOnlineUsersInRange();

    /**
     * Gets all the users that are currently connected to this radio mast.
     *
     * @return stream of all the connected users
     */
    @Nonnull
    @Contract(pure = true)
    Stream<OnlineUser> getConnectedUsers();
}