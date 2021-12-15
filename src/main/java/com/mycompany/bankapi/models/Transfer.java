package com.mycompany.bankapi.models;

/*
 * @author Eugene Omondi x18425924
 */
public class Transfer {

    private int bank_transfer_id;
    private int customer_id;
    private int account_id;
    private int transaction_id;
    private String to_sort_code;
    private String to_account;
    private String transacrion_ref;
    private double amount;
    private String date;
    private String time;
    private boolean verified;

    public Transfer() {
    }

    public Transfer(int bank_transfer_id, int customer_id, int account_id, int transaction_id, String to_sort_code, String to_account, String transacrion_ref, double amount, String date, String time, boolean verified) {
        this.bank_transfer_id = bank_transfer_id;
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.transaction_id = transaction_id;
        this.to_sort_code = to_sort_code;
        this.to_account = to_account;
        this.transacrion_ref = transacrion_ref;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.verified = verified;
    }

    public int getBank_transfer_id() {
        return bank_transfer_id;
    }

    public void setBank_transfer_id(int bank_transfer_id) {
        this.bank_transfer_id = bank_transfer_id;
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

    public String getTo_sort_code() {
        return to_sort_code;
    }

    public void setTo_sort_code(String to_sort_code) {
        this.to_sort_code = to_sort_code;
    }

    public String getTo_account() {
        return to_account;
    }

    public void setTo_account(String to_account) {
        this.to_account = to_account;
    }

    public String getTransacrion_ref() {
        return transacrion_ref;
    }

    public void setTransacrion_ref(String transacrion_ref) {
        this.transacrion_ref = transacrion_ref;
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

    public String printTransfer() {
        return "BankTransfer{" + "bank_transfer_id=" + bank_transfer_id + ", customer_id=" + customer_id + ", account_id=" + account_id + ", transaction_id=" + transaction_id + ", to_sort_code=" + to_sort_code + ", to_account=" + to_account + ", transacrion_ref=" + transacrion_ref + ", amount=" + amount + ", date=" + date + ", time=" + time + ", verified=" + verified + '}';
    }

}
