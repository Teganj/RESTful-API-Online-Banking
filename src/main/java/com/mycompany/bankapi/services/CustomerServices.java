package com.mycompany.bankapi.services;

import com.mycompany.bankapi.database.CustomerDatabase;
import com.mycompany.bankapi.models.Customer;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Eugene Omondi x18425924
 */
public class CustomerServices {
    CustomerDatabase db = new CustomerDatabase();
    private List<Customer> list = db.getCustomerDB();

    public List<Customer> getAllCustomers() {
        return list;
    }

    public Customer getCustomer(int customer_id) {
        return list.get(customer_id - 1);
    }

    public Customer createCustomer(Customer c) {
        c.setCustomerId(list.size() + 1);
        list.add(c);
        System.out.println("201 - resource created with path: /customers/" + String.valueOf(c.getCustomerId()));
        System.out.println("Updated Customer:" + c.printCustomer());
        return c;
    }
}
