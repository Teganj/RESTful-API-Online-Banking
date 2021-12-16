package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Transaction;
import com.mycompany.bankapi.services.TransactionServices;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */

@Path("/customers/{customer_id}/accounts/{accounts_id}/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResources {
    
       private TransactionServices transactionServices = new TransactionServices();
       
       @GET
       @Path("/withdraw")
       public Transaction withdrawFunds(@QueryParam("account_id") int account_id, @QueryParam("customer_id") int customer_id, @QueryParam("amount") double amount){
           TransactionServices transactionServices = new TransactionServices();
           return transactionServices.withdrawFromAccount(account_id, customer_id, amount);
       }
    
    
    
}
