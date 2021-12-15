package com.mycompany.bankapi.resources;

import com.mycompany.bankclient.models.Lodgements;
import com.mycompany.bankclient.services.LodgementServices;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*
 * @author Gavin Corr x18382836
 */
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
   
}


