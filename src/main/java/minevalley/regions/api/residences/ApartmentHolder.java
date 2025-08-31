package minevalley.regions.api.residences;

import minevalley.core.api.economy.BankAccount;
import minevalley.regions.api.structures.Street;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface ApartmentHolder {

    /**
     * Every apartment holder is associated with a street.
     *
     * @return this residences' street.
     */
    @Nonnull
    @Contract(pure = true)
    Street street();

    /**
     * Get all apartments that are part of this estate.
     *
     * @return list of all the apartments that are part of this apartment block.
     */
    @Nonnull
    @Contract(pure = true)
    List<Apartment> apartments();

    /**
     * Gets the bank account the owner selected for this apartment block.
     * This bank account might not be the primary bank account of the owner, but must be in his possession
     *
     * @return the bank account selected by the owner
     */
    @Nonnull
    @Contract(pure = true)
    BankAccount getOwnersBankAccount();
}
