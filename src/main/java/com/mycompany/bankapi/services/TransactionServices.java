package com.mycompany.bankapi.services;

import com.mycompany.bankapi.database.AccountDatabase;
import com.mycompany.bankapi.database.TransactionDatabase;
import com.mycompany.bankapi.models.Account;
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

    public Transaction transferFromAccount(int account_id, int customer_id,
            String card_debited, double amount) {
        TransactionServices transactionServices = new TransactionServices();
        AccountServices accountServices = new AccountServices();
        Transaction transaction;

        Account account = accountServices.getAccountByID(account_id, customer_id);
        double accountBalance = account.getCurrentBalance();
        double newBalance = accountBalance - amount;

        account.setCurrentBalance(newBalance);

        transaction = new Transaction(1, account_id, "Credit", "Transfer",
                "4319", "1930", newBalance, "28-05-2022");

        transactionServices.addTransaction(transaction);

        return transaction;
    }

    public Transaction lodgeToAccount(int account_id, int customer_id,
            double amount) {
        TransactionServices transactionServices = new TransactionServices();
        AccountServices accountServices = new AccountServices();
        Transaction transaction;

        Account account = accountServices.getAccountByID(account_id, customer_id);
        double accountBalance = account.getCurrentBalance();
        double newBalance = accountBalance + amount;
        account.setCurrentBalance(newBalance);

        transaction = new Transaction(1, account_id, "Debit", "Lodge",
                "4319", "1930", newBalance, "28-05-2022");

        transactionServices.addTransaction(transaction);

        transactionlist.add(transaction);
        return transaction;

    }

    public Transaction getTransaction(int transaction_id) {
        return transactionlist.get(transaction_id);
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

}
