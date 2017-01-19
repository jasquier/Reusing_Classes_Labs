package squier.john.reusingClasses.ATM;

/**
 * Created by johnsquier on 1/18/17.
 */
public class InvestmentAccount extends Account {

    public InvestmentAccount(BankAccountType accountType, double balance, String accountHoldersName, double interestRate,
                             BankAccountStatus accountStatus, OverdraftProtection overdraftProtection) {

        super(accountType, balance, accountHoldersName, interestRate, accountStatus, overdraftProtection);
    }
}
