package minevalley.regions.api.residences;

import minevalley.core.api.Registrant;
import minevalley.core.api.banking.BankAccount;
import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.regions.api.core.Region;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface Apartment extends Residence {

    /**
     * Every apartment is associated with a region. This region defines the habitat in which the user is allowed to build.
     *
     * @return apartment this residence consists of.
     */
    @Nonnull
    @Contract(pure = true)
    Region region();

    /**
     * Gets the landlord of this apartment.
     * The landlord might be a state-company.
     *
     * @return landlord as {@link RealEstateGroup}
     */
    @Nonnull
    @Contract(pure = true)
    RealEstateGroup getLandlord();

    /**
     * Gets the bank account that is selected by the landlord.
     * This bank account is used for all apartment-related expenses not covered by the renter and receives all rent payments.
     * This bankaccount might not be the primary bank account of the landlord, but must be in his possession
     *
     * @return landlord's bank account.
     */
    @Nonnull
    @Contract(pure = true)
    BankAccount getLandLordBankAccount();

    /**
     * Gets the registrant that rents this apartment. This is null, when the apartment is not rented.
     *
     * @return renter
     */
    @Nullable
    @Contract(pure = true)
    Registrant getRenter();

    /**
     * Gets the bank account that is selected by the renter for paying their rent. This is null, if the apartment is not rented.
     *
     * @return renter's bank account to pay their rent.
     */
    @Nullable
    @Contract(pure = true)
    BankAccount getRenterBankAccount();

    /**
     * Gets this apartment's rent
     *
     * @return rent as positive integer
     */
    @Nonnegative
    @Contract(pure = true)
    int getRent();

    /**
     * Gets whether this apartment is only rentable by premium users.
     * This comes with some special characteristics:
     * <p>
     * Premium-only apartments...
     * <ul>
     *     <li>cannot be rented by groups</li>
     *     <li>are automatically terminated when the user loses their premium rank</li>
     *     <li>always have a state-owned landlord</li>
     * </ul>
     *
     * @return true, if the apartment is premium-only
     */
    boolean isPremiumOnly();

    /**
     * Gets the apartment holder this apartment belongs to, if it does.
     * <ul>
     *     <li>This might be an apartment block this apartment belongs to</li>
     *     <li>...or a plot on which this apartment lies on</li>
     * </ul>
     *
     * @return apartment holder this apartment belongs to
     */
    @Nonnull
    @Contract(pure = true)
    ApartmentHolder getHolder();
}
