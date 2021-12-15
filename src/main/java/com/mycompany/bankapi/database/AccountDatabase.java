package com.mycompany.bankapi.database;

import com.mycompany.bankapi.models.Account;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Gavin Corr x18382836
 * @author Tegan Jennings x18303941
 * @author Eugene Omondi x18425924
 */
public class AccountDatabase {
 
    
     public static List<Account> list = new ArrayList<>();
    public static boolean init = true;

    public AccountDatabase() {
        if (init) {

            Account acc1 = new Account(1, 123, "dfg575", "wd1253", 40.0);
            Account acc2 = new Account(2, 123, "dfg575", "wd1253", 40.0);
            Account acc3 = new Account(3, 123, "dfg575", "wd1253", 40.0);
            Account acc4 = new Account(4, 123, "dfg575", "wd1253", 40.0);
            Account acc5 = new Account(5, 123, "dfg575", "wd1253", 40.0);
            Account acc6 = new Account(6, 123, "dfg575", "wd1253", 40.0);

            list.add(acc1);
            list.add(acc2);
            list.add(acc3);
            list.add(acc4);
            list.add(acc5);
            list.add(acc6);
            init = false;
        }

    }

    public List<Account> getAllAccounts() {
        return list;
    }

    public Account getAccount(int id) {
        return list.get(id - 1);
    }

    public Account creatAccount(Account a) {
        a.setAccountId(list.size() + 1);
        list.add(a);
        System.out.println("201 - resource created with path: /accounts/" + String.valueOf(a.getAccountId()));
        System.out.println("Updated Message:" + a.printAccount());
        return a;
    }

    public List<Account> getSearchAccounts(int account_id, int customer_id) {
        List<Account> matcheslist = new ArrayList<>();

        for (Account a : getAllAccounts()) {

            matcheslist.add(a);
        }

        return matcheslist;
    }
}
