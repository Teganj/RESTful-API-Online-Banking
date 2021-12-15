package com.mycompany.bankapi.services;

import com.mycompany.bankproject.models.Account;
import com.mycompany.bankproject.database.AccountDatabase;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class AccountServices {

    private List<Account> list = new AccountDatabase().getAllAccounts();
    
    public List<Account> getAllAccountsByCustomerID(int MessageID) {
        return list.get(account_id-1).getAccountId();
    }
    
    public Account getAccountByID(int account_id, int customer_id) {
        return list.get(account_id-1).getAccountId().get(customer_id-1);
    }

    public List<Account> getAllAccounts() {
        return accountslist;
    }
    
    public Account createAccount(Account a, int m_id){
    
        
        Account newAccount = list.get(m_id-1);
        a.setId(newAccount.getAccounts().size() + 1);
	newAccount.addCommentToMsg(a);
        
        
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(newAccount.getId())+"/comments/"+String.valueOf(a.getId()));
        System.out.println("Updated Message:"+a.printAccount());
	return a;
    }
}
