package minevalley.regions.api;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.regions.api.residences.ApartmentBlock;
import minevalley.regions.api.residences.Residence;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Regions {

    private static RegionsServer server;

    /**
     * Gets all existing residences.
     *
     * @return list of all existing residences
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Residence> getResidences() {
        return server.getResidences();
    }

    /**
     * Gets all residences that are owned/rented by the given registrant.
     * <b>Note:</b> If a registrant owns a plot with apartments but does not explicitly rent them out, those apartments are not included in the returned list.
     *
     * @param registrant registrant to get the residences of
     * @return list of all residences owned/rented by the given registrant
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Residence> getResidences(@Nonnull Registrant registrant) {
        return server.getResidences(registrant);
    }

    /**
     * Gets the residence with the given id, if existing.
     *
     * @param id id to get residence from
     * @return residence with the given id
     */
    @Nullable
    @Contract(pure = true)
    public static Residence getResidence(int id) {
        return server.getResidence(id);
    }

    /**
     * Gets all existing apartment blocks.
     *
     * @return list of all existing apartment blocks
     */
    @Nonnull
    @Contract(pure = true)
    public static List<ApartmentBlock> getApartmentBlocks() {
        return server.getApartmentBlocks();
    }

    /**
     * Gets all apartment blocks that are owned by a given real estate group.
     *
     * @param realEstateGroup real estate group to the get their apartment blocks of
     * @return list of all the apartment blocks owned by the given real estate group
     * @throws IllegalArgumentException if the real estate group is null
     */
    @Nonnull
    @Contract(pure = true)
    public static List<ApartmentBlock> getApartmentBlocks(@Nonnull RealEstateGroup realEstateGroup) throws IllegalArgumentException {
        return server.getApartmentBlocks(realEstateGroup);
    }

    /**
     * Gets the apartment block with the given id, if existing.
     *
     * @param id id to get the apartment block from
     * @return apartment block with given id
     */
    @Nullable
    @Contract(pure = true)
    public static ApartmentBlock getApartmentBlock(int id) {
        return server.getApartmentBlock(id);
    }
}