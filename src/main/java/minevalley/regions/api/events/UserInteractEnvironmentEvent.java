package minevalley.regions.api.events;

import lombok.AccessLevel;
import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import org.bukkit.block.Block;
import org.bukkit.event.Event;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserInteractEnvironmentEvent extends OnlineUserEvent {

    private final Block block;
    private final boolean nativelyInterrupted;
    private final Event underlyingEvent;

    @Getter(AccessLevel.NONE)
    private boolean overwrite;

    public UserInteractEnvironmentEvent(@Nonnull OnlineUser user, @Nonnull Block block, boolean nativelyInterrupted, @Nonnull Event underlyingEvent) {
        super(user);
        this.block = block;
        this.nativelyInterrupted = nativelyInterrupted;
        this.underlyingEvent = underlyingEvent;
        this.overwrite = nativelyInterrupted;
    }

    /**
     * Allows this event to be executed. This even overrides the internal regions decision.
     * <p>
     * <b>Note:</b> Other listeners might change the state of allowance after yours changing it.
     */
    public void allow() {
        overwrite = true;
    }

    /**
     * Prevents this event from being executed. This even overrides the internal regions decision.
     * <p>
     * <b>Note:</b> Other listeners might change the state of allowance after yours changing it.
     */
    public void deny() {
        overwrite = false;
    }

    /**
     * Gets whether this event will be executed
     * <p>
     * <b>Note:</b> Other listeners might change the state of allowance after yours checking it.
     *
     * @return true, if the event will be executed
     * @see #allow()
     * @see #deny()
     */
    public boolean isFinallyAllowed() {
        return overwrite;
    }
}