package minevalley.regions.api.event;

import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.core.api.user.OnlineUserEvent;
import lombok.Getter;
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