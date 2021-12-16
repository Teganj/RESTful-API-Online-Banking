package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Account;
import com.mycompany.bankapi.models.Withdrawal;
import com.mycompany.bankapi.services.AccountServices.list;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Tegan Jennings x18303941
 */
public class WithdrawalServices {

    public static List<Withdrawal> list = new ArrayList<>();
    public static boolean init = true;

    public WithdrawalServices() {
        if (init) {

            Withdrawal wd1 = new Withdrawal(1, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Withdrawal wd2 = new Withdrawal(2, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Withdrawal wd3 = new Withdrawal(3, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Withdrawal wd4 = new Withdrawal(4, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Withdrawal wd5 = new Withdrawal(5, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Withdrawal wd6 = new Withdrawal(6, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);

            list.add(wd1);
            list.add(wd2);
            list.add(wd3);
            list.add(wd4);
            list.add(wd5);
            list.add(wd6);
            init = false;
        }
    }

    public List<Withdrawal> getAllWithdrawals() {
        return list;
    }
    
    public Withdrawal getWithdrawal(int withdrawal_id) {
        return list.get(withdrawal_id - 1);
    }

    public Withdrawal createWithdrawal(Withdrawal w) {
        w.setWithdrawal_id(list.size() + 1);
        list.add(w);
        System.out.println("201 - resource created with path: /withdrawals/" + String.valueOf(w.getWithdrawal_id()));
        System.out.println("Updated Message:" + w.printWithdrawal());
        return w;
    }

    public List<Withdrawal> getSearchAccounts(int account_id, int customer_id) {
        List<Withdrawal> matcheslist = new ArrayList<>();

        for (Withdrawal w : getAllWithdrawals()) {

            matcheslist.add(w);
        }

        return matcheslist;
    }

}
