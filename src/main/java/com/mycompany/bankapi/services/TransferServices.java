package com.mycompany.bankapi.services;

import com.mycompany.bankproject.models.Transfer;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Eugene Omondi x18425924
 */

public class TransferServices {
    public static List<Transfer> list = new ArrayList<>();
    public static boolean init = true;


public TransferServices() {
        if (init) {


            Transfer tr1 = new Transfer(1, 212, 100, 199, "Jeff", "nfikfdm", "uh3u2", 60.0, "15/12/2021", "10.00am", true);
            Transfer tr2 = new Transfer(2, 213, 200, 299, "Jeff", "nfikfdm", "uh3u2", 60.0, "15/12/2021", "10.00am", true);
            Transfer tr3 = new Transfer(3, 214, 300, 399, "Jeff", "nfikfdm", "uh3u2", 60.0, "15/12/2021", "10.00am", true);
            Transfer tr4 = new Transfer(4, 215, 400, 499, "Jeff", "nfikfdm", "uh3u2", 60.0, "15/12/2021", "10.00am", true);
            Transfer tr5 = new Transfer(5, 216, 500, 599, "Jeff", "nfikfdm", "uh3u2", 60.0, "15/12/2021", "10.00am", true);
            Transfer tr6 = new Transfer(6, 217, 600, 699, "Jeff", "nfikfdm", "uh3u2", 60.0, "15/12/2021", "10.00am", true);

            list.add(tr1);
            list.add(tr2);
            list.add(tr3);
            list.add(tr4);
            list.add(tr5);
            list.add(tr6);
            init = false;
        }
    }

    public List<Transfer> getAllTransfers() {
        return list;
    }

    public Transfer getTransfer(int transfer_id) {
        return list.get(transfer_id - 1);
    }

    public Transfer createTransfer(Transfer t) {
        t.setBank_transfer_id(list.size() + 1);
        list.add(t);
        System.out.println("201 - resource created with path: /transfer/" + String.valueOf(t.getBank_transfer_id()));
        System.out.println("Updated Message:" + t.printTransfer());
        return t;
    }

    public List<Transfer> getSearchTransfer(int transfer_id, int customer_id) {
        List<Transfer> matcheslist = new ArrayList<>();
        for (Transfer t : getAllTransfers()) {
            matcheslist.add(t);
        }
        return matcheslist;
    }
}


