package minevalley.regions.api.residences;

import minevalley.regions.api.core.Region;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public interface PlotMerge {

    /**
     * Only the main plot does have a plot sign.
     *
     * @return the main plot of this plot merge.
     */
    @Nonnull
    @Contract(pure = true)
    Plot getMainPlot();

    /**
     * All plots that are merged in this PlotMerge including the main plot
     *
     * @return list of plots that are merged within this plot merge.
     */
    @Nonnull
    @Contract(pure = true)
    List<Plot> getPlots();

    /**
     * When plots are merged, there are tiny subregions between both plots that also need be added to the plot merge.
     *
     * @return list of all the regions that lie in between the merged plots.
     */
    @Nonnull
    @Contract(pure = true)
    List<Region> getMergeRegions();

    /**
     * Checks whether the given block is part of this plot merge region.
     *
     * @return true, if the block is part of the region that defines this plot merge
     */
    @Contract(value = "null -> false", pure = true)
    boolean contains(@Nullable Block block);

    /**
     * Checks whether the given location is part of this plot merge region.
     */
    @Contract(value = "null -> false", pure = true)
    boolean contains(@Nullable Location location);
}
