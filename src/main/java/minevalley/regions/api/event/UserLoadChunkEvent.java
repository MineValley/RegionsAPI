package minevalley.regions.api.event;

import lombok.Getter;
import minevalley.core.api.user.OnlineUser;
import minevalley.core.api.user.event.OnlineUserEvent;
import org.bukkit.Chunk;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLoadChunkEvent extends OnlineUserEvent {

    /**
     * Chunk the user loads
     */
    private final Chunk chunk;

    public UserLoadChunkEvent(@Nonnull OnlineUser user, @Nonnull Chunk chunk) {
        super(user);
        this.chunk = chunk;
    }
}