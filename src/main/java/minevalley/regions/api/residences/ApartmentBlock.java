package minevalley.regions.api.residences;

import minevalley.core.api.corporations.RealEstateGroup;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface ApartmentBlock extends ApartmentHolder {

    /**
     * Gets this apartment block's id that distinguishes it from other apartment blocks.
     *
     * @return apartment block's unique id
     */
    int id();

    /**
     * Gets this apartment block's owner. This might be a state-owned group.
     *
     * @return owner as {@link RealEstateGroup}
     */
    @Nonnull
    RealEstateGroup getOwner();

    /**
     * Gets the amount of floors in this apartment block.
     * <p>
     * <b>Note:</b> The lowest floor is always 0. If there are basement floors, the index of the first floor can be above 0
     *
     * @return amount of floors as an integer.
     */
    @Nonnegative
    @Contract(pure = true)
    int floors();

    /**
     * Get all apartments on a specific floor in this apartment block.
     *
     * @param floor floor to get the apartments on a given floor
     * @return list of all the apartments on the given floor
     * @throws IllegalArgumentException if the floor does not exist
     */
    @Nonnull
    @Contract(pure = true)
    List<Apartment> apartments(int floor) throws IndexOutOfBoundsException;
}
