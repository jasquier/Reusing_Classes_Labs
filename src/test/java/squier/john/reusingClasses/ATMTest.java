package squier.john.reusingClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ATMTest {

    ATM atm;
    ArrayList<Account> accounts;

    @Before
    public void setup() {
        accounts = new ArrayList<Account>();

        Account account1 = new SavingsAccount(
                BankAccountType.SAVINGS, 100.0, "John", 10.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        Account account2 = new CheckingAccount(BankAccountType.CHECKING, 50.0, "Alice", 0.0,
                BankAccountStatus.OPEN, OverdraftProtection.DISABLED);


        Account account3 = new InvestmentAccount(BankAccountType.INVESTMENT, 10000.0, "Bob", 15.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        atm = new ATM(accounts);
    }

    @Test
    public void getAccountsTest() {
        ArrayList<Account> expected = accounts;
        ArrayList<Account> actual = atm.getAccounts();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayAccountNamesAndBalancesTest() {
        String expected = "Name: John  Balance: 100.0\n"
                + "Name: Alice  Balance: 50.0\n"
                + "Name: Bob  Balance: 10000.0\n";
        String actual = atm.displayAccountNamesAndBalances();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAccountToAccountsTest() {
        Account expected = new SavingsAccount(BankAccountType.SAVINGS, 0.0, "John", 0.0,
                BankAccountStatus.OPEN, OverdraftProtection.ENABLED);
        atm.addAccountToAccounts(expected);
        Account actual = atm.getAccounts().get(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAccountWithNameAndBalanceTest() {
        // need to implement .equals in Account I believe
        ArrayList<Account> expected =  accounts;

        atm.removeAccountWithNameAndBalance("John", 0.0);

        ArrayList<Account> actual = atm.getAccounts();
    }
}
