package me.jairam.jdbi;

import me.jairam.api.Transaction;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Optional;

@RegisterBeanMapper(Transaction.class)
public interface TransactionsDao {

    @SqlUpdate("insert into transactions values (:id, :firstname, :lastname, :item, :amount)")
    @org.jdbi.v3.sqlobject.transaction.Transaction
    boolean create(@BindBean Transaction transaction);

    @SqlQuery("select * from transactions where id = :id")
    Optional<Transaction> read(@Bind("id") String id);

    @SqlUpdate("update transactions set firstname = :firstname, lastname = :lastname, item = :item, amount = :amount where id = :id")
    @org.jdbi.v3.sqlobject.transaction.Transaction
    boolean update(@BindBean Transaction transaction);

    @SqlUpdate("delete from transactions where id = :id")
    @org.jdbi.v3.sqlobject.transaction.Transaction
    void delete(@Bind("id") String id);
}
