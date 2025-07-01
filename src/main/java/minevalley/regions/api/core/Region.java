package minevalley.regions.api.core;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.Location;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface Region {

    /**
     * Gets this regions' id.
     *
     * @return id as integer
     */
    int id();

    /**
     * Gets a list of the areas that are included in the region.
     *
     * @return list of included areas
     */
    @Nonnull
    List<Area> included();

    /**
     * Gets a list of the areas that are excluded by the region.
     *
     * @return list of excluded areas
     */
    @Nonnull
    List<Area> excluded();

    /**
     * Gets a list with the chunks that this region lies in.
     *
     * @return list of chunks this region lies in
     */
    @Nonnull
    List<Chunk> chunks();

    /**
     * Gets a stream of all the users that are currently in the region.
     *
     * @return stream of all users in the region
     */
    @Nonnull
    Stream<OnlineUser> getUsersInRegion();

    /**
     * Kicks a user out of the region.
     *
     * @param user   user to kick
     * @param target location to kick the user to
     * @throws IllegalStateException    if the user is offline or not inside the region.
     * @throws IllegalArgumentException if one of the arguments is null, or the target location is not in the same world as the region itself.
     */
    void kickUser(@Nonnull OnlineUser user, @Nonnull Location target) throws IllegalStateException, IllegalArgumentException;

    /**
     * Kicks all users out of this region.
     * <p>
     * <b>Note:</b> This method does not kick team members.
     *
     * @param target location to kick the users to
     */
    default void kickAllUsers(@Nonnull Location target) {
        getUsersInRegion().filter(user -> !user.isTeamler()).forEach(user -> kickUser(user, target));
    }

    /**
     * Updates the areas of this region.
     *
     * @param included the areas that make up the region
     * @param excluded the areas explicitly excluded from the region
     * @throws IllegalArgumentException if included or excluded is null, or included is empty
     */
    void update(@Nonnull List<Area> included, @Nonnull List<Area> excluded) throws IllegalArgumentException;
}