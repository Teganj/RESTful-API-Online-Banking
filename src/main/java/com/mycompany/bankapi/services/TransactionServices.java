package com.mycompany.bankapi.services;

import com.mycompany.bankapi.models.Transaction;
import org.omg.IOP.TransactionService;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
public class TransactionServices {

    public Transaction withdrawFromAccount(int account_id, int customer_id, double amount) {
        TransactionServices transactionWithdrawal;

        transactionWithdrawal = new TransactionServices(1, 123, 40.0);
        transService.addToTransaction(transactionWithdrawal);

        return transactionWithdrawal;
    }

    public Transaction LodgeToAccount(int account_id, int customer_id, double amount) {
        TransactionServices transactionLodgement;

        transactionLodgement = new TransactionService(1, 123, 40.0);
        transactionLodgement.addToTransaction(transactionLodgement);

        return transactionLodgement;
    }

    public Transaction TransferFromAccount(int account_id, int customer_id, double amount) {
        TransactionServices transactionTransfer;

        transactionTransfer = new TransactionService(1, 123, 40.0);
        transService.addToTransaction(transactionTransfer);

        return transactionTransfer;
    }

}
