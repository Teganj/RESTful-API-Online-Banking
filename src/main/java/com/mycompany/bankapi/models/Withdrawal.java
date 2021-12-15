package com.mycompany.bankapi.models;

/*
 * @author Tegan Jennings x18303941
 */
public class Withdrawal {

    private int withdrawal_id;
    private int customer_id;
    private int account_id;
    private int transaction_id;
    private String to_card;
    private String card_encryption;
    private String transaction_ref;
    private double amount;
    private String date;
    private String time;
    private boolean verified;

    public Withdrawal() {
    }

    public Withdrawal(int withdrawal_id, int customer_id, int account_id, int transaction_id, String to_card, String card_encryption, String transacrion_ref, double amount, String date, String time, boolean verified) {
        this.withdrawal_id = withdrawal_id;
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.transaction_id = transaction_id;
        this.to_card = to_card;
        this.card_encryption = card_encryption;
        this.transaction_ref = transaction_ref;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.verified = verified;
    }

    public int getWithdrawal_id() {
        return withdrawal_id;
    }

    public void setWithdrawal_id(int withdrawal_id) {
        this.withdrawal_id = withdrawal_id;
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

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTo_card() {
        return to_card;
    }

    public void setTo_card(String to_card) {
        this.to_card = to_card;
    }

    public String getCard_encryption() {
        return card_encryption;
    }

    public void setCard_encryption(String card_encryption) {
        this.card_encryption = card_encryption;
    }

    public String getTransaction_ref() {
        return transaction_ref;
    }

    public void setTransaction_ref(String transaction_ref) {
        this.transaction_ref = transaction_ref;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String printWithdrawal() {
        return "BankWithdrawal{" + "withdrawal_id=" + withdrawal_id + ", customer_id=" + customer_id + ", account_id=" + account_id + ", transaction_id=" + transaction_id + ", to_card=" + to_card + ", card_encryption=" + card_encryption + ", transacrion_ref=" + transaction_ref + ", amount=" + amount + ", date=" + date + ", time=" + time + ", verified=" + verified + '}';
    }
}
