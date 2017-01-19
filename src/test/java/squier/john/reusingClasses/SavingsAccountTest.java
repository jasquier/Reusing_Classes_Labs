package squier.john.reusingClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import squier.john.reusingClasses.*;


/**
 * Created by johnsquier on 1/17/17.
 */
public class SavingsAccountTest {

    Account bankAccount;
    double delta = 0.00001;

    @Test
    public void getBalanceAccountUnfrozenTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        Double expected = 100.0;
        Double actual = bankAccount.getBalance();
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void getBalanceAccountFrozenTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OFAC_FROZEN,
                OverdraftProtection.ENABLED);

        // using null to indicate frozen acct status
        Double actual = bankAccount.getBalance();
        Assert.assertNull(actual);
    }

    @Test
    public void getAccountHoldersNameTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OFAC_FROZEN,
                OverdraftProtection.ENABLED);

        String expected = "John";
        String actual = bankAccount.getAccountHoldersName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAccountHoldersNameOpenTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        String expected = "Bob";
        bankAccount.setAccountHoldersName("Bob");
        String actual = bankAccount.getAccountHoldersName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAccountHoldersNameClosedTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.CLOSED,
                OverdraftProtection.ENABLED);

        String expected = "John";
        bankAccount.setAccountHoldersName("Bob");
        String actual = bankAccount.getAccountHoldersName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateBalanceAccountClosedTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.CLOSED,
                OverdraftProtection.ENABLED);

        Double expected = 100.0;
        bankAccount.updateBalanceWithCreditOrDebit(5.0);
        Double actual = bankAccount.getBalance();
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void updateBalancePositiveTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        Double expected = 200.0;
        bankAccount.updateBalanceWithCreditOrDebit(100.0);
        Double actual = bankAccount.getBalance();
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void updateBalanceNegativeTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        Double expected = 50.0;
        bankAccount.updateBalanceWithCreditOrDebit(-50.0);
        Double actual = bankAccount.getBalance();
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void updateBalanceZeroTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        ApprovalStatus expected = ApprovalStatus.ZERO_TRANSACTION;
        ApprovalStatus actual = bankAccount.updateBalanceWithCreditOrDebit(0.0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transferBalanceFromTestBothEndAboveZeroTest() {
        SavingsAccount transferFrom = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);
        SavingsAccount transferTo = new SavingsAccount(BankAccountType.CHECKING, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        transferTo.transferBalanceFrom(transferFrom, 50.0);

        Double[] expected = {150.0, 50.0};
        Double[] actual = {transferTo.getBalance(), transferFrom.getBalance()};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void transferBalanceToTestBothEndAboveZeroTest() {
        SavingsAccount transferFrom = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);
        SavingsAccount transferTo = new SavingsAccount(BankAccountType.CHECKING, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        transferFrom.transferBalanceTo(transferTo, 50.0);

        Double[] expected = {150.0, 50.0};
        Double[] actual = {transferTo.getBalance(), transferFrom.getBalance()};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void transferBalanceFromTestNotEnoughInFromTest() {
        SavingsAccount transferFrom = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);
        SavingsAccount transferTo = new SavingsAccount(BankAccountType.CHECKING, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        transferTo.transferBalanceFrom(transferFrom, 500.0);

        Double[] expected = {100.0, 100.0};
        Double[] actual = {transferTo.getBalance(), transferFrom.getBalance()};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void transferBalanceToTestNotEnoughInFromTest() {
        SavingsAccount transferFrom = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);
        SavingsAccount transferTo = new SavingsAccount(BankAccountType.CHECKING, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        transferFrom.transferBalanceTo(transferTo, 500.0);

        Double[] expected = {100.0, 100.0};
        Double[] actual = {transferTo.getBalance(), transferFrom.getBalance()};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void overdrawWithProtectionOnTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        Double expected = 100.0;
        bankAccount.updateBalanceWithCreditOrDebit(-500.0);
        Double actual = bankAccount.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void overdrawWithProtectOffTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.DISABLED);

        Double expected = -400.0;
        bankAccount.updateBalanceWithCreditOrDebit(-500.0);
        Double actual = bankAccount.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBankAccountStatusTest() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 100.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.OPEN;
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusClosedFromOpen() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.CLOSED;
        bankAccount.setAccountStatus(BankAccountStatus.CLOSED);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusClosedFromFrozen() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.OFAC_FROZEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.CLOSED;
        bankAccount.setAccountStatus(BankAccountStatus.CLOSED);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusOpenFromFrozen() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.OFAC_FROZEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.OPEN;
        bankAccount.setAccountStatus(BankAccountStatus.OPEN);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusOpenFromClosed() {
        // needs to fail
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.CLOSED,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.CLOSED;
        bankAccount.setAccountStatus(BankAccountStatus.OPEN);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusFrozenFromOpen() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.OFAC_FROZEN;
        bankAccount.setAccountStatus(BankAccountStatus.OFAC_FROZEN);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusFrozenFromClosed() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.CLOSED,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.CLOSED;
        bankAccount.setAccountStatus(BankAccountStatus.OFAC_FROZEN);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusClosedWithZeroBalance() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 0.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.CLOSED;
        bankAccount.setAccountStatus(BankAccountStatus.CLOSED);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBankAccountStatusClosedWithNonZeroBalance() {
        bankAccount = new SavingsAccount(BankAccountType.SAVINGS, 10.0,
                "John", 10.0, BankAccountStatus.OPEN,
                OverdraftProtection.ENABLED);

        BankAccountStatus expected = BankAccountStatus.OPEN;
        bankAccount.setAccountStatus(BankAccountStatus.CLOSED);
        BankAccountStatus actual = bankAccount.getAccountStatus();
        Assert.assertEquals(expected, actual);
    }
}
