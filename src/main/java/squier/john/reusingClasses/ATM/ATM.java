package squier.john.reusingClasses.ATM;

import java.util.ArrayList;

/**
 * Created by johnsquier on 1/18/17.
 */
public class ATM {

    private ArrayList<ATM.Account> accounts;

    public ATM() {
        accounts = new ArrayList<ATM.Account>();
    }

    public ATM(ArrayList<ATM.Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<ATM.Account> getAccounts() { return accounts; }

    public String displayAccountNamesAndBalances() {
        StringBuilder stringBuilder = new StringBuilder(500);

        for ( ATM.Account a : accounts ) {
            stringBuilder.append("Name: ");
            stringBuilder.append(a.getAccountHoldersName());
            stringBuilder.append("  Balance: ");
            stringBuilder.append(a.getBalance() + "\n");
        }

        return stringBuilder.toString();
    }

    public void addAccountToAccounts(ATM.Account account) {
        accounts.add(account);
        return;
    }

    public void removeAccountWithNameAndBalance(String accountHoldersName, Double balance) {
        ATM.Account toRemove = null;

        for ( ATM.Account a : accounts ) {
            if ( a.getAccountHoldersName().equalsIgnoreCase(accountHoldersName)
                    && a.getBalance().equals(balance) ) {
                toRemove = a;
                break;
                // can we have multiple accts with the same name and balance?
                // probably...
            }
        }

        if ( !toRemove.equals(null) ) {
            accounts.remove(toRemove);
        }
    }
}
