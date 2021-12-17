package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import com.mycompany.bankapi.services.AccountServices;
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
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CustomerResources {

    CustomerServices customerServices = new CustomerServices();

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerJSON(@PathParam("customerId") int customer_id, Customer c) {
        return customerServices.getCustomer(customer_id, c);
    }

    @GET
    @Path("/all")
    public List<Customer> getAllCustomers(
            @QueryParam("customer_id") int customer_id) {
        AccountServices accountServices = new AccountServices();
        return customerServices.getAllCustomers();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(Customer c) {
        return customerServices.createCustomer(c);
    }

}
