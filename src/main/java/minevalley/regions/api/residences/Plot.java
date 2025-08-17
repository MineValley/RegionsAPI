package minevalley.regions.api.residences;

import minevalley.core.api.Registrant;
import minevalley.regions.api.core.Region;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public interface Plot extends Residence, ApartmentHolder {

    /**
     * Only the main tile does have a plot sign.
     *
     * @return the main plot of this plot merge.
     */
    @Nonnull
    @Contract(pure = true)
    PlotTile getMainTile();

    /**
     * All tiles that are merged in this Plot including the main tile.
     *
     * @return list of tiles that are merged within this plot.
     */
    @Nonnull
    @Contract(pure = true)
    List<PlotTile> getTiles();

    /**
     * When tiles are merged, there are tiny subregions between them that need be added to the plot.
     *
     * @return list of all the regions that lie in between the merged tiles.
     */
    @Nonnull
    @Contract(pure = true)
    List<Region> getMergeRegions();

    /**
     * Gets the owner of this plot.
     * <p>
     * Plots for sale keep their owner until they are bought. To check, whether a plot is for sale, check the getSale()-method.
     *
     * @return plot owner.
     */
    @Nonnull
    @Contract(pure = true)
    Registrant getOwner();

    /**
     * Checks whether the given tile is part of this plot.
     *
     * @return true, if the tile is part of this plot, false otherwise.
     */
    @Contract(value = "null -> false", pure = true)
    boolean contains(@Nullable PlotTile block);
}
