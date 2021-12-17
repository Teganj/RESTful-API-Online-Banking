package com.mycompany.bankapi.database;

import static com.mycompany.bankapi.database.AccountDatabase.accountDB;
import com.mycompany.bankapi.models.Customer;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class CustomerDatabase {

    public static List<Customer> customerDB = new ArrayList<>();
    public static boolean init = true;

    public CustomerDatabase() {
        if (init) {

            Customer cus1 = new Customer(1, "John Smith", "33 St Clones Way,Co Limrick", "johnsmith@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus2 = new Customer(2, "James Wright", "5 Woodsgift Hall,Co Galway", "jameswright@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus3 = new Customer(3, "Sam Smith", "9 Kingsfort Lodge,Co Dublin ", "samsmith@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus4 = new Customer(4, "Rob Tierny", " 3 Bridge St, Co Mayo", "robtierny@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus5 = new Customer(5, "Hannah Carpenter", "77 Diamond way, Co Meath", "hannahcarpenter@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus6 = new Customer(6, "Sally Jones", "71 Heatherview, Co Meath", "sallyjones@apiproject.ie", "PASS", "CPASS", accountDB);

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
