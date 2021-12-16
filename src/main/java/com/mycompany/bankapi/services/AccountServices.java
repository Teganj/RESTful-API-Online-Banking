package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.database.AccountDatabase;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class AccountServices {

    private List<Account> list = new AccountDatabase().getAllAccounts();
    
    public List<Account> getAllAccountsByCustomerID(int v) {
        return list.get(CustomerID-1).getAccounts();
    }

    public Account getAccountByID(int account_id, int customer_id) {
        return list.get(account_id-1).getAccounts().get(customer_id-1);
    }

    public List<Account> getAllAccounts() {
        return list;
    }
    
    public Account createAccount(Account a, int a_id){
    
        
        Account newAccount = list.get(a_id-1);
        a.setAccountId(newAccount.getAccount().size() + 1);
	newAccount.addAccountToCustomer(a);
        
        
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(newAccount.getAccountId())+"/comments/"+String.valueOf(a.getAccountId()));
        System.out.println("Updated Message:"+a.printAccount());
	return a;
    }
}
