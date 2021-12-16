package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.database.AccountDatabase;
import com.mycompany.bankapi.database.CustomerDatabase;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class AccountServices {

    private List<Account> accountslist = new AccountDatabase().getAccountDB();
    private List<Customer> customerslist = new CustomerDatabase().getCustomerDB();

    public List<Account> getAllAccountsByCustomerID(int CustomerID) {
        return customerslist.get(CustomerID - 1).getAccounts();
    }

    public Account getAccountByID(int AccountID, int CustomerID) {
        return customerslist.get(AccountID - 1).getAccounts().get(CustomerID - 1);
    }

    public List<Account> getAllAccounts() {
        return accountslist;
    }

    public Account createAccount(Account a, int a_id) {

        Customer newCustomer = customerslist.get(a_id - 1);
        a.setAccountId(newCustomer.getAccounts().size() + 1);
        newCustomer.addAccountToCustomer(a);

        System.out.println("201 - resource created with path: /customers/" + String.valueOf(newCustomer.getCustomerId()) + "/comments/" + String.valueOf(a.getAccountId()));
        System.out.println("Updated Message:" + a.printAccount());
        return a;
    }
}
