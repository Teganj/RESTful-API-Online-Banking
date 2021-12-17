package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.models.Transaction;
import com.mycompany.bankapi.services.AccountServices;
import com.mycompany.bankapi.services.TransactionServices;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*
 * @author Tegan Jennings x18303941
 */
@Path("/customer/{customer_id}/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AccountResources {

    private AccountServices accountServices = new AccountServices();

    @GET
    @Path("/{account_id}")
    public Account getAccount(
            @PathParam("account_id") int a_id){
        System.out.println("getAccountByID:" + a_id);
        return accountServices.getAccount(a_id);
    }

    @GET
    @Path("/all")
    public List<Account> getAllAccounts(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("account_type") String account_type) {
        AccountServices accountServices = new AccountServices();
        return accountServices.getAllAccounts();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account addAccount(Account a) {
        return accountServices.createAccount(a);
    }
}
