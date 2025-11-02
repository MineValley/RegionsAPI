package minevalley.regions.api;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.regions.api.core.Area;
import minevalley.regions.api.core.Region;
import minevalley.regions.api.residences.*;
import minevalley.regions.api.structures.District;
import minevalley.regions.api.structures.RadioMast;
import minevalley.regions.api.structures.Street;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Regions {

    private static RegionsProvider provider;

    /**
     * Gets the region with the specific id.
     *
     * @param id regions id
     * @return region with specific id
     */
    @Nullable
    @Contract(pure = true)
    public static Region getRegion(int id) {
        return provider.getRegion(id);
    }

    /**
     * Gets the regions in which this block lies in.
     * <br>
     * <b>Note:</b> regions may overlap, that's why this method returns a list of regions.
     *
     * @param block block to get regions from
     * @return list of all regions in which this block lies in
     * @throws IllegalArgumentException if block is null
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Region> getRegions(@Nonnull Block block) throws IllegalArgumentException {
        return provider.getRegions(block);
    }

    /**
     * Gets the regions in which this location lies in.
     * <br>
     * <b>Note:</b> regions may overlap, that's why this method returns a list of regions.
     *
     * @param location location to get regions from
     * @return list of all regions in which this location lies in
     * @throws IllegalArgumentException if location is null
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Region> getRegions(@Nonnull Location location) throws IllegalArgumentException {
        return getRegions(location.getBlock());
    }

    /**
     * Creates a region with the specific parameters.
     *
     * @param included included areas
     * @param excluded excluded areas
     * @return region with the specific parameters
     * @throws IllegalArgumentException if the included or excluded areas are null or if the included areas are empty
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static Region createRegion(@Nonnull List<Area> included, @Nonnull List<Area> excluded) throws IllegalArgumentException {
        return provider.createRegion(included, excluded);
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
        return provider.getResidence(id);
    }

    /**
     * Gets the residence with the specific region.
     * <br>
     * <b>Note:</b> Not all regions are residences.
     *
     * @param region region to get residence from
     * @return residence with the specific region
     */
    @Nullable
    @Contract("null -> null")
    public static Residence getResidence(@Nullable Region region) {
        return provider.getResidence(region);
    }

    /**
     * Gets the dominant residence with the specific location.
     *
     * @param location location to get residence from
     * @return the most dominant residence in which the specific location lies in
     */
    @Nullable
    @Contract("null -> null")
    public static Residence getDominantResidence(@Nullable Location location) {
        if (location == null) return null;
        return getDominantResidence(location.getBlock());
    }

    /**
     * Gets the most dominant residence with the specific block.
     *
     * @param block block to get residence from
     * @return the most dominant residence in which the specific block lies in
     * @throws IllegalArgumentException if block is null
     */
    @Nullable
    @Contract("null -> null")
    public static Residence getDominantResidence(@Nullable Block block) throws IllegalArgumentException {
        return Optional.ofNullable((Residence) getApartment(block)).orElse(getPlot(block));
    }

    /**
     * Gets the residences in which this location lies in.
     * <br>
     * <b>Note:</b> residences may overlap, that's why this method returns a list of residences.
     *
     * @param location location to get residences from
     * @return stream of all residences in which this location lies in
     * @throws IllegalArgumentException if the location is null
     */
    @Nonnull
    @Contract(pure = true)
    public static Stream<Residence> getResidences(@Nonnull Location location) throws IllegalArgumentException {
        return getResidences(location.getBlock());
    }

    /**
     * Gets the residences in which this block lies in.
     * <br>
     * <b>Note:</b> residences may overlap, that's why this method returns a list of residences.
     *
     * @param block block to get residences from
     * @return stream of all residences in which this block lies in
     * @throws IllegalArgumentException if the block is null
     */
    @Nonnull
    @Contract(pure = true)
    public static Stream<Residence> getResidences(@Nonnull Block block) throws IllegalArgumentException {
        return getRegions(block).stream().map(Regions::getResidence).filter(Objects::nonNull);
    }

    /**
     * Gets all residences that are owned/rented by the given registrant.
     * <b>Note:</b> If a registrant owns a plot with apartments but does not explicitly rent them out, those apartments are not included in the returned list.
     *
     * @param registrant registrant to get the residences of
     * @return list of all residences owned/rented by the given registrant
     * @throws IllegalArgumentException if registrant is null
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Residence> getResidences(@Nonnull Registrant registrant) throws IllegalArgumentException {
        return provider.getResidences(registrant);
    }

    /**
     * Gets all existing residences.
     *
     * @return list of all existing residences
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Residence> getResidences() {
        return provider.getResidences();
    }

    /**
     * Gets the apartment block with the given id, if existing.
     *
     * @param id id to get the apartment block from
     * @return apartment block with given id
     */
    @Nullable
    @Contract(pure = true)
    public static Plot getPlot(int id) {
        return provider.getPlot(id);
    }

    /**
     * Gets the plot with the specific location.
     *
     * @param location location to get plot from
     * @return plot in which the specific location lies in
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    public static Plot getPlot(@Nullable Location location) {
        if (location == null) return null;
        return getPlot(location.getBlock());
    }

    /**
     * Gets the plot with the specific block.
     *
     * @param block block to get plot from
     * @return plot in which the specific block lies in
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    public static Plot getPlot(@Nullable Block block) {
        if (block == null) return null;
        return (Plot) (getResidences(block)).filter(r -> r instanceof Plot).findAny().orElse(null);
    }

    /**
     * Gets the plot tile for the given block.
     *
     * @param block block to get the plot tile from
     * @return plot tile for the given block
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    public static PlotTile getPlotTile(@Nullable Block block) {
        if (block == null) return null;
        return getRegions(block).stream().map(Regions::getPlotTile).filter(Objects::nonNull).findAny().orElse(null);
    }


    /**
     * Gets the plot tile for the given region.
     *
     * @param region region to get the plot tile from
     * @return plot tile for the given region
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    public static PlotTile getPlotTile(@Nullable Region region) {
        return provider.getPlotTile(region);
    }


    /**
     * Gets the apartment with the given id, if existing.
     *
     * @param id id to get the apartment from
     * @return apartment with given id
     */
    @Nullable
    @Contract(pure = true)
    public static Apartment getApartment(int id) {
        return provider.getApartment(id);
    }

    /**
     * Gets the apartment with the specific location.
     *
     * @param location location to get apartment from
     * @return apartment in which the specific location lies in
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    public static Apartment getApartment(@Nullable Location location) {
        if (location == null) return null;
        return getApartment(location.getBlock());
    }

    /**
     * Gets the apartment with the specific block.
     *
     * @param block block to get apartment from
     * @return apartment in which the specific block lies in
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    public static Apartment getApartment(@Nullable Block block) {
        if (block == null) return null;
        return (Apartment) getResidences(block).filter(r -> r instanceof Apartment).findAny()
                .orElse(null);
    }

    /**
     * Gets all existing apartment blocks.
     *
     * @return list of all existing apartment blocks
     */
    @Nonnull
    @Contract(pure = true)
    public static List<ApartmentBlock> getApartmentBlocks() {
        return provider.getApartmentBlocks();
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
    public static List<ApartmentBlock> getApartmentBlocks(@Nonnull RealEstateGroup realEstateGroup)
            throws IllegalArgumentException {
        return provider.getApartmentBlocks(realEstateGroup);
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
        return provider.getApartmentBlock(id);
    }

    /**
     * Gets all streets.
     *
     * @return list of all loaded plots
     */
    @Nonnull
    @Contract(pure = true)
    public static List<Street> getStreets() {
        return provider.getStreets();
    }

    /**
     * Gets the street with the specific id.
     *
     * @param id id of the street
     * @return street with the specific id
     */
    @Nullable
    @Contract(pure = true)
    public static Street getStreet(int id) {
        return provider.getStreet(id);
    }

    /**
     * Gets a list of all districts.
     *
     * @return list of all districts
     */
    @Nonnull
    @Contract(pure = true)
    public static List<District> getDistricts() {
        return provider.getDistricts();
    }

    /**
     * Gets the district with the specific id.
     *
     * @param id id of the district
     * @return district with the specific id
     */
    @Nullable
    @Contract(pure = true)
    public static District getDistrict(int id) {
        return provider.getDistrict(id);
    }


    /**
     * Gets the district that contains the given chunk
     *
     * @param chunk chunk to get district from
     * @return district that contains the given chunk
     */
    @Nullable
    @Contract("null -> null")
    public static District getDistrict(@Nullable Chunk chunk) {
        return provider.getDistrict(chunk);
    }

    /**
     * Gets the district that contains the given block
     *
     * @param block block to get district from
     * @return district that contains the given block
     */
    @Nullable
    @Contract("null -> null")
    public static District getDistrict(@Nullable Block block) {
        if (block == null) return null;
        return getDistrict(block.getChunk());
    }

    /**
     * Gets the district that contains the given location
     *
     * @param location location to get district from
     * @return district that contains the given location
     */
    @Nullable
    @Contract("null -> null")
    public static District getDistrict(@Nullable Location location) {
        if (location == null) return null;
        return getDistrict(location.getChunk());
    }

    /**
     * Gets the nearest radio mast to the specific location.
     * <br>
     * This may return null if the given location is null or no radio mast is found in the same world.
     *
     * @param location location to get the nearest radio mast from
     * @return nearest radio mast to the specific location
     */
    @Nullable
    @Contract("null -> null")
    public static RadioMast getNearestRadioMast(@Nullable Location location) {
        return provider.getNearestRadioMast(location);
    }

    /**
     * Gets an area object with the given locations.
     *
     * @param loc1 first location as block
     * @param loc2 second location as block
     * @return area with the given locations
     * @throws IllegalArgumentException if one of the blocks is null or if the locations are in different worlds
     */
    @Nonnull
    @Contract("_, _ -> new")
    public static Area getArea(@Nonnull Block loc1, @Nonnull Block loc2) throws IllegalArgumentException {
        return provider.getArea(loc1, loc2);
    }

    /**
     * Gets an area object with only one block.
     *
     * @param block block to create the area from
     * @return area consisting of the one specific block
     * @throws IllegalArgumentException if the block is null
     */
    @Nonnull
    @Contract("_ -> new")
    public static Area getAreaOfBlock(@Nonnull Block block) throws IllegalArgumentException {
        return provider.getArea(block, block);
    }

    /**
     * Loads the given area from the presets world to the main world.
     * <p>
     * <b>Note:</b> This method only works on the main server.
     *
     * @param presetArea     area to load
     * @param presetPivot    pivot of the area in the presets world
     * @param mainWorldPivot pivot of the area in the main world
     * @throws IllegalArgumentException if the area or pivot is null
     * @throws IllegalStateException    if the method is called on any server but the main server
     */
    public static void loadPreset(@Nonnull Area presetArea, @Nonnull Block presetPivot, @Nonnull Block mainWorldPivot)
            throws IllegalArgumentException, IllegalStateException {
        provider.loadPreset(presetArea, presetPivot, mainWorldPivot);
    }
}