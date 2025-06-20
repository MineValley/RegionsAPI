package minevalley.regions.api.events;

import lombok.Getter;
import lombok.Setter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import minevalley.regions.api.core.Region;
import org.bukkit.event.Cancellable;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters a region.
 */
@Getter
public class UserEnterRegionEvent extends OnlineUserEvent implements Cancellable {

    @Setter
    private boolean cancelled = false;

    /**
     * Region this user enters
     */
    private final Region region;

    public UserEnterRegionEvent(@Nonnull OnlineUser user, @Nonnull Region region) {
        super(user);
        this.region = region;
    }
}