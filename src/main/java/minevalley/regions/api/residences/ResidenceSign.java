package minevalley.regions.api.residences;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public record ResidenceSign(@Nonnull Block block, @Nonnull BlockFace blockFace) {

}