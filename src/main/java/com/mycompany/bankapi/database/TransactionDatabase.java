package com.mycompany.bankapi.database;

import com.mycompany.bankapi.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class TransactionDatabase {
        
    public static List<Transaction> transactionDB = new ArrayList<>();
    public static boolean init = true;

    public TransactionDatabase() {
        if (init) {

            Transaction lod1 = new Transaction (1, 123, 1, "Withdrawal", "AIB", "AIB" 40.0, "10.10.1999", "10am", true);
            Transaction lod2 = new Transaction ((1, 123, 1, "Withdrawal", "AIB", "AIB" 40.0, "10.10.1999", "10am", true);
            Transaction lod3 = new Transaction (1, 123, 1, "Withdrawal", "AIB", "AIB" 40.0, "10.10.1999", "10am", true);
            Transaction lod4 = new Transaction (1, 123, 1, "Withdrawal", "AIB", "AIB" 40.0, "10.10.1999", "10am", true);
            Transaction lod5 = new Transaction (1, 123, 1, "Withdrawal", "AIB", "AIB" 40.0, "10.10.1999", "10am", true);
            Transaction lod6 = new Transaction (1, 123, 1, "Withdrawal", "AIB", "AIB" 40.0, "10.10.1999", "10am", true);

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

