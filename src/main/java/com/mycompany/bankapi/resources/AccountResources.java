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
@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AccountResources {

    AccountServices accountServices = new AccountServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_XML)
    public List<Account> getFilteredMessages(@QueryParam("account") String message, @QueryParam("author") String author) {
        if ((message != null) || (author != null)) {
            return accountServices.getSearchMessages(message, author);
        }
        return accountServices.getAllAccounts();
    }

    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_XML)
    public Account getMessageXML(@PathParam("accountId") int id) {
        return accountServices.getAccount(id);
    }

    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getMessageJSON(@PathParam("accountId") int id) {
        return accountServices.getAccount(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postMessage(Account m) {
        return accountServices.createMessage(m);
    }

    @Path("/{messageID}/account")
    public CustomerResources getCustomerResources() {
        System.out.println("Getting customer subresoruces...");
        return new CustomerResources();
    }

}

