package minevalley.regions.api.residences;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Plot extends Residence {

    /**
     * Gets the house number of this plot
     *
     * @return house number as non-negative integer.
     */
    @Nonnegative
    @Contract(pure = true)
    int getHouseNumber();

    @Nonnull
    @Override
    @Contract(pure = true)
    default String getAddressShortcut() {
        return getStreet().getShortName() + getHouseNumber();
    }

    /**
     * Each plot has a worth factor which is used to determine its selling price and the taxes the owner has to pay frequently.
     *
     * @return the plots worth factor
     */
    @Contract(pure = true)
    float getWorthFactor();

    /**
     * The PlotMerge defines the way this plot is merged with other plots.
     *
     * @return this plots merge.
     */
    @Nonnull
    @Contract(pure = true)
    PlotMerge getPlotMerge();
}
