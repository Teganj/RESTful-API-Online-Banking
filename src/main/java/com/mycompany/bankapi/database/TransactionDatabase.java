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

            Transaction lod1 = new Transaction(001, 111, "Credit", "Withdrawal", "", "John Smith", 20.0, "17/12/2021");
            Transaction lod2 = new Transaction(002, 112, "Debit", "Lodgement", "", "James Wright", 20.0, "17/12/2021");
            Transaction lod3 = new Transaction(003, 113, "Credit", "Transfer", "", "Sam Smith", 50.0, "17/12/2021");
            Transaction lod4 = new Transaction(004, 114, "Debit", "Withdrawal", "", "Rob Tierny", 60.0, "17/12/2021");
            Transaction lod5 = new Transaction(005, 115, "Credit", "Lodgement", "", "Hannah Carpenter", 20.0, "17/12/2021");
            Transaction lod6 = new Transaction(006, 116, "Debit", "Lodgement", "", "Sally Jones", 100.0, "17/12/2021");

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
