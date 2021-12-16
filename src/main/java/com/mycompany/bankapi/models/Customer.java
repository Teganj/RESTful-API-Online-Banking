package com.mycompany.bankapi.models;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Eugene Omondi x18425924
 */
public class Customer {

    private String customer;
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_email;
    private String customer_password;
    private String customer_cpassword;
    private List<Account> accounts = new ArrayList<>();
    
    

    public Customer() {
    }

    public Customer (String customer, int customer_id, String customer_name, String customer_address, String customer_email, String customer_password,  String customer_cpassword, List<Account> accounts) {
        this.customer = customer;
        this.customer_id = customer_id;        
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_email = customer_email;
        this.customer_password = customer_password;
        this.customer_cpassword = customer_cpassword;
        this.accounts = accounts;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
     public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomerAddress() {
        return customer_address;
    }

    public void setCustomerAddress(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomerEmail() {
        return customer_email;
    }

    public void setCustomerEmail(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomerPassword() {
        return customer_password;
    }

    public void setCustomerPassword(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomerCpassword() {
        return customer_cpassword;
    }

    public void setCurrentBalance(String customer_cpassword) {
        this.customer_cpassword = customer_cpassword;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccountToCustomer(Account account) {
        (this.accounts).add(account);
        System.out.println("add a new account to Customer");
    }


    public String printCustomer() {
        return "BankAccount{" + "customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address=" + customer_address + ", customer_email=" + customer_email + ", customer_password=" + customer_password  + ",, customer_cpassword=" + customer_cpassword + '}';
    }

}
