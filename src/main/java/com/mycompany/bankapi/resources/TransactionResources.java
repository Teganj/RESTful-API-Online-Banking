package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Transaction;
import com.mycompany.bankapi.services.TransactionServices;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
@Path("/customer/{customer_id}/account/{account_id}/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResources {

    private TransactionServices transactionServices = new TransactionServices();

    @GET
    @Path("/all")
    public List<Transaction> addToTransactions(
            @QueryParam("transaction_id") int transaction_id,
            @QueryParam("account_id") int account_id,
            @QueryParam("account_type") String account_type,
            @QueryParam("transaction_type") String transaction_type,
            @QueryParam("card_credited") String card_credited,
            @QueryParam("card_debited") String card_debited,
            @QueryParam("amount") double amount,
            @QueryParam("date") String date) {
        TransactionServices transactionServices = new TransactionServices();
        return transactionServices.getAllTransactions();
    }

    @GET
    @Path("/withdraw")
    public Transaction withdrawFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("amount") double amount) {
        return transactionServices.withdrawFromAccount(account_id, customer_id,
                amount);
    }

    @GET
    @Path("/transfer")
    public Transaction transferFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("card_debited") String card_debited,
            @QueryParam("amount") int amount) {
        TransactionServices transactionServices = new TransactionServices();
        return transactionServices.transferFromAccount(account_id, customer_id, card_debited, amount);
    }

    @GET
    @Path("/lodgement")

    public Transaction LodgeFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("amount") int amount) {
        return transactionServices.lodgeToAccount(account_id, customer_id, amount);

    }
}
