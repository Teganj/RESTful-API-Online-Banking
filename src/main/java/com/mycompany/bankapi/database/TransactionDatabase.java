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

            Transaction lod1 = new Transaction(1, 111, "Credit", 001, "Withdrawal", "", "John Smith", 20);
            Transaction lod2 = new Transaction(2, 112, "Debit", 002, "Lodgement", "", "James Wright", 20);
            Transaction lod3 = new Transaction(3, 113, "Credit", 003, "Transfer", "", "Sam Smith", 50);
            Transaction lod4 = new Transaction(4, 114, "Debit", 004, "Withdrawal", "", "Rob Tierny", 60);
            Transaction lod5 = new Transaction(5, 115, "Credit", 005, "Lodgement", "", "Hannah Carpenter", 20);
            Transaction lod6 = new Transaction(6, 116, "Debit", 006, "Lodgement", "", "Sally Jones", 100);
            Transaction lod7 = new Transaction(7, 117, "Debit", 007, "Transfer", "", "Susan Byrne", 500);
            Transaction lod8 = new Transaction(8, 18, "Credit", 011, "Withdrawal", "", "Jack Murphy", 70);
            Transaction lod9 = new Transaction(9, 119, "Credit", 012, "Transfer", "", "Kelly Keogh", 150);
            Transaction lod10 = new Transaction(10, 120, "Debit", 013, "Withdrawal", "", "Fiona Hannigan", 60);
            Transaction lod11 = new Transaction(11, 121, "Debit", 014, "Transfer", "", "Andrew Burke", 50);
            Transaction lod12 = new Transaction(12, 122, "Debit", 015, "Transfer", "", "Jason Gilligan", 40);
            Transaction lod13 = new Transaction(13, 123, "Credit", 016, "Lodgement", "", "Patricia Hannon", 40);
            Transaction lod14 = new Transaction(14, 124, "Debit", 017, "Lodgement", "", "Karen Carr", 140);
            Transaction lod15 = new Transaction(15, 125, "Credit", 021, "Lodgement", "", "Lauren Dunne", 70);
            Transaction lod16 = new Transaction(16, 126, "Credit", 022, "Withdrawal", "", "Josh Martin", 130);
            Transaction lod17 = new Transaction(17, 127, "Debit", 023, "Transfer", "", "Paul Long", 110);
            Transaction lod18 = new Transaction(18, 128, "Credit", 024, "Withdrawal", "", "Jessica Smalls", 20);
            Transaction lod19 = new Transaction(19, 129, "Credit", 025, "Transfer", "", "Ciaran Gavagan", 80);
            Transaction lod20 = new Transaction(20, 130, "Debit", 126, "Withdrawal", "", "Ross Connolly", 90);

            transactionDB.add(lod1);
            transactionDB.add(lod2);
            transactionDB.add(lod3);
            transactionDB.add(lod4);
            transactionDB.add(lod5);
            transactionDB.add(lod6);
            transactionDB.add(lod7);
            transactionDB.add(lod8);
            transactionDB.add(lod9);
            transactionDB.add(lod10);
            transactionDB.add(lod11);
            transactionDB.add(lod12);
            transactionDB.add(lod13);
            transactionDB.add(lod14);
            transactionDB.add(lod15);
            transactionDB.add(lod16);
            transactionDB.add(lod17);
            transactionDB.add(lod18);
            transactionDB.add(lod19);
            transactionDB.add(lod20);

            init = false;
        }

    }

    public List<Transaction> getTransactionDB() {
        return transactionDB;
    }
}
