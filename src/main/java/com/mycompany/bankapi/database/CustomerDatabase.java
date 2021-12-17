package com.mycompany.bankapi.database;

import static com.mycompany.bankapi.database.AccountDatabase.accountDB;
import com.mycompany.bankapi.models.Customer;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Eugene Omondi x18425924
 */
public class CustomerDatabase {

    public static List<Customer> customerDB = new ArrayList<>();
    public static boolean init = true;

    public CustomerDatabase() {
        if (init) {

            Customer cus1 = new Customer(1, "John Smith", "address", "johnsmith@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus2 = new Customer(2, "James Wright", "address", "jameswright@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus3 = new Customer(3, "Sam Smith", "address", "samsmith@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus4 = new Customer(4, "Rob Tierny", "address", "robtierny@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus5 = new Customer(5, "Hannah Carpenter", "address", "hannahcarpenter@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus6 = new Customer(6, "Sally Jones", "address", "sallyjones@apiproject.ie", "PASS", "CPASS", accountDB);

            customerDB.add(cus1);
            customerDB.add(cus2);
            customerDB.add(cus3);
            customerDB.add(cus4);
            customerDB.add(cus5);
            customerDB.add(cus6);

            init = false; 
        }

    }

    public List<Customer> getCustomerDB() {
        return customerDB;
    }
}
