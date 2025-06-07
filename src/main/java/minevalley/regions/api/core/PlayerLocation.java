package minevalley.regions.api.core;

import javax.annotation.Nonnull;

public interface PlayerLocation {

    /**
     * Gets the name of this player location, that may be used to be displayed in the user's tab list.
     *
     * @return name as string
     */
    @Nonnull
    String name();
}