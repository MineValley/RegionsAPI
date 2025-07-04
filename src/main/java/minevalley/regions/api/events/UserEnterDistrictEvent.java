package minevalley.regions.api.events;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import minevalley.regions.api.structures.District;

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