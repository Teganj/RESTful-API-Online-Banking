package com.mycompany.bankapi.services;

import com.mycompany.bankapi.database.AccountDatabase;
import com.mycompany.bankapi.database.CustomerDatabase;
import com.mycompany.bankapi.database.TransactionDatabase;
import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.models.Transaction;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836low error
 * @author Eugene Omondi x18425924
 */
public class TransactionServices {

    private List<Transaction> transactionlist = new TransactionDatabase().getTransactionDB();
    private List<Account> accountlist = new AccountDatabase().getAccountDB();
    private Transaction transaction = new Transaction();

    //Tegan
    public Transaction withdrawFromAccount(int account_id, int customer_id,
            double amount) {
        TransactionServices transactionServices = new TransactionServices();
        AccountServices accountServices = new AccountServices();
        Transaction transaction;

        Account account = accountServices.getAccountByID(account_id, customer_id);
        double accountBalance = account.getCurrentBalance();
        double newBalance = accountBalance - amount;
        account.setCurrentBalance(newBalance);
        
        transaction = new Transaction(1, account_id, "Credit", "Withdraw", 
                "4319", "1930", newBalance, "28-05-2022");

        transactionServices.addTransaction(transaction);

        return transaction;

    }

// Eugene
    public Transaction transerFromAccount(int account_id, int customer_id, String card_debited, int amount) {
        return transactionlist.get(account_id - 1);
    }

    //Gavin
    public Transaction LodgeToAccount(int account_id, int customer_id, double amount, String card_debited) {
        return transactionlist.get(account_id - 1);
    }

    public Transaction getTransaction(int transaction_id) {
        return transactionlist.get(transaction_id - 1);
    }

    public List<Transaction> getAllTransactions() {
        return transactionlist;
    }

    public Transaction addTransaction(Transaction l) {
        l.setTransaction_id(transactionlist.size() + 1);
        transactionlist.add(l);
        System.out.println("201 - transaction created with path: /transaction/" + String.valueOf(l.getTransaction_id()));
        System.out.println("New Transaction:" + l.printTransaction());
        return l;
    }
    
    public Transaction calculateWithdrawal(int transaction_id, double amount, Transaction t) {
        t.setTransaction_id(transactionlist.size() + 1);
        transactionlist.add(t);
        System.out.println("201 - transaction created with path: /transaction/" + String.valueOf(t.getTransaction_id()));
        System.out.println("New Transaction:" + t.printTransaction());
        return t;
    }

}
