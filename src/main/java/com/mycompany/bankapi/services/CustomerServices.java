package com.mycompany.bankapi.services;

import com.mycompany.bankapi.database.CustomerDatabase;
import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Customer;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class CustomerServices {

    CustomerDatabase db = new CustomerDatabase();
    private List<Customer> customerslist = db.getCustomerDB();

    public List<Customer> getAllCustomers() {
        return customerslist;
    }

    public Customer getCustomer(int customer_id, Customer customer) {
        customer.setCustomerId(customerslist.size() + 1);
        customerslist.add(customer);
        System.out.println("201 - resource created with path: /customer/" + String.valueOf(customer.getCustomerId()));
        System.out.println("Updated Customer:" + customer.printCustomer());
        return customer;
    }

    public Customer getCustomerInfo(int CustomerID) {
        Customer customer = null;
        for (int i = 0; i < customerslist.size(); i++) {
            if (customerslist.get(i).getCustomerId() == CustomerID) {
                customer = customerslist.get(i);
            }
        }
        return customer;
    }

    public Customer createCustomer(Customer c) {
        c.setCustomerId(customerslist.size() + 1);
        customerslist.add(c);
        System.out.println("201 - resource created with path: /customers/" + String.valueOf(c.getCustomerId()));
        System.out.println("Created Customer:" + c.printCustomer());
        return c;
    }

}
