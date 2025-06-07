package minevalley.regions.api.residences;

import minevalley.core.api.mail.Parcel;
import minevalley.core.api.users.OnlineUser;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Mailbox {

    /**
     * This gets a copy of the list of all contents, that are already put into the mailbox by mailmen or other players.
     * Users with access-permission can collect those contents.
     * Items in this array haven't been collected so far.
     * Since this is a copy of the original list, changes on the array don't have any influence on ingame actions.
     * use the add(), clear() and remove() methods.
     *
     * @return list of the parcels in this mailbox
     */
    @Nonnull
    List<Parcel> getContents();

    /**
     * Adds a parcel to this mailbox. It's itemstack will be added to the getContents-array.
     *
     * @param parcel parcel to add to this mailbox.
     */
    void add(@Nonnull Parcel parcel);

    /**
     * Removes a specific parcel from the mailbox content list.
     *
     * @param parcel to delete
     * @param user   target of the parcel
     */
    void remove(@Nonnull Parcel parcel, @Nonnull OnlineUser user);

    /**
     * This clears the whole contents list. Regardless of the previous content, the mailbox is now empty.
     */
    void clear();
}
