package squier.john.reusingClasses;

/**
 * Created by johnsquier on 1/18/17.
 */
public class CheckingAccount extends Account {

        public CheckingAccount(BankAccountType accountType, double balance, String accountHoldersName, double interestRate,
                               BankAccountStatus accountStatus, OverdraftProtection overdraftProtection) {

            super(accountType, balance, accountHoldersName, interestRate, accountStatus, overdraftProtection);
        }
}
