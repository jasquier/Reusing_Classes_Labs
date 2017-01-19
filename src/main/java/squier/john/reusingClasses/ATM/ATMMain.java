package squier.john.reusingClasses.ATM;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ATMMain {
    public static void main(String[] args) {

        // Create some accounts
        ATM.Account savings = new SavingsAccount(BankAccountType.SAVINGS, 100.0, "Alice", 1.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        ATM.Account checking = new CheckingAccount(BankAccountType.CHECKING, 50.0, "Bob", 0.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        ATM.Account investment = new InvestmentAccount(BankAccountType.INVESTMENT, 10000.0, "Eve", 10.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        // Put em in an array list
        ArrayList<ATM.Account> accounts = new ArrayList<>();
        accounts.add(savings);
        accounts.add(checking);
        accounts.add(investment);

        // Create the atm with the accounts
        ATM atm = new ATM(accounts);

        // Loop through and display everyone's balance and name
        System.out.println(atm.displayAccountNamesAndBalances());

        // Add a new account to the atm
        ATM.Account newAccount = new InvestmentAccount(BankAccountType.INVESTMENT, 0.0, "Steve", 10.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        atm.addAccountToAccounts(newAccount);

        // Display the new accounts
        System.out.println(atm.displayAccountNamesAndBalances());

        // Delete an account
        System.out.println("Removing steve");
        atm.removeAccountWithNameAndBalance("Steve", 0.0);

        // And print again
        System.out.println(atm.displayAccountNamesAndBalances());

        // Delete another account
        System.out.println("Removing Bob");
        atm.removeAccountWithNameAndBalance("Bob", 50.0);
        System.out.println(atm.displayAccountNamesAndBalances());

        // Change Alice's balance
        System.out.println("Change Alice's balance");
        atm.getAccounts().get(0).updateBalanceWithCreditOrDebit(-100.0);
        System.out.println(atm.displayAccountNamesAndBalances());
    }
}
