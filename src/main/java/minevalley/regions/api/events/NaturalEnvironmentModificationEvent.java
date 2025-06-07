package minevalley.regions.api.events;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class NaturalEnvironmentModificationEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final Block block;
    private final boolean nativelyInterrupted;
    private final Event underlyingEvent;

    @Getter(AccessLevel.NONE)
    private boolean overwrite;

    public NaturalEnvironmentModificationEvent(@Nonnull Block block, boolean nativelyInterrupted, @Nonnull Event underlyingEvent) {
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

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @Nonnull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

}