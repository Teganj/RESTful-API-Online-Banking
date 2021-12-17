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

            Customer cus1 = new Customer("", 1, "John Smith", "address", "johnsmith@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus2 = new Customer("", 2, "James Wright", "address", "jameswright@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus3 = new Customer("", 3, "Sam Smith", "address", "samsmith@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus4 = new Customer("", 4, "Rob Tierny", "address", "robtierny@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus5 = new Customer("", 5, "Hannah Carpenter", "address", "hannahcarpenter@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus6 = new Customer("", 6, "Sally Jones", "address", "sallyjones@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus7 = new Customer("", 7, "Susan Byrne", "address", "susanbyrne@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus8 = new Customer("", 8, "Jack Murphy", "address", "jackmurphy@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus9 = new Customer("", 9, "Kelly Keogh", "address", "kellykeogh@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus10 = new Customer("", 10, "Fiona Hannigan", "address", "fionahannigan@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus11 = new Customer("", 11, "Andrew Burke", "address", "andrewburke@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus12 = new Customer("", 12, "Jason Gilligan", "address", "jasongilligan@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus13 = new Customer("", 13, "Patricia Hannon", "address", "patriciahannon@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus14 = new Customer("", 14, "Karen Carr", "address", "karencarr@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus15 = new Customer("", 15, "Lauren Dunne", "address", "laurendunne@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus16 = new Customer("", 16, "Josh Martin", "address", "joshmartin@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus17 = new Customer("", 17, "Paul Long", "address", "paullong@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus18 = new Customer("", 18, "Jessica Smalls", "address", "jessicasmalls@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus19 = new Customer("", 19, "Ciaran Gavagan", "address", "ciarangavagan@apiproject.ie", "PASS", "CPASS", accountDB);
            Customer cus20 = new Customer("", 20, "name", "address", "rossconnolly@apiproject.ie", "PASS", "CPASS", accountDB);

            customerDB.add(cus1);
            customerDB.add(cus2);
            customerDB.add(cus3);
            customerDB.add(cus4);
            customerDB.add(cus5);
            customerDB.add(cus6);
            customerDB.add(cus7);
            customerDB.add(cus8);
            customerDB.add(cus9);
            customerDB.add(cus10);
            customerDB.add(cus11);
            customerDB.add(cus12);
            customerDB.add(cus13);
            customerDB.add(cus14);
            customerDB.add(cus15);
            customerDB.add(cus16);
            customerDB.add(cus17);
            customerDB.add(cus18);
            customerDB.add(cus19);
            customerDB.add(cus20);
            init = false;
        }

    }

    public List<Customer> getCustomerDB() {
        return customerDB;
    }
}
