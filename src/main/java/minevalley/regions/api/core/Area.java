package minevalley.regions.api.core;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public interface Area {

    /**
     * Gets the block with the smallest x, y, and z coordinates that is still contained within the area.
     *
     * @return the block with the smallest x, y, and z coordinates in the area
     */
    @Nonnull
    @Contract(pure = true)
    Block getMinBlock();

    /**
     * Gets the block with the highest x, y, and z coordinates that is still contained within the area.
     *
     * @return the block with the highest x, y, and z coordinates in the area
     */
    @Nonnull
    @Contract(pure = true)
    Block getMaxBlock();

    /**
     * Gets a list of all the blocks contained by this area.
     * <p>
     * <b>Note:</b> This method consumes quiet a lot of resources. Refrain from using it, when other methods work fine as well.
     *
     * @return list of all blocks contained by this area.
     * @see #contains(Block)
     */
    @Nonnull
    @Contract(pure = true)
    List<Block> getBlocks();

    /**
     * Gets a list of all the chunks, this area lies in.
     *
     * @return list of all the chunks this area lies in.
     */
    @Nonnull
    @Contract(pure = true)
    List<Chunk> getChunks();

    /**
     * Checks whether the given block is contained by the area.
     *
     * @param block block to check (might be null)
     * @return true, if the block is contained by the area.
     */
    @Contract(value = "null -> false", pure = true)
    boolean contains(@Nullable Block block);

    /**
     * Checks whether the given location is contained by the area.
     *
     * @param location location to check (might be null)
     * @return true, is the location is contained by the area.
     */
    @Contract(value = "null -> false", pure = true)
    default boolean contains(@Nullable Location location) {
        if (location == null) return false;
        return contains(location.getBlock());
    }
}
