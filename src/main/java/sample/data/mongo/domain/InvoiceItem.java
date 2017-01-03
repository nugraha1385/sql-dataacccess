package sample.data.mongo.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by Indrap on 12/15/2016.
 */
public class InvoiceItem {

    @Id
    private String id;
    private String itemCode;
    private String stockCode;
    private double itemQty;
    private double itemPrice;
    private double totalItemPrice;
    private double itemTax;
    private double itemDiscount;

    public InvoiceItem(String itemCode, String stockCode, double itemQty, double itemPrice) {
        this.itemCode = itemCode;
        this.stockCode = stockCode;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public double getItemQty() {
        return itemQty;
    }

    public void setItemQty(double itemQty) {
        this.itemQty = itemQty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public double getItemTax() {
        return itemTax;
    }

    public void setItemTax(double itemTax) {
        this.itemTax = itemTax;
    }

    public double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }
}
