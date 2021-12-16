package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.database.AccountDatabase;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class AccountServices {

    AccountDatabase db = new AccountDatabase();
    private List<Account> list = db.getAccountDB();

    public List<Account> getAllAccounts() {
        return list;
    }

    public Account getAccount(int account_id) {
        return list.get(account_id - 1);
    }

    public Account createMessage(Account m) {
        m.setAccountId(list.size() + 1);
        list.add(m);
        System.out.println("201 - resource created with path: /accounts/" + String.valueOf(m.getAccountId()));
        System.out.println("Updated Message:" + m.printAccount());
        return m;
    }

    public List<Account> getSearchMessages(String account, String customer) {
        List<Account> matcheslist = new ArrayList<>();

        for (Account q : getAllAccounts()) {
            if ((account == null || q.getAccount().equals(account))
                    && (customer == null || q.getCustomer().equals(customer))) {
                matcheslist.add(q);
            }
        }
        return matcheslist;
    }

}
