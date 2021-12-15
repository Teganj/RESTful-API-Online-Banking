package com.mycompany.bankapi.resources;

import com.mycompany.bankclient.models.Withdrawal;
import com.mycompany.bankclient.services.WithdrawalServices;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*
 * @author Tegan Jennings x18303941
 */
@Path("/customers/{customer_id}/accounts/{account_id}/withdrawals")
public class WithdrawalResources {

    WithdrawalServices withdrawalsServices = new WithdrawalServices();
    Withdrawal withdrawal = new Withdrawal();
    EntityManager entityManager;

    @GET
    @Path("/{withdrawal_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Withdrawal getWithdrawalJSON(@PathParam("withdrawal_id") int withdrawal_id) {
        return (Withdrawal) withdrawalsServices.getAllWithdrawals();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Withdrawal postWithdrawal(Withdrawal w) {
        return withdrawalsServices.createWithdrawal(w);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{withdrawal_id}")
    public Withdrawal getWithdrawal(@PathParam("withdrawal_id") int withdrawal_id) {
        Withdrawal test = entityManager.find(Withdrawal.class, withdrawal_id);
        if (test == null) {
            throw new NotFoundException();
        }
        return test;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/search")
    public Withdrawal getSearchWithdrawal(@Context UriInfo info) {
        int withdrawal_id = Integer.parseInt(info.getQueryParameters().getFirst("withdrawal_id"));

        Withdrawal test = entityManager.find(Withdrawal.class, withdrawal_id);
        if (test == null) {
            throw new NotFoundException();
        }
        return test;
    }

    @GET
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response save(@Context UriInfo info) {

        int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
        int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
        int transaction_id = 0;

        String to_card = info.getQueryParameters().getFirst("to_card");
        String card_encryption = "";
        for (int i = to_card.length() - 1; i >= 0; i--) {
            card_encryption = card_encryption + to_card.charAt(i);
        }

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

        withdrawal.setCustomer_id(customer_id);
        withdrawal.setAccount_id(account_id);
        withdrawal.setTransaction_id(transaction_id);
        withdrawal.setTo_card(to_card);
        withdrawal.setCard_encryption(card_encryption);
        withdrawal.setTransaction_ref(transaction_ref);
        withdrawal.setAmount(amount);
        withdrawal.setDate(date);
        withdrawal.setTime(time);
        withdrawal.setVerified(verified);

        System.out.println(withdrawal);
        entityManager.getTransaction().begin();
        entityManager.persist(withdrawal);
        entityManager.getTransaction().commit();
        entityManager.close();
        return Response.status(200).entity(withdrawal).build();
    }

    @GET
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response update(@Context UriInfo info) {

        int withdrawal_id = Integer.parseInt(info.getQueryParameters().getFirst("withdrawal_id"));
        int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
        int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
        double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
        int transaction_id = 0;

        Withdrawal removedWithdrawal = entityManager.find(Withdrawal.class, withdrawal_id);
        if (removedWithdrawal == null) {
            throw new NotFoundException();
        }

        String to_card = removedWithdrawal.getTo_card();
        String card_encryption = removedWithdrawal.getCard_encryption();
        String transaction_ref = removedWithdrawal.getTransaction_ref();

        String date = removedWithdrawal.getDate();
        String time = removedWithdrawal.getTime();
        boolean verified = removedWithdrawal.isVerified();

        Withdrawal newWithdrawal = removedWithdrawal;

        newWithdrawal.setCustomer_id(customer_id);
        newWithdrawal.setAccount_id(account_id);
        newWithdrawal.setTransaction_id(transaction_id);
        newWithdrawal.setTo_card(to_card);
        newWithdrawal.setCard_encryption(card_encryption);
        newWithdrawal.setTransaction_ref(transaction_ref);
        newWithdrawal.setAmount(amount);
        newWithdrawal.setDate(date);
        newWithdrawal.setTime(time);
        newWithdrawal.setVerified(verified);

        entityManager.getTransaction().begin();
        entityManager.remove(removedWithdrawal);
        entityManager.persist(newWithdrawal);
        entityManager.getTransaction().commit();
        entityManager.close();
        String message = "Record updated";
        return Response.status(200).entity(message).build();
    }

    @GET
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@Context UriInfo info) {

        int withdrawal_id = Integer.parseInt(info.getQueryParameters().getFirst("withdrawal_id"));

        Withdrawal withdrawal = entityManager.find(Withdrawal.class, withdrawal_id);
        if (withdrawal == null) {
            throw new NotFoundException();
        }

        entityManager.getTransaction().begin();
        entityManager.remove(withdrawal);
        entityManager.getTransaction().commit();
        entityManager.close();
        String message = "Record deleted";
        return Response.status(200).entity(message).build();
    }
}
