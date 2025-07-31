package minevalley.regions.api.residences;

import minevalley.regions.api.core.Region;
import minevalley.regions.api.structures.Street;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface PlotTile {

    /**
     * Every tile is associated with a region. This region defines the habitat in which the user is allowed to build.
     *
     * @return region this tile consists of.
     */
    @Nonnull
    @Contract(pure = true)
    Region region();

    /**
     * Gets the street on which the tile is located.
     *
     * @return street on which the tile is located
     */
    @Nonnull
    @Contract(pure = true)
    Street street();

    /**
     * Gets the house number of this tile
     *
     * @return house number as non-negative integer.
     */
    @Nonnegative
    @Contract(pure = true)
    int houseNumber();

    /**
     * Gets the amount of money, this tile is for sale.
     * If the tile is not for sale, this is -1.
     *
     * @return this tile sale, or -1
     */
    @Contract(pure = true)
    int getSale();

    /**
     * Each tile has a worth factor which is used to determine its selling price and the taxes the owner has to pay frequently.
     *
     * @return the tiles worth factor (0-1)
     */
    @Contract(pure = true)
    float worthFactor();

    /**
     * The plot defines the way this tile is merged with other tiles, is owned and maintained.
     *
     * @return plot.
     */
    @Nonnull
    @Contract(pure = true)
    Plot plot();
}
