package minevalley.regions.api.core;

import minevalley.core.api.localization.PlayerLocation;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Locality extends PlayerLocation {

    /**
     * Gets the region that this locality is associated with.
     *
     * @return associated region
     */
    @Nonnull
    Region region();

    /**
     * Gets the block that this localities sign is placed on.
     *
     * @return block underneath the locality sign
     */
    @Nonnull
    Block signLocation();

    /**
     * Gets the orientation of the sign as a direction.
     *
     * @return sign rotation as direction
     */
    @Nonnull
    Direction signRotation();

    /**
     * Localities may overlap so it is crucial to be able to prioritize which locality is applied in such cases.
     * The locality with the highest priority is applied.
     *
     * @return priority of this locality
     */
    int priority();
}
