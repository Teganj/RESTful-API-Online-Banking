package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Transaction;
import com.mycompany.bankapi.services.TransactionServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
@Path("/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResources {

    private TransactionServices transactionServices = new TransactionServices();

    
    //Tegan
//    @GET
//    @Path("/all")
//    public Transaction addToTransactions(
//            @QueryParam("account_id") int account_id,
//            @QueryParam("amount") double amount) {
//        TransactionServices transactionServices = new TransactionServices();
//        return transactionServices.withdrawFromAccount(account_id, amount);
//    }

    
    //Tegan
    @GET
    @Path("/withdraw")
    public Transaction withdrawFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("amount") double amount) {
        return transactionServices.withdrawFromAccount(account_id, customer_id, 
                amount);
    }

    @POST
    @Path("/withdraw/create")
    public Response createtWithdrawFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("From Customer ID: ") int customer_id,
            @QueryParam("To Card: ") String card_credited,
            @QueryParam("From Card: ") String card_debited,
            @QueryParam("For the Amount: ") int amount) {

        String output = "getWithdrawFunds is called, from this Account ID: "
                + account_id + ", by this Customer ID : " + customer_id
                + ", Sending Money to this card: " + card_credited
                + " from this card: " + card_debited + " For this amount: "
                + amount;
        return Response.status(200).entity(output).build();
    }
/*
    //Eugene
    @GET
    @Path("/{transfer}")
    public Transaction transferFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("card_debited") String card_debited,
            @QueryParam("amount") int amount) {
        TransactionServices transactionServices = new TransactionServices();
        return transactionServices.transerFromAccount(account_id, customer_id, card_debited, amount);
    }

    @POST
    @Path("/transfer/create")
    public Response createtTransferFunds(
            @QueryParam("From Account ID: ") int account_id,
            @QueryParam("From Customer ID: ") int customer_id,
            @QueryParam("From Card: ") String card_debited,
            @QueryParam("For the Amount: ") int amount) {

        String output = "getTransferFunds is called, from this Account ID: "
                + account_id + ", by this Customer ID : " + customer_id
                + ", Sending Money to this card: " + card_debited + " For this amount: "
                + amount;
        return Response.status(200).entity(output).build();
    }

    //Gavin
    @GET
    @Path("/{lodgement}")

    public Transaction LodgeFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("card_debited") String card_debited,
            @QueryParam("amount") int amount) {
        TransactionServices transactionServices = new TransactionServices();
        return transactionServices.LodgeToAccount(account_id, customer_id, amount, card_debited);
    }

    @POST
    @Path("/lodgement/create")
    public Response createLodgeFunds(
            @QueryParam("From Account ID: ") int account_id,
            @QueryParam("From Customer ID: ") int customer_id,
            @QueryParam("To Card: ") String card_credited,
            @QueryParam("For the Amount: ") int amount) {

        String output = "getLodgementFunds is called, from this Account ID: "
                + account_id + ", by this Customer ID : " + customer_id
                + ", Sending Money to this card: " + card_credited
                + amount;
        return Response.status(200).entity(output).build();
    }
*/
}
