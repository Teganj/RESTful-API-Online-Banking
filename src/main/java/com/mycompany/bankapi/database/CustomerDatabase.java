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

            Customer cus1 = new Customer("", 1, "name", "address", "email", "PASS","CPASS", accountDB);
            Customer cus2 = new Customer("", 1, "name", "address", "email", "PASS","CPASS", accountDB);
            Customer cus3 = new Customer("", 1, "name", "address", "email", "PASS","CPASS", accountDB);
            Customer cus4 = new Customer("", 1, "name", "address", "email", "PASS","CPASS", accountDB);
            Customer cus5 = new Customer("", 1, "name", "address", "email", "PASS","CPASS", accountDB);
            Customer cus6 = new Customer("", 1, "name", "address", "email", "PASS","CPASS", accountDB);

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
