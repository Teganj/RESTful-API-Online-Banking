package com.mycompany.bankapi.database;

import com.mycompany.bankapi.models.Account;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class AccountDatabase {

    public static List<Account> accountDB = new ArrayList<>();
    public static boolean init = true;

    public AccountDatabase() {
        if (init) {

            Account acc1 = new Account("", "", 111, 1, "Credit", "AIB3892", "0012637353", 400.0);
            Account acc2 = new Account("", "", 112, 2, "Debit", "PTSB4973", "0007395734", 450.0);
            Account acc3 = new Account("", "", 113, 3, "Credit", "REV4802", "0006294722", 100.0);
            Account acc4 = new Account("", "", 114, 4, "Debit", "AIB3955", "0001285476", 150.0);
            Account acc5 = new Account("", "", 115, 5, "Credit", "PSTB2955", "0015874363", 80.0);
            Account acc6 = new Account("", "", 116, 6, "Debit", "BOI2994", "0000489595", 800.0);
            Account acc7 = new Account("", "", 117, 7, "Debit", "BOI0192", "0154785854", 900.0);
            Account acc8 = new Account("", "", 118, 8, "Credit", "AIB4562", "0032569896", 100.0);
            Account acc9 = new Account("", "", 119, 9, "Credit", "PTSB7784", "0145415235", 650.0);
            Account acc10 = new Account("", "", 120, 10, "Debit", "PTSB4923", "0074898952", 80.0);
            Account acc11 = new Account("", "", 121, 11, "Debit", "REV9365", "0002125793", 140.0);
            Account acc12 = new Account("", "", 122, 12, "Debit", "REV1231", "0015452398", 180.0);
            Account acc13 = new Account("", "", 123, 13, "Credit", "REV7230", "0000548983", 200.0);
            Account acc14 = new Account("", "", 124, 14, "Debit", "REV2842", "0015485873", 360.0);
            Account acc15 = new Account("", "", 125, 15, "Credit", "AIB2943", "0326254893", 170.0);
            Account acc16 = new Account("", "", 126, 16, "Credit", "PTSB2494", "0124767632", 560.0);
            Account acc17 = new Account("", "", 127, 17, "Debit", "BOI0093", "00587478569", 760.0);
            Account acc18 = new Account("", "", 128, 18, "Credit", "BOI7244", "0098587321", 90.0);
            Account acc19 = new Account("", "", 129, 19, "Credit", "AIB1123", "0014785236", 230.0);
            Account acc20 = new Account("", "", 130, 20, "Debit", "AIB7339", "0009632587", 840.0);

            accountDB.add(acc1);
            accountDB.add(acc2);
            accountDB.add(acc3);
            accountDB.add(acc4);
            accountDB.add(acc5);
            accountDB.add(acc6);
            accountDB.add(acc7);
            accountDB.add(acc8);
            accountDB.add(acc9);
            accountDB.add(acc10);
            accountDB.add(acc11);
            accountDB.add(acc12);
            accountDB.add(acc13);
            accountDB.add(acc14);
            accountDB.add(acc15);
            accountDB.add(acc16);
            accountDB.add(acc17);
            accountDB.add(acc18);
            accountDB.add(acc19);
            accountDB.add(acc20);
            init = false;
        }

    }

    public List<Account> getAccountDB() {
        return accountDB;
    }
}
