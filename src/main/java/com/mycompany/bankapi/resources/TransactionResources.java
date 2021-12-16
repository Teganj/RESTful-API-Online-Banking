package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.models.Transaction;
import com.mycompany.bankapi.services.TransactionServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/*
 * @author Tegan Jennings x18303941
 * @author Gavin Corr x18382836
 * @author Eugene Omondi x18425924
 */
@Path("/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResources {

    private TransactionServices transactionServices = new TransactionServices();

    //Tegan
    @GET
    @Path("/customer/{customer_id}/account/{accounts_id}/transaction/{withdraw}")
    public Transaction withdrawFunds(
            @QueryParam("account_id") int account_id,
            @QueryParam("customer_id") int customer_id,
            @QueryParam("card_credited") String card_credited,
            @QueryParam("card_debited") String card_debited,
            @QueryParam("amount") int amount) {
        TransactionServices transactionServices = new TransactionServices();
        return transactionServices.withdrawFromAccount(account_id, customer_id, card_credited, card_debited, amount);
    }

    @POST
    @Path("/withdraw")
    public Response postWithdrawFunds(
            @QueryParam("From Account ID: ") int account_id,
            @QueryParam("From Customer ID: ") int customer_id,
            @QueryParam("To Card: ") String card_credited,
            @QueryParam("From Card: ") String card_debited,
            @QueryParam("For the Amount: ") int amount) {
        
        
        String output = "getWithdrawFunds is called, from this Account ID: "
                        + account_id + ", by this Customer ID : " + customer_id
                        + ", Sending Money to this card: " + card_credited
                        + " from this card: " + card_debited + " For this amount: " 
                        + amount;
        return Response.status(200).entity(output).build();
    }
/*
    @GET
        @Path("/withdrawal")
        @Produces(MediaType.APPLICATION_JSON)
        public Transaction getWithdrawalJSON(@PathParam("transaction_id") int withdrawal_id) {
            return (Transaction) transactionServices.getAllTransactions();
        }
    */
    /*

    @Path("/customers/{customer_id}/accounts/{account_id}/withdrawals")
    public class WithdrawalResources {

        WithdrawalServices withdrawalsServices = new WithdrawalServices();
        Withdrawal withdrawal = new Withdrawal();
        EntityManager entityManager;

        @GET
        @Path("/{withdrawal_id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Withdrawal getWithdrawalJSON(@PathParam("withdrawal_id") int withdrawal_id) {
            return (Withdrawal) withdrawalsServices.getAllWithdrawals();
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Withdrawal postWithdrawal(Withdrawal w) {
            return withdrawalsServices.createWithdrawal(w);
        }

        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("{withdrawal_id}")
        public Withdrawal getWithdrawal(@PathParam("withdrawal_id") int withdrawal_id) {
            Withdrawal test = entityManager.find(Withdrawal.class, withdrawal_id);
            if (test == null) {
                throw new NotFoundException();
            }
            return test;
        }

        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("/search")
        public Withdrawal getSearchWithdrawal(@Context UriInfo info) {
            int withdrawal_id = Integer.parseInt(info.getQueryParameters().getFirst("withdrawal_id"));

            Withdrawal test = entityManager.find(Withdrawal.class, withdrawal_id);
            if (test == null) {
                throw new NotFoundException();
            }
            return test;
        }

        @GET
        @Path("/save")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces({MediaType.APPLICATION_JSON})
        public Response save(@Context UriInfo info) {

            int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
            int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
            int transaction_id = 0;

            String to_card = info.getQueryParameters().getFirst("to_card");
            String card_encryption = "";
            for (int i = to_card.length() - 1; i >= 0; i--) {
                card_encryption = card_encryption + to_card.charAt(i);
            }

            byte[] array = new byte[7];
            new Random().nextBytes(array);
            String transaction_ref = new String(array, Charset.forName("UTF-8"));

            double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date currDate = new Date();
            String date = dateFormat.format(currDate);
            String time = timeFormat.format(currDate);
            boolean verified = false;

            withdrawal.setCustomer_id(customer_id);
            withdrawal.setAccount_id(account_id);
            withdrawal.setTransaction_id(transaction_id);
            withdrawal.setTo_card(to_card);
            withdrawal.setCard_encryption(card_encryption);
            withdrawal.setTransaction_ref(transaction_ref);
            withdrawal.setAmount(amount);
            withdrawal.setDate(date);
            withdrawal.setTime(time);
            withdrawal.setVerified(verified);

            System.out.println(withdrawal);
            entityManager.getTransaction().begin();
            entityManager.persist(withdrawal);
            entityManager.getTransaction().commit();
            entityManager.close();
            return Response.status(200).entity(withdrawal).build();
        }

        @GET
        @Path("/update")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces({MediaType.APPLICATION_JSON})
        public Response update(@Context UriInfo info) {

            int withdrawal_id = Integer.parseInt(info.getQueryParameters().getFirst("withdrawal_id"));
            int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
            int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
            double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
            int transaction_id = 0;

            Withdrawal removedWithdrawal = entityManager.find(Withdrawal.class, withdrawal_id);
            if (removedWithdrawal == null) {
                throw new NotFoundException();
            }

            String to_card = removedWithdrawal.getTo_card();
            String card_encryption = removedWithdrawal.getCard_encryption();
            String transaction_ref = removedWithdrawal.getTransaction_ref();

            String date = removedWithdrawal.getDate();
            String time = removedWithdrawal.getTime();
            boolean verified = removedWithdrawal.isVerified();

            Withdrawal newWithdrawal = removedWithdrawal;

            newWithdrawal.setCustomer_id(customer_id);
            newWithdrawal.setAccount_id(account_id);
            newWithdrawal.setTransaction_id(transaction_id);
            newWithdrawal.setTo_card(to_card);
            newWithdrawal.setCard_encryption(card_encryption);
            newWithdrawal.setTransaction_ref(transaction_ref);
            newWithdrawal.setAmount(amount);
            newWithdrawal.setDate(date);
            newWithdrawal.setTime(time);
            newWithdrawal.setVerified(verified);

            entityManager.getTransaction().begin();
            entityManager.remove(removedWithdrawal);
            entityManager.persist(newWithdrawal);
            entityManager.getTransaction().commit();
            entityManager.close();
            String message = "Record updated";
            return Response.status(200).entity(message).build();
        }

    }
     */
    //Eugene
  //  @GET
  //  @Path("/customer/{customer_id}/account/{accounts_id}/transaction/{tranfer}")
  //  public Transaction transferFunds(@QueryParam("account_id") int account_id, @QueryParam("customer_id") int customer_id, @QueryParam("amount") double amount) {
   //     TransactionServices transactionServices = new TransactionServices();
   //     return transactionServices.withdrawFromAccount(account_id, customer_id, amount);
   // }

    /*
    @Path("/customers/{customer_id}/accounts/{account_id}/transfers")
    public class TransferResources {

        TransferServices transferServices = newtransferServices();
        Transfer transfer = new Transfer();
        Entity Manager entityManager

     @GET
     @Produces(MediaType.APPLICATION_JSON)
        public List<Transfer> getTransfers

        {
            return transferService.getAllTransfers();
        }

        @GET
        @Path("/{transfer_id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Message getTransferJSON(@PathParam("transfer_Id") int transfer
         
            id) {
            return transferService.getTransfer(transfer_id);
            @POST
            @Consumes(MediaType.APPLICATION_JSON)
            @Produces(MediaType.APPLICATION_JSON)
            public Transfer postTransfer
            (Transfer t
        
            
                ) {
            return TransferService.createTransfer(t);
            }
            @GET
            @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
            @Path("{bank_transfer_id}")
            public BankTransfer getTransfer
            (@PathParam("bank_transfer_id")
            int bank_transfer_id
        
            
                ) {
            BankTransfer test = entityManager.find(BankTransfer.class, bank_transfer_id);
                if (test == null) {
                    throw new NotFoundException();
                }
                return test;
            }

            @GET
            @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
            @Path("/search")
            public BankTransfer getSearchTransfer
            (@Context
            UriInfo info
        
            
                ) {
        int bank_transfer_id = Integer.parseInt(info.getQueryParameters().getFirst("bank_transfer_id"));

                BankTransfer test = entityManager.find(BankTransfer.class, bank_transfer_id);
                if (test == null) {
                    throw new NotFoundException();
                }
                return test;
            }

            @GET
            @Path("/save")

            @Produces({MediaType.APPLICATION_JSON})

            public Response save
            (@Context
            UriInfo info
        
            
                ) {

        BankTransfer bt = new BankTransfer();

                int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
                int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
                int transaction_id = 0;
                String to_sort_code = info.getQueryParameters().getFirst("to_sort_code");
                String to_account = info.getQueryParameters().getFirst("to_account");

                byte[] array = new byte[7];
                new Random().nextBytes(array);
                String transaction_ref = new String(array, Charset.forName("UTF-8"));

                double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Date currDate = new Date();
                String date = dateFormat.format(currDate);
                String time = timeFormat.format(currDate);
                boolean verified = false;

                bt.setCustomer_id(customer_id);
                bt.setAccount_id(account_id);
                bt.setTransaction_id(transaction_id);
                bt.setTo_sort_code(to_sort_code);
                bt.setTo_account(to_account);
                bt.setTransacrion_ref(transaction_ref);
                bt.setAmount(amount);
                bt.setDate(date);
                bt.setTime(time);
                bt.setVerified(verified);

                System.out.println(bt);

                System.out.println();
                entityManager.getTransaction().begin();

                entityManager.persist(bt);
                entityManager.getTransaction().commit();

                entityManager.close();

                return Response.status(200).entity(bt).build();

            }

            @GET
            @Path("/update")

            public Response update
            (@Context
            UriInfo info
        
            
                ) {

        int bank_transfer_id = Integer.parseInt(info.getQueryParameters().getFirst("bank_transfer_id"));
                int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
                int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
                int transaction_id = 0;
                String to_sort_code = info.getQueryParameters().getFirst("to_sort_code");
                String to_account = info.getQueryParameters().getFirst("to_account");
                double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));

                BankTransfer removedTransfer = entityManager.find(BankTransfer.class, bank_transfer_id);
                if (removedTransfer == null) {
                    throw new NotFoundException();
                }

                String transaction_ref = removedTransfer.getTransacrion_ref();
                String date = removedTransfer.getDate();
                String time = removedTransfer.getTime();
                boolean verified = removedTransfer.isVerified();

                BankTransfer newTransfer = removedTransfer;

                entityManager.getTransaction().begin();

                newTransfer.setCustomer_id(customer_id);
                newTransfer.setAccount_id(account_id);
                newTransfer.setTransaction_id(transaction_id);
                newTransfer.setTo_sort_code(to_sort_code);
                newTransfer.setTo_account(to_account);
                newTransfer.setTransacrion_ref(transaction_ref);
                newTransfer.setAmount(amount);
                newTransfer.setDate(date);
                newTransfer.setTime(time);
                newTransfer.setVerified(verified);

                entityManager.remove(removedTransfer);
                entityManager.persist(newTransfer);
                entityManager.getTransaction().commit();

                entityManager.close();

                String message = "Record updated";
                return Response.status(200).entity(message).build();

            }
            @GET
            @Path("/delete")

            public Response delete
            (@Context
            UriInfo info
        
            
                ) {

        int bank_transfer_id = Integer.parseInt(info.getQueryParameters().getFirst("bank_transfer_id"));

                Transfer transfer = entityManager.find(BankTransfer.class, bank_transfer_id);
                if (transfer == null) {
                    throw new NotFoundException();
                }

                entityManager.getTransaction().begin();
                entityManager.remove(transfer);
                entityManager.getTransaction().commit();

                entityManager.close();

                String message = "Record deleted";
                return Response.status(200).entity(message).build();

            }
        }
     */
    //Gavin
 //   @GET
  //  @Path("/customer/{customer_id}/account/{accounts_id}/transaction/lodgement/{lodgement_id}")
   // public Transaction LodgeFunds(@QueryParam("account_id") int account_id, @QueryParam("customer_id") int customer_id, @QueryParam("amount") double amount) {
   //     TransactionServices transactionServices = new TransactionServices();
   //     return transactionServices.withdrawFromAccount(account_id, customer_id, amount);
   // }
    /*
    @Path("/lodgements")
    public class LodgementResources {

        EntityManager entityManager;

        public LodgementResources() {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("test-connection");
            entityManager = emfactory.createEntityManager();
        }

        @GET
        @Path("bank")
        public Response get() {
            CacheControl cc = new CacheControl();
            cc.setMaxAge(10000);
            System.out.println("\n\n\n\n+go");
            return Response.ok("Some Data").cacheControl(cc).build();
        }

        @GET
        @Produces({MediaType.APPLICATION_JSON})
        public Response getLodgements() {

            List<Lodgements> list = allEntries();

            GenericEntity entity = new GenericEntity<List<Lodgements>>(list) {
            };
            return Response.ok(entity).build();

        }

        @GET
        @Path("/all")
        @Produces({MediaType.APPLICATION_JSON})
        public Response getAllLodgements() {

            List<Lodgements> list = allEntries();

            GenericEntity entity = new GenericEntity<List<Lodgements>>(list) {
            };
            return Response.ok(entity).build();

        }

        public List<Lodgements> allEntries() {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Lodgements> cq = cb.createQuery(Lodgements.class);
            Root<Lodgements> rootEntry = cq.from(Lodgements.class);
            CriteriaQuery<Lodgements> all = cq.select(rootEntry);
            TypedQuery<Lodgements> allQuery = entityManager.createQuery(all);
            return allQuery.getResultList();
        }

        @GET
        @Produces({MediaType.APPLICATION_JSON})
        @Path("{lodgement_id}")
        public Lodgements getLodgement(@PathParam("lodgement_id") int lodgement_id) {
            Lodgements test = entityManager.find(Lodgements.class, lodgement_id);
            if (test == null) {
                throw new NotFoundException();
            }
            return test;
        }

        @GET
        @Produces({MediaType.APPLICATION_JSON})
        @Path("/search")
        public Lodgements getSearchLodgement(@Context UriInfo info) {
            int lodgement_id = Integer.parseInt(info.getQueryParameters().getFirst("lodgement_id"));

            Lodgements test = entityManager.find(Lodgements.class, lodgement_id);
            if (test == null) {
                throw new NotFoundException();
            }
            return test;
        }

        @GET
        @Path("/save")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces({MediaType.APPLICATION_JSON})
        public Response save(@Context UriInfo info) {

            Lodgements bl = new Lodgements();
            int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
            int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
            int transaction_id = 0;

            String from_card = info.getQueryParameters().getFirst("from_card");
            String card_encryption = "";
            for (int i = from_card.length() - 1; i >= 0; i--) {
                card_encryption = card_encryption + from_card.charAt(i);
            }

            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String transaction_ref = new String(array, Charset.forName("UTF-8"));

            double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date currDate = new Date();
            String date = dateFormat.format(currDate);
            String time = timeFormat.format(currDate);
            boolean verified = false;

            bl.setCustomer_id(customer_id);
            bl.setAccount_id(account_id);
            bl.setTransaction_id(transaction_id);
            bl.setFrom_card(from_card);
            bl.setCard_encryption(card_encryption);
            bl.setTransacrion_ref(transaction_ref);
            bl.setAmount(amount);
            bl.setDate(date);
            bl.setTime(time);
            bl.setVerified(verified);

            System.out.println(bl);

            System.out.println();

            return Response.status(200).entity(bl).build();
        }

        @GET
        @Path("/update")

        public Response update(@Context UriInfo info) {

            int lodgement_id = Integer.parseInt(info.getQueryParameters().getFirst("lodgement_id"));
            int customer_id = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
            int account_id = Integer.parseInt(info.getQueryParameters().getFirst("account_id"));
            double amount = Double.parseDouble(info.getQueryParameters().getFirst("amount"));
            int transaction_id = 0;

            Lodgements removedLodgement = entityManager.find(Lodgements.class, lodgement_id);
            if (removedLodgement == null) {
                throw new NotFoundException();
            }

            String date = removedLodgement.getDate();
            String time = removedLodgement.getTime();
            String from_card = removedLodgement.getFrom_card();
            String card_encryption = removedLodgement.getCard_encryption();
            String transaction_ref = removedLodgement.getTransacrion_ref();
            boolean verified = removedLodgement.isVerified();

            Lodgements newLodgement = removedLodgement;

            newLodgement.setCustomer_id(customer_id);
            newLodgement.setAccount_id(account_id);
            newLodgement.setTransaction_id(transaction_id);
            newLodgement.setFrom_card(from_card);
            newLodgement.setCard_encryption(card_encryption);
            newLodgement.setTransacrion_ref(transaction_ref);
            newLodgement.setAmount(amount);
            newLodgement.setDate(date);
            newLodgement.setTime(time);
            newLodgement.setVerified(verified);

            String message = "Record updated";
            return Response.status(200).entity(message).build();
        }

        @GET
        @Path("/delete")
        public Response delete(@Context UriInfo info) {

            int lodgement_id = Integer.parseInt(info.getQueryParameters().getFirst("lodgement_id"));
            Lodgements lodgement = entityManager.find(Lodgements.class, lodgement_id);
            if (lodgement == null) {
                throw new NotFoundException();
            }

//        entityManager.close();
            String message = "Record deleted";
            return Response.status(200).entity(message).build();
        }
     */

}
