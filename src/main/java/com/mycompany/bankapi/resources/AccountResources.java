package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.services.AccountServices;
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
@Path("/customers/{customer_id}/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AccountResources {

    private AccountServices accountServices = new AccountServices();

    @GET
    public List<Account> getAccounts(@PathParam("customer_id") int c_id) {
        System.out.println("getAllAccountsforCustomer..." + c_id);
        return accountServices.getAllAccountsByCustomerID(c_id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postAccount(@PathParam("account_id") int a_id, Account a) {
        return accountServices.createAccount(a, a_id);
    }

    @GET
    @Path("/{account_id}")
    public Account getAccount(@PathParam("account_id") int a_id, @PathParam("customer_id") int c_id) {
        System.out.println("getAccountByID..." + a_id + " for CustomerID " + c_id);
        return accountServices.getAccountByID(c_id, a_id);
    }

}
