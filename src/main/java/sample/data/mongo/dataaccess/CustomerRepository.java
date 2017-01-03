package sample.data.mongo.dataaccess;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import sample.data.mongo.domain.Customer;

import java.util.List;

/**
 * Created by Indrap on 12/13/2016.
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {
    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName (String lastName);
    public List<Customer> findByFirstNameAndLastName (String firstName,String lastName);
    public Page<Customer> findByLastName(String lastName, Pageable pageable);


}
