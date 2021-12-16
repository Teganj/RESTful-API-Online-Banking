package com.mycompany.bankapi.models;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class Transaction {

    private int customer_id;
    private int account_id;
    private String account_type;
    private int transaction_id;
    private String transaction_type;
    private String card_credited;
    private String card_debited;
    private double amount;

    public Transaction() {

    }

    public Transaction(int customer_id, int account_id, String account_type, int transaction_id, String transaction_type, String card_credited, String card_debited, double amount) {
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.account_type = account_type;
        this.transaction_id = transaction_id;
        this.transaction_type = transaction_type;
        this.card_credited = card_credited;
        this.card_debited = card_debited;
        this.amount = amount;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_Type() {
        return account_type;
    }

    public void setAccount_Type(String account_id) {
        this.account_type = account_type;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAccountCredited() {
        return transaction_type;
    }

    public void setAccountCredited(String card_credited) {
        this.card_credited = card_credited;
    }

    public String getAccountDebited() {
        return transaction_type;
    }

    public void setAccountDebited(String card_debited) {
        this.card_debited = card_debited;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String printLodgements() {
        return "Bank Transaction{" + "Customer ID=" + customer_id + ", Account ID=" + account_id + ", Transaction ID=" + transaction_id + ", Card Credited=" + card_credited + ", Card Debited=" + card_debited + ", amount=" + amount + '}';
    }
}
