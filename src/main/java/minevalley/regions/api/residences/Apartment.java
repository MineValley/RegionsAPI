package minevalley.regions.api.residences;

import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.core.api.economy.BankAccount;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface Apartment extends Residence {

    /**
     * Every apartment has a number. These numbers are meant to distinguish the apartment from the others of the same apartment block.
     * Apartment numbers are assigned incrementally and are non-unique other the scope of an apartment block!
     * To distinguish this apartment from others, use region ids!
     *
     * @return number of this apartment
     */
    int getApartmentNumber();

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
     * Gets the landlord of this apartment.
     * The landlord might be a state-company.
     *
     * @return landlord as {@link RealEstateGroup}
     */
    @Nonnull
    RealEstateGroup getLandlord();

    /**
     * Sets this apartment's landlord.
     *
     * @param landlord landlord to be set
     * @throws IllegalArgumentException if the landlord is null
     */
    void setLandlord(@Nonnull RealEstateGroup landlord) throws IllegalArgumentException;

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
     * Sets the landlord's bank account.
     * <p>
     * <b>Note:</b> This bank account must be in the landlord's possession
     *
     * @param bankAccount bankAccount to set
     * @throws IllegalArgumentException if bankAccount is null or not in the landlord's possession
     * @see #getLandLordBankAccount()
     */
    void setLandlordBankAccount(@Nonnull BankAccount bankAccount) throws IllegalArgumentException;

    /**
     * Gets this apartment's rent
     *
     * @return rent as positive integer
     */
    @Nonnegative
    @Contract(pure = true)
    int getRent();

    /**
     * Changes the rent of this apartment.
     * The rent must be a positive (excluding zero) value
     *
     * @param rent rent in euros
     * @throws IllegalArgumentException if rent is negative or zero
     */
    void changeRent(@Nonnegative int rent) throws IllegalArgumentException;

    /**
     * Gets the apartment block this apartment belongs to, if it does.
     *
     * @return this apartments apartment block, if existing.
     */
    @Nullable
    @Contract(pure = true)
    ApartmentBlock getApartmentBlock();
}
