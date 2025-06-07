package minevalley.regions.api.core;

import minevalley.core.api.users.OnlineUser;
import minevalley.regions.api.residences.Residence;
import org.bukkit.Chunk;
import org.bukkit.Location;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface Region {

    /**
     * Gets this regions' id.
     *
     * @return id as integer
     */
    @Nonnegative
    int getId();

    /**
     * Gets a list of the areas that are included in the region.
     *
     * @return list of included areas
     */
    @Nonnull
    List<Area> getIncluded();

    /**
     * Gets a list of the areas that are excluded by the region.
     *
     * @return list of excluded areas
     */
    @Nonnull
    List<Area> getExcluded();

    /**
     * Gets a list with the chunks that this region lies in.
     *
     * @return list of chunks this region lies in
     */
    @Nonnull
    List<Chunk> getChunks();

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
     * Sets whether users are allowed to enter this region.
     * <p>
     * <b>Note:</b> This does not affect team members
     *
     * @param allow whether users may enter this region
     */
    void setAllowEnter(boolean allow);

    /**
     * Gets whether users are allowed to enter this region.
     * <p>
     * <b>Note:</b> This does not affect team members
     *
     * @return true, if users are allowed to enter this region
     * @see #setAllowEnter(boolean)
     */
    boolean isAllowedToEnter();

    /**
     * Gets the residence this region is used as, if existing.
     *
     * @return the residence this region is used as, if existing.
     */
    @Nullable
    Residence getResidence();

    /**
     * Updates the areas of this region.
     *
     * @param included the areas that make up the region
     * @param excluded the areas explicitly excluded from the region
     */
    void update(@Nonnull List<Area> included, @Nonnull List<Area> excluded);
}