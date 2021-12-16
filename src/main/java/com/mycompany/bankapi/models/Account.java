package com.mycompany.bankapi.models;

import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class Account {

    private String account;
    private String customer;
    private int account_id;
    private int customer_id;
    private String sort_code;
    private String account_number;
    private double current_balance;

    public Account() {
    }

    public Account(String account, String customer, int id, int customer_id, String sort_code, String account_number, double current_balance) {
        this.account = account;
        this.customer = customer;        
        this.account_id = account_id;
        this.customer_id = customer_id;
        this.sort_code = sort_code;
        this.account_number = account_number;
        this.current_balance = current_balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
     public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getAccountId() {
        return account_id;
    }

    public void setAccountId(int account_id) {
        this.account_id = account_id;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getSortCode() {
        return sort_code;
    }

    public void setSortCode(String sort_code) {
        this.sort_code = sort_code;
    }

    public String getAccountNumber() {
        return account_number;
    }

    public void setAccountNumber(String account_number) {
        this.account_number = account_number;
    }

    public double getCurrentBalance() {
        return current_balance;
    }

    public void setCurrentBalance(double current_balance) {
        this.current_balance = current_balance;
    }
    
    public String printAccount() {
        return "BankAccount{" + "account_id=" + account_id + ", sort_code=" + sort_code + ", account_number=" + account_number + ", current_balance=" + current_balance + ",, customer_id=" + customer_id + '}';
    }

}
