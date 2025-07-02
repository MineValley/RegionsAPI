package minevalley.regions.api.residences;

import minevalley.core.api.Registrant;
import minevalley.regions.api.structures.Street;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Plot extends Residence {

    /**
     * Gets the street on which the plot is located.
     *
     * @return street on which the plot is located
     */
    @Nonnull
    @Contract(pure = true)
    Street street();

    /**
     * Gets the house number of this plot
     *
     * @return house number as non-negative integer.
     */
    @Nonnegative
    @Contract(pure = true)
    int houseNumber();

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
     * Gets the amount of money, this plot is for sale.
     * If the plot is not for sale, this is -1.
     *
     * @return this plots sale, or -1
     */
    @Contract(pure = true)
    int getSale();

    /**
     * Each plot has a worth factor which is used to determine its selling price and the taxes the owner has to pay frequently.
     *
     * @return the plots worth factor (0-1)
     */
    @Contract(pure = true)
    float worthFactor();

    /**
     * The PlotMerge defines the way this plot is merged with other plots.
     *
     * @return this plots merge.
     */
    @Nonnull
    @Contract(pure = true)
    PlotMerge plotMerge();
}
