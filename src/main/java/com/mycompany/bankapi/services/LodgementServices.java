package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Lodgements;
import com.mycompany.bankapi.models.Transfer;
import com.mycompany.bankapi.models.Withdrawals;
import static com.mycompany.bankapi.services.WithdrawalServices.init;
import static com.mycompany.bankapi.services.WithdrawalServices.list;
import java.util.ArrayList;
import java.util.List;

/*

 * @author Gsvin Corr x18382836
 */
public class LodgementServices {

    public static List<Lodgements> list = new ArrayList<>();
    public static boolean init = true;

    public LodgementServices() {
        if (init) {
            Lodgements l1 = new Lodgements(1, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Lodgements l2 = new Lodgements(2, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Lodgements l3 = new Lodgements(3, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Lodgements l4 = new Lodgements(4, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Lodgements l5 = new Lodgements(5, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);
            Lodgements l6 = new Lodgements(6, 123, 456, 789, "TeganJ", "dfg575", "wd1253", 40.0, "10/10/2021", "10.00am", true);

            list.add(l1);
            list.add(l2);
            list.add(l3);
            list.add(l4);
            list.add(l5);
            list.add(l6);
            init = false;

        }
    }

    public List<Lodgements> getAllLodgements() {
        return list;
    }

    public Lodgements getLodgement(int lodgement_id) {
        return list.get(lodgement_id - 1);
    }

    public Lodgements createLodgment(Lodgements l) {
        l.setLodgement_id(list.size() + 1);
        list.add(l);
        System.out.println("201 - resource created with path: /lodgement/" + String.valueOf(l.getLodgement_id()));
        System.out.println("Updated Message:" + l.printLodgements());
        return l;
    }

    public List<Lodgements> getSearchLodgement(int lodgement_id, int customer_id) {
        List<Lodgements> matcheslist = new ArrayList<>();
        for (Lodgements l : getAllLodgements()) {
            matcheslist.add(l);
        }
        return matcheslist;
    }
}

