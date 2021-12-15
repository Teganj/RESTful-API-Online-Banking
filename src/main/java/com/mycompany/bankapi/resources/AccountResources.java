package com.mycompany.bankapi.resources;

import com.mycompany.bankclient.models.Account;
import com.mycompany.bankclient.services.AccountService;
import com.mycompany.bankclient.services.AccountServices;
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

public class AccountResources {
    
    private AccountServices accountServices = new AccountServices();
	
    @GET
    public List<Account> getComments(@PathParam("messageID") int m_id) {
        System.out.println("getAllCommentsForMessage..."+m_id);
	return AccountServices.getAllCommentsByMessage(m_id);
    }
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postComment(@PathParam("messageID") int m_id, Accout a) {
	return AccountServices.createComment(a, m_id);
    }
    @GET
    @Path("/{account_id}")
    public Account getAccount(@PathParam("account_id") int c_id,@PathParam("customer_id") int m_id ) {
    	System.out.println("getAccountByID..."+c_id +" for CustomerID "+m_id);
	return AccountServices.getAccountByID(m_id,c_id);
    }

}
