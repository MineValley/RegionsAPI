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
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@ApiStatus.Internal
public interface RegionsProvider {

    @Nullable
    @Contract(pure = true)
    Region getRegion(int id);

    @Nonnull
    @Contract(pure = true)
    List<Region> getRegions(@Nonnull Block block) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    Region createRegion(@Nonnull List<Area> included, @Nonnull List<Area> excluded) throws IllegalArgumentException;

    @Nullable
    @Contract(pure = true)
    Residence getResidence(int id);

    @Nullable
    @Contract("null -> null")
    Residence getResidence(@Nullable Region region);

    @Nonnull
    @Contract(pure = true)
    List<Residence> getResidences(@Nonnull Registrant registrant) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    List<Residence> getResidences();

    @Nullable
    @Contract(pure = true)
    Plot getPlot(int id);

    @Nullable
    @Contract(value = "null -> null", pure = true)
    PlotTile getPlotTile(@Nullable Region region);

    @Nullable
    @Contract(pure = true)
    Apartment getApartment(int id);

    @Nonnull
    @Contract(pure = true)
    List<ApartmentBlock> getApartmentBlocks();

    @Nonnull
    @Contract(pure = true)
    List<ApartmentBlock> getApartmentBlocks(@Nonnull RealEstateGroup realEstateGroup)
            throws IllegalArgumentException;

    @Nullable
    @Contract(pure = true)
    ApartmentBlock getApartmentBlock(int id);

    @Nonnull
    @Contract(pure = true)
    List<Street> getStreets();

    @Nullable
    @Contract(pure = true)
    Street getStreet(int id);

    @Nonnull
    @Contract(pure = true)
    List<District> getDistricts();

    @Nullable
    @Contract(pure = true)
    District getDistrict(int id);

    @Nullable
    @Contract("null -> null")
    District getDistrict(@Nullable Chunk chunk);

    @Nullable
    @Contract("null -> null")
    RadioMast getNearestRadioMast(@Nullable Location location);

    @Nonnull
    @Contract("_, _ -> new")
    Area getArea(@Nonnull Block loc1, @Nonnull Block loc2) throws IllegalArgumentException;

    void loadPreset(@Nonnull Area presetArea, @Nonnull Block presetPivot, @Nonnull Block mainWorldPivot)
            throws IllegalArgumentException, IllegalStateException;

    @Nonnull
    @Contract("_, _, _, _, _, _ -> new")
    Area moveArea(@Nonnull World world, @Nonnull Area sourceArea, int dx, int dy, int dz,
                  boolean moveEntities) throws IllegalArgumentException;
}
