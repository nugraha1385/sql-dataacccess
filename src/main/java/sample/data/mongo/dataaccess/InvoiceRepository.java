package sample.data.mongo.dataaccess;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import sample.data.mongo.domain.Customer;
import sample.data.mongo.domain.Invoice;

import java.util.List;

/**
 * Created by Indrap on 12/15/2016.
 */
public interface InvoiceRepository extends MongoRepository<Invoice,String> {
    public List<Invoice> findByInvCode (String invCode);

    //query manually
    @Query("{invCode:?0}")
    public List<Invoice> findByInvCodeManual (String invCode);

    //traversing nested property, not working on reference element(example usign DBref)
    public List<Invoice> findByCustomer_LastName(String lastName);
}
