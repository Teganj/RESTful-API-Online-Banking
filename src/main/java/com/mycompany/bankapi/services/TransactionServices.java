package com.mycompany.bankapi.services;

import com.mycompany.bankapi.database.TransactionDatabase;
import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class TransactionServices {

    private List<Transaction> transactionlist = new TransactionDatabase().getTransactionDB();

    //Tegan
    public Transaction withdrawFromAccount(int account_id, int customer_id, String card_credited, String card_debited, int amount) {
        return transactionlist.get(account_id - 1);
    }

    // Eugene
    public Transaction transerFromAccount(int account_id, int customer_id, String card_debited, int amount) {
        return transactionlist.get(account_id - 1);
    }

    //Gavin
    public Transaction LodgeToAccount(int account_id, int customer_id, double amount, String card_debited) {
        return transactionlist.get(account_id - 1);
    }

    // public Transaction LodgeToAccount(int account_id, int customer_id, double amount) {
    //    Transaction transactionWithdrawal;
    //    transactionWithdrawal = new TransactionServices(1, 123, 40.0);
    //    transService.addToTransaction(transactionWithdrawal);
    //     return transactionWithdrawal;
    //  }
    
    public Transaction getTransaction(int transaction_id) {
        return transactionlist.get(transaction_id - 1);
    }

    public List<Transaction> getAllTransactions() {
        return transactionlist;
    }

    public Transaction createTransaction(Transaction l) {
        l.setTransaction_id(transactionlist.size() + 1);
        transactionlist.add(l);
        System.out.println("201 - transaction created with path: /transaction/" + String.valueOf(l.getTransaction_id()));
        System.out.println("New Transaction:" + l.printTransaction());
        return l;
    }

    public List<Transaction> getSearchTransaction(int transaction, int customer_id, int account_id) {
        List<Transaction> matcheslist = new ArrayList<>();
        for (Transaction l : getAllTransactions()) {
            matcheslist.add(l);
        }
        return matcheslist;
    }

}
