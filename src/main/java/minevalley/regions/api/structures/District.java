package minevalley.regions.api.structures;

import minevalley.core.api.localization.PlayerLocation;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface District extends PlayerLocation {

    /**
     * Gets this district's id.
     *
     * @return id as integer
     */
    @Contract(pure = true)
    int getId();

    /**
     * Gets a stream of all the chunks that make up this district.
     *
     * @return chunks that make up this district as {@link Stream}
     */
    @Nonnull
    @Contract(pure = true)
    Stream<Chunk> getChunks();

    /**
     * Gets the description of this district.
     *
     * @return description as string
     */
    @Nullable
    @Contract(pure = true)
    String getDescription();

    /**
     * Gets all users inside the district.
     *
     * @return all users inside the district as {@link Stream}
     */
    @Nonnull
    Stream<OnlineUser> getUsersInDistrict();
}
