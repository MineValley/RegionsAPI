package minevalley.regions.api.event;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.core.api.user.OnlineUserEvent;
import lombok.Getter;
import lombok.Setter;
import minevalley.regions.api.core.Region;
import org.bukkit.event.Cancellable;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters a region.
 */
@Getter
@SuppressWarnings("unused")
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