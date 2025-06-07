package minevalley.regions.api.residences;

import minevalley.core.api.users.User;

import javax.annotation.Nonnull;
import java.util.Date;

/**
 * @param date   The date defines the day, this termination will <b>expire</b>. This should always be at least 14 days after the termination itself.
 *               There is no need to specify the day of the termination.
 * @param type   Defines whether this termination is made by the landlord (only available with apartments) or is set up by the system (e.g. by a team member).
 * @param reason Specific reason/description.
 * @param user   User who was responsible for this termination. This might be null, if the termination was set up by the system.
 */
@SuppressWarnings("ConstantValue")
public record Termination(@Nonnull Date date, @Nonnull Type type, @Nonnull String reason, @Nonnull User user) {

    public Termination {
        if (date == null) throw new IllegalArgumentException("date cannot be null");
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if (reason == null) throw new IllegalArgumentException("reason cannot be null");
        if (user == null) throw new IllegalArgumentException("user cannot be null");
    }

    enum Type {
        LANDLORD,
        STATE
    }
}