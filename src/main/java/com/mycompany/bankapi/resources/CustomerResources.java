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
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CustomerResources {

    CustomerServices customerServices = new CustomerServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getFilteredCustomers(@QueryParam("customer") String customer, @QueryParam("account") String account) {
        if ((customer != null) || (account != null)) {
            return customerServices.getSearchCustomer(customer, account);
        }
        return customerServices.getAllCustomers();
    }
    @GET
    @Path("customer/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerJSON(@PathParam("customerId") int customer_id) {
        return customerServices.getCustomer(customer_id);
    }


    @POST
    @Path("customer/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(Customer c) {
        return customerServices.createCustomer(c);
    }

    @Path("customer/{customer_id}/account")
    public AccountResources getAccountResources() {
        System.out.println("Getting Accounts subresoruces...");
        return new AccountResources();
    }

}

