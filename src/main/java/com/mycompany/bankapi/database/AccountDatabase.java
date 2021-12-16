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
 
    
    public static List<Account> accountDB = new ArrayList<>();
    public static boolean init = true;

    public AccountDatabase() {
        if (init) {

            Account acc1 = new Account("", "", 1, 123, "dfg575", "wd1253", 40.0);
            Account acc2 = new Account("", "", 2, 123, "dfg575", "wd1253", 40.0);
            Account acc3 = new Account("", "", 3, 123, "dfg575", "wd1253", 40.0);
            Account acc4 = new Account("", "", 4, 123, "dfg575", "wd1253", 40.0);
            Account acc5 = new Account("", "", 5, 123, "dfg575", "wd1253", 40.0);
            Account acc6 = new Account("", "", 6, 123, "dfg575", "wd1253", 40.0);

            accountDB.add(acc1);
            accountDB.add(acc2);
            accountDB.add(acc3);
            accountDB.add(acc4);
            accountDB.add(acc5);
            accountDB.add(acc6);
            init = false;
        }

    }

    public List<Account> getAccountDB() {
        return accountDB;
    }
}
