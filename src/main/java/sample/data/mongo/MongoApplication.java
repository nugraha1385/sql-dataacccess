package sample.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sample.data.mongo.dataaccess.CustomerRepository;
import sample.data.mongo.dataaccess.InvoiceRepository;
import sample.data.mongo.domain.Customer;
import sample.data.mongo.domain.Invoice;

import java.util.List;

/**
 * Created by Indrap on 12/13/2016.
 */

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;



    public static void main(String[] args){
        SpringApplication.run(MongoApplication.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        this.customerRepository.deleteAll();
        Customer indra = new Customer("Indra","Nugraha");
        Customer hendra =new Customer("Hendra","Nugraha");
        Customer rifa =new Customer("Rifa","Nurafifah");
        Customer koko =new Customer("Koko","Nugraha");

        this.customerRepository.save(indra);
        this.customerRepository.save(rifa);
        this.customerRepository.save(hendra);
        this.customerRepository.save(koko);

        System.out.println("--------------Find All-------------------");
        List<Customer> listAllCustomer = customerRepository.findAll();
        for(Customer customer : listAllCustomer){
            System.out.println(customer);
        }
        System.out.println("--------------Find First Name-------------------");

        listAllCustomer = customerRepository.findByLastName("Nugraha");
        for(Customer customer : listAllCustomer){
            System.out.println(customer);
        }

        System.out.println("--------------Find First & Last Name-------------------");

        listAllCustomer = customerRepository.findByFirstNameAndLastName("Indra","Nugraha");
        for(Customer customer : listAllCustomer){
            System.out.println(customer);
        }



        System.out.println("--------------Find Paging of 2 Item-------------------");

        Page<Customer> listAllCustomerPageable = customerRepository.findByLastName("Nugraha",new PageRequest(0,2));
        for(Customer customer : listAllCustomerPageable){
            System.out.println(customer);
        }


        this.invoiceRepository.deleteAll();
        this.invoiceRepository.save(new Invoice("INV001",indra,600));
        this.invoiceRepository.save(new Invoice("INV002",indra,700));
        this.invoiceRepository.save(new Invoice("INV003",rifa,300));
        this.invoiceRepository.save(new Invoice("INV004",rifa,200));

        System.out.println("-------------- Get All Invoice ------------------");

        List<Invoice> listInvoice = invoiceRepository.findAll();
        for(Invoice invoice : listInvoice){
            System.out.println(invoice);
        }

        System.out.println("-------------- Find by InvCode ------------------");

        listInvoice = invoiceRepository.findByInvCodeManual("INV002");
        for(Invoice invoice : listInvoice){
            System.out.println(invoice);
        }

        System.out.println("-------------- Find by Customer Last Name ------------------");

        listInvoice = invoiceRepository.findByCustomer_LastName("Nugraha");
        for(Invoice invoice : listInvoice){
            System.out.println(invoice);
        }




    }
}
