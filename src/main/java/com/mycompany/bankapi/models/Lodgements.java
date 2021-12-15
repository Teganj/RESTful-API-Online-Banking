package com.mycompany.bankapi.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author Gavin Corr x18382836
 */
public class Lodgements {

    private int lodgement_id;
    private int customer_id;
    private int account_id;
    private int transaction_id;
    private String from_card;
    private String card_encryption;
    private String transacrion_ref;
    private double amount;
    private String date;
    private String time;
    private boolean verified;

    public Lodgements() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("test-connection");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Lodgements lodge = new Lodgements();

        entitymanager.persist(lodge);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }

    public Lodgements(int lodgement_id, int customer_id, int account_id, int transaction_id, String from_card, String card_encryption, String transacrion_ref, double amount, String date, String time, boolean verified) {
        this.lodgement_id = lodgement_id;
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.transaction_id = transaction_id;
        this.from_card = from_card;
        this.card_encryption = card_encryption;
        this.transacrion_ref = transacrion_ref;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.verified = verified;
    }

    public int getLodgement_id() {
        return lodgement_id;
    }

    public void setLodgement_id(int lodgement_id) {
        this.lodgement_id = lodgement_id;
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

    public String getFrom_card() {
        return from_card;
    }

    public void setFrom_card(String from_card) {
        this.from_card = from_card;
    }

    public String getCard_encryption() {
        return card_encryption;
    }

    public void setCard_encryption(String card_encryption) {
        this.card_encryption = card_encryption;
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

    public String printLodgements() {
        return "BankLodgement{" + "lodgement_id=" + lodgement_id + ", customer_id=" + customer_id + ", account_id=" + account_id + ", transaction_id=" + transaction_id + ", from_card=" + from_card + ", card_encryption=" + card_encryption + ", transacrion_ref=" + transacrion_ref + ", amount=" + amount + ", date=" + date + ", time=" + time + ", verified=" + verified + '}';
    }
}
