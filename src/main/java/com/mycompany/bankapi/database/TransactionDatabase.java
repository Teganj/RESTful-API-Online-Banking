package com.mycompany.bankapi.database;

import com.mycompany.bankapi.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class TransactionDatabase {
        
    public static List<Transaction> transactionDB = new ArrayList<>();
    public static boolean init = true;

    public TransactionDatabase() {
        if (init) {

            Transaction lod1 = new Transaction (1, 123, "Credit", 1, "Withdrawal", "AIB", "AIB", 40.0);
            Transaction lod2 = new Transaction (1, 123, "Credit", 1, "Withdrawal", "AIB", "AIB", 40.0);
            Transaction lod3 = new Transaction (1, 123,  "Credit",1, "Withdrawal", "AIB", "AIB", 40.0);
            Transaction lod4 = new Transaction (1, 123,  "Credit",1, "Withdrawal", "AIB", "AIB", 40.0);
            Transaction lod5 = new Transaction (1, 123, "Credit", 1, "Withdrawal", "AIB", "AIB", 40.0);
            Transaction lod6 = new Transaction (1, 123, "Credit", 1, "Withdrawal", "AIB", "AIB", 40.0);

            transactionDB.add(lod1);
            transactionDB.add(lod2);
            transactionDB.add(lod3);
            transactionDB.add(lod4);
            transactionDB.add(lod5);
            transactionDB.add(lod6);
            init = false;
        }

    }

    public List<Transaction> getTransactionDB() {
        return transactionDB;
    }
}

