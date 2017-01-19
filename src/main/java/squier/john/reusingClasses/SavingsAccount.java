package squier.john.reusingClasses;

/**
 * Created by johnsquier on 1/18/17.
 */
public class SavingsAccount extends Account {

    public SavingsAccount(BankAccountType accountType, double balance, String accountHoldersName, double interestRate,
                          BankAccountStatus accountStatus, OverdraftProtection overdraftProtection) {

        super(accountType, balance, accountHoldersName, interestRate, accountStatus, overdraftProtection);
    }
}
