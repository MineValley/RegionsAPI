package minevalley.regions.api.residences;

import minevalley.core.api.users.User;

import javax.annotation.Nonnull;
import java.util.Date;

/**
 * @param date       Timestamp of creation.
 * @param expiration Timestamp of expiration of this warning.
 *                   <p>
 *                   If the expiration-date is reached, there is a message sent to the team, to check whether the warning is still justified.
 *                   If necessary, the residence will be reset.
 * @param text       Each warning consists of a text explaining what has to be changed.
 * @param teamler    Teamler that created this warning.
 */
@SuppressWarnings("ConstantValue")
public record Warning(@Nonnull Date date, @Nonnull Date expiration, @Nonnull String text, @Nonnull User teamler) {

    public Warning {
        if (date == null) throw new IllegalArgumentException("date cannot be null");
        if (expiration == null) throw new IllegalArgumentException("expiration cannot be null");
        if (expiration.before(date)) throw new IllegalArgumentException("Expiration time is after date");
        if (text == null) throw new IllegalArgumentException("text cannot be null");
        if (teamler == null) throw new IllegalArgumentException("teamler cannot be null");
    }
}