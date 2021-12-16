package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.services.CustomerServices;
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
 * @author Eugene Omondi x18425924
 */
@Path("/Customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CustomerResources {

    CustomerServices customerServices = new CustomerServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_XML)
    public List<Customer> getFilteredMessages(@QueryParam("Customer") String message, @QueryParam("author") String author) {
        if ((message != null) || (author != null)) {
            return customerServices.getSearchMessages(message, author);
        }
        return customerServices.getAllCustomers();
    }

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getMessageXML(@PathParam("customerId") int id) {
        return customerServices.getCustomer(id);
    }

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getMessageJSON(@PathParam("customerId") int id) {
        return customerServices.getCustomer(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postMessage(Customer c) {
        return customerServices.createMessage(c);
    }

    @Path("/{messageID}/Customer")
    public CustomerResources getCustomerResources() {
        System.out.println("Getting customer subresoruces...");
        return new CustomerResources();
    }

}

