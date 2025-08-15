package minevalley.regions.api.residences;

import minevalley.core.api.corporations.RealEstateGroup;
import minevalley.core.api.economy.BankAccount;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface ApartmentBlock {

    /**
     * Gets this apartment block's id that distinguishes it from other apartment blocks.
     *
     * @return apartment block's unique id
     */
    int id();

    /**
     * Gets this apartment block's owner. This might be a state-owned group.
     *
     * @return owner as {@link RealEstateGroup}
     */
    @Nonnull
    RealEstateGroup getOwner();

    /**
     * Transfers this apartment block to another real estate group.
     *
     * @param newOwner new owner of the apartment block
     * @throws IllegalArgumentException if the new owner is null
     */
    void transfer(@Nonnull RealEstateGroup newOwner) throws IllegalArgumentException;

    /**
     * Gets the bank account the owner selected for this apartment block.
     * This bank account might not be the primary bank account of the owner, but must be in his possession
     *
     * @return the bank account selected by the owner
     */
    @Nonnull
    @Contract(pure = true)
    BankAccount getOwnersBankAccount();

    /**
     * Sets the owners bank account
     * <p>
     * <b>Note:</b> This bank account must be in the owner's possession
     *
     * @param bankAccount bankAccount to set
     * @throws IllegalArgumentException if bankAccount is null or not in the owner's possession
     */
    void setOwnersBankAccount(@Nonnull BankAccount bankAccount) throws IllegalArgumentException;

    /**
     * Get all apartments that are part of this apartment block.
     *
     * @return list of all the apartments that are part of this apartment block.
     */
    @Nonnull
    @Contract(pure = true)
    List<Apartment> apartments();

    /**
     * Get all apartments on a specific floor in this apartment block.
     *
     * @param floor floor to get the apartments on a given floor
     * @return list of all the apartments on the given floor
     * @throws IllegalArgumentException if the floor does not exist
     */
    @Nonnull
    @Contract(pure = true)
    List<Apartment> apartments(int floor) throws IndexOutOfBoundsException;

    /**
     * Gets the amount of floors in this apartment block.
     * <p>
     * <b>Note:</b> The lowest floor is always 0. If there are basement floors, the index of the first floor can be above 0
     *
     * @return amount of floors as an integer.
     */
    @Nonnegative
    @Contract(pure = true)
    int floors();
}
