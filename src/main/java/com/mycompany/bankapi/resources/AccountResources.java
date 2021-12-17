package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.services.AccountServices;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
@Path("/customer/{customer_id}/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AccountResources {

    private AccountServices accountServices = new AccountServices();

    @GET
    @Path("/{account_id}")
    public Account getAccount(@PathParam("account_id") int a_id, @PathParam("customer_id") int c_id) {
        System.out.println("getAccountByID..." + a_id + " for CustomerID " + c_id);
        return accountServices.getAccountByID(c_id, a_id);
    }

    @GET
    @Path("/all")
    public Customer getAccounts(@PathParam("customer_id") int c_id) {
        System.out.println("getAllAccountsforCustomer..." + c_id);
        return accountServices.getAllAccountsByCustomerID(c_id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account addAccount(@PathParam("customer_id") Account a, int a_id) {
        return accountServices.createAccount(a, a_id);
    }

}
