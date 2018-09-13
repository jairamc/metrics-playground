package com.meltwater.wrapidity.resources;

import com.codahale.metrics.annotation.Timed;
import com.meltwater.wrapidity.api.Transaction;
import com.meltwater.wrapidity.jdbi.TransactionsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private TransactionsDao dao;

    public TransactionResource(TransactionsDao dao) {
        this.dao = dao;
    }


    @POST
    @Timed
    public Transaction create(Transaction transaction) throws Exception {
        logger.info("Creating a new transaction with id " + transaction.getId());
        if (dao.create(transaction)) {
            return transaction;
        } else {
            throw new Exception("Failed to create Transaction");
        }
    }

    @GET
    @Timed
    public Optional<Transaction> read(@QueryParam("id") String id) {
        return dao.read(id);
    }

    @PUT
    @Timed
    public Transaction update(Transaction transaction) throws Exception {
        if (dao.update(transaction)) {
            return transaction;
        } else {
            throw new Exception("Failed to update Transaction");
        }
    }

    @DELETE
    @Timed
    public void delete(@QueryParam("id") String id) {
        dao.delete(id);
    }
}
