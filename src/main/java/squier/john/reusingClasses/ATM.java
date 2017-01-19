package squier.john.reusingClasses;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ATM {

    private ArrayList<Account> accounts;

    public ATM() {
        accounts = new ArrayList<Account>();
    }

    public ATM(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Account> getAccounts() { return accounts; }

    public String displayAccountNamesAndBalances() {
        StringBuilder stringBuilder = new StringBuilder(500);

        for ( Account a : accounts ) {
            stringBuilder.append("Name: ");
            stringBuilder.append(a.getAccountHoldersName());
            stringBuilder.append("  Balance: ");
            stringBuilder.append(a.getBalance() + "\n");
        }

        return stringBuilder.toString();
    }
}
