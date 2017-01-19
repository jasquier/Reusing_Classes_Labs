package squier.john.reusingClasses;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ATMMain {
    public static void main(String[] args) {

        // Declare some accounts
        Account savings = new SavingsAccount(BankAccountType.SAVINGS, 100.0, "Alice", 1.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        Account checking = new CheckingAccount(BankAccountType.CHECKING, 50.0, "Bob", 0.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        Account investment = new InvestmentAccount(BankAccountType.INVESTMENT, 10000.0, "Eve", 10.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        // Put em in an array list
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(savings);
        accounts.add(checking);
        accounts.add(investment);

        // Create the atm with the accounts
        ATM atm = new ATM(accounts);

        // Loop through and display everyone's balance and name
        System.out.println(atm.displayAccountNamesAndBalances());

        // Add a new account to the atm
        Account newAccount = new InvestmentAccount(BankAccountType.INVESTMENT, 0.0, "Steve", 10.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

    }
}
