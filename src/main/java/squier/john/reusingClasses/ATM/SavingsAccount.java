package squier.john.reusingClasses.ATM;

import squier.john.reusingClasses.ATM.ATM;
import squier.john.reusingClasses.ATM.BankAccountStatus;
import squier.john.reusingClasses.ATM.BankAccountType;
import squier.john.reusingClasses.ATM.OverdraftProtection;

/**
 * Created by johnsquier on 1/18/17.
 */
public class SavingsAccount extends Account {

    public SavingsAccount(BankAccountType accountType, double balance, String accountHoldersName, double interestRate,
                          BankAccountStatus accountStatus, OverdraftProtection overdraftProtection) {

        super(accountType, balance, accountHoldersName, interestRate, accountStatus, overdraftProtection);
    }
}
