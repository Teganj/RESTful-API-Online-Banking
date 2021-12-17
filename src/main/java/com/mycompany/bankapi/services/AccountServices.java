package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.database.AccountDatabase;
import com.mycompany.bankapi.database.CustomerDatabase;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class AccountServices {

    private List<Account> accountslist = new AccountDatabase().getAccountDB();
    private List<Customer> customerslist = new CustomerDatabase().getCustomerDB();

    public Customer getAllAccountsByCustomerID(int CustomerID) {
        Customer customer = null;
        for (int i = 0; i < customerslist.size(); i++) {
            if (customerslist.get(i).getCustomerId() == CustomerID) {
                customer = customerslist.get(i);
            }
        }
        return customer;
    }

    public Account getAccount(int AccountID) {
        Account account = null;
        for (int i = 0; i < accountslist.size(); i++) {
            if (accountslist.get(i).getAccountId() == AccountID) {
                account = accountslist.get(i);
            }
        }
        return account;
    }

    public Account getAccountByID(int AccountID, int CustomerID) {
        Account account = null;
        for (int i = 0; i < accountslist.size(); i++) {
            if (accountslist.get(i).getAccountId() == AccountID) {
                account = accountslist.get(i);
            }
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        return accountslist;
    }

    public Account createAccount(Account a) {
        a.setAccountId(accountslist.size() + 1);
        accountslist.add(a);
        System.out.println("201 - resource created with path: /account/" + String.valueOf(a.getAccountId()));
        System.out.println("Updated Customer:" + a.printAccount());
        return a;
    }
}
