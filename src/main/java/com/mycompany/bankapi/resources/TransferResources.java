package com.mycompany.bankapi.resources;

import com.mycompany.bankclient.models.Transfer;
import com.mycompany.bankclient.services.TransferServices;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/*
 *@author Eugene Omondi x18425924
 */
@Path("/customers/{customer_id}/accounts/{account_id}/transfers")
public class TransferResources {

    TransferServices transferServices = newtransferServices();
    Transfer transfer = new Transfer();
    Entity Manager entityManager

     @GET
     @Produces(MediaType.APPLICATION_JSON)
    public List<Transfer> getTransfers

    {
        return transferService.getAllTransfers();
    }

    @GET
    @Path("/{transfer_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getTransferJSON(@PathParam("transfer_Id") int transfer 
        id) {
            return transferService.getTransfer(transfer_id);
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Transfer postTransfer
        (Transfer t
        
            ) {
            return TransferService.createTransfer(t);
        }
        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("{bank_transfer_id}")
        public BankTransfer getTransfer
        (@PathParam("bank_transfer_id")
        int bank_transfer_id
        
            ) {
            BankTransfer test = entityManager.find(BankTransfer.class, bank_transfer_id);
            if (test == null) {
                throw new NotFoundException();
            }
            return test;
        }

        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("/search")
        public BankTransfer getSearchTransfer
        (@Context
        UriInfo info
        
            ) {
        int bank_transfer_id = Integer.parseInt(info.getQueryParameters().getFirst("bank_transfer_id"));

            BankTransfer test = entityManager.find(BankTransfer.class, bank_transfer_id);
            if (test == null) {
                throw new NotFoundException();
            }
            return test;
        }

        @GET
        @Path("/save")

        @Produces({MediaType.APPLICATION_JSON})

        public Response save
        (@Context
        UriInfo info
        
            ) {

        BankTransfer bt = new BankTransfer();

            int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
            int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
            int transaction_id = 0;
            String to_sort_code = info.getQueryParameters().getFirst("to_sort_code");
            String to_account = info.getQueryParameters().getFirst("to_account");

            byte[] array = new byte[7];
            new Random().nextBytes(array);
            String transaction_ref = new String(array, Charset.forName("UTF-8"));

            double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date currDate = new Date();
            String date = dateFormat.format(currDate);
            String time = timeFormat.format(currDate);
            boolean verified = false;

            bt.setCustomer_id(customer_id);
            bt.setAccount_id(account_id);
            bt.setTransaction_id(transaction_id);
            bt.setTo_sort_code(to_sort_code);
            bt.setTo_account(to_account);
            bt.setTransacrion_ref(transaction_ref);
            bt.setAmount(amount);
            bt.setDate(date);
            bt.setTime(time);
            bt.setVerified(verified);

            System.out.println(bt);

            System.out.println();
            entityManager.getTransaction().begin();

            entityManager.persist(bt);
            entityManager.getTransaction().commit();

            entityManager.close();

            return Response.status(200).entity(bt).build();

        }

        @GET
        @Path("/update")

        public Response update
        (@Context
        UriInfo info
        
            ) {

        int bank_transfer_id = Integer.parseInt(info.getQueryParameters().getFirst("bank_transfer_id"));
            int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
            int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
            int transaction_id = 0;
            String to_sort_code = info.getQueryParameters().getFirst("to_sort_code");
            String to_account = info.getQueryParameters().getFirst("to_account");
            double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));

            BankTransfer removedTransfer = entityManager.find(BankTransfer.class, bank_transfer_id);
            if (removedTransfer == null) {
                throw new NotFoundException();
            }

            String transaction_ref = removedTransfer.getTransacrion_ref();
            String date = removedTransfer.getDate();
            String time = removedTransfer.getTime();
            boolean verified = removedTransfer.isVerified();

            BankTransfer newTransfer = removedTransfer;

            entityManager.getTransaction().begin();

            newTransfer.setCustomer_id(customer_id);
            newTransfer.setAccount_id(account_id);
            newTransfer.setTransaction_id(transaction_id);
            newTransfer.setTo_sort_code(to_sort_code);
            newTransfer.setTo_account(to_account);
            newTransfer.setTransacrion_ref(transaction_ref);
            newTransfer.setAmount(amount);
            newTransfer.setDate(date);
            newTransfer.setTime(time);
            newTransfer.setVerified(verified);

            entityManager.remove(removedTransfer);
            entityManager.persist(newTransfer);
            entityManager.getTransaction().commit();

            entityManager.close();

            String message = "Record updated";
            return Response.status(200).entity(message).build();

        }
        @GET
        @Path("/delete")

        public Response delete
        (@Context
        UriInfo info
        
            ) {

        int bank_transfer_id = Integer.parseInt(info.getQueryParameters().getFirst("bank_transfer_id"));

            Transfer transfer = entityManager.find(BankTransfer.class, bank_transfer_id);
            if (transfer == null) {
                throw new NotFoundException();
            }

            entityManager.getTransaction().begin();
            entityManager.remove(transfer);
            entityManager.getTransaction().commit();

            entityManager.close();

            String message = "Record deleted";
            return Response.status(200).entity(message).build();

        }
    }
