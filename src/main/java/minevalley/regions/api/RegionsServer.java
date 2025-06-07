package minevalley.regions.api;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.regions.api.residences.ApartmentBlock;
import minevalley.regions.api.residences.Residence;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Internal
public interface RegionsServer {

    Residence getResidence(int id);

    List<Residence> getResidences();

    List<Residence> getResidences(Registrant registrant);

    ApartmentBlock getApartmentBlock(int id);

    List<ApartmentBlock> getApartmentBlocks();

    List<ApartmentBlock> getApartmentBlocks(RealEstateGroup realEstateGroup);
}
