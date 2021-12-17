package com.mycompany.bankapi.database;

import com.mycompany.bankapi.models.Account;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class AccountDatabase {

    public static List<Account> accountDB = new ArrayList<>();
    public static boolean init = true;

    public AccountDatabase() {
        if (init) {

            Account acc1 = new Account(111, 1, "Credit", "AIB3892", "0012637353", 400.0);
            Account acc2 = new Account(112, 2, "Debit", "PTSB4973", "0007395734", 450.0);
            Account acc3 = new Account(113, 3, "Credit", "REV4802", "0006294722", 100.0);
            Account acc4 = new Account(114, 4, "Debit", "AIB3955", "0001285476", 150.0);
            Account acc5 = new Account(115, 5, "Credit", "PSTB2955", "0015874363", 80.0);
            Account acc6 = new Account(116, 6, "Debit", "BOI2994", "0000489595", 800.0);

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
