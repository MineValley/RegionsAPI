package eu.minevalley.regions.api.event;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.core.api.user.OnlineUserEvent;
import eu.minevalley.regions.api.structure.District;
import lombok.Getter;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters a district.
 */
@Getter
@SuppressWarnings("unused")
public class UserEnterDistrictEvent extends OnlineUserEvent {

    /**
     * District the user enters.
     */
    private final District district;

    public UserEnterDistrictEvent(@Nonnull OnlineUser user, @Nonnull District district) {
        super(user);
        this.district = district;
    }
}