package sample.data.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.Objects;

/**
 * Created by Indrap on 12/15/2016.
 */
public class Invoice {
    @Id
    private String id;
    private String invCode;

    //tell database to save only the reference (not embed the customer document) but this is not working
    //when we use findObject_childProperties interface
    private Customer customer;
    private double totalInvc;
    private List<InvoiceItem> invItems;

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", invCode='" + invCode + '\'' +
                ", customer=" + customer +
                ", totalInvc=" + totalInvc +
                '}';
    }

    public Invoice(String invCode, Customer customer, double totalInvc) {

        this.invCode = invCode;
        this.customer = customer;
        this.totalInvc = totalInvc;
    }

    public List<InvoiceItem> getInvItems() {
        return invItems;
    }

    public void setInvItems(List<InvoiceItem> invItems) {
        this.invItems = invItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvCode() {
        return invCode;
    }

    public void setInvCode(String invCode) {
        this.invCode = invCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalInvc() {
        return totalInvc;
    }

    public void setTotalInvc(double totalInvc) {
        this.totalInvc = totalInvc;
    }
}
