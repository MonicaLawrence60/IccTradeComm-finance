package com.finastra.ett.financier.controller;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "icc_marketplace", name = "testing")
public class testing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key97")
    private long key97;

    @Column(name = "description", length = 100)
    private String descGoods;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "quantity_type", length = 25)
    private String quantityType;

    @Column(name = "rate", columnDefinition = "Decimal(15,2)")
    private int rate;

    @Column(name = "ccy", columnDefinition = "char(3)")
    private String amtCcy;

    @Column(name = "amount", columnDefinition = "Decimal(15,2)")
    private int amt;

    @Column(name = "disc_amt", columnDefinition = "Decimal(15,2)")
    private int discAmt;

    @Column(name = "net_amt", columnDefinition = "Decimal(15,2)")
    private int netAmtPay;

    @Column(name = "tax_rate", columnDefinition = "Decimal(10,2)")
    private int taxRate;

    @Column(name = "tax_amt", columnDefinition = "Decimal(15,2)")
    private int taxAmt;

    @Column(name = "total_amt", columnDefinition = "Decimal(15,2)")
    private int total;

    @Column(name = "status", columnDefinition = "char(1) default 'I'", insertable = false)
    private String status;

    public long getKey97() {
        return key97;
    }

    public void setKey97(long key97) {
        this.key97 = key97;
    }

    public String getDescGoods() {
        return descGoods;
    }

    public void setDescGoods(String descGoods) {
        this.descGoods = descGoods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAmtCcy() {
        return amtCcy;
    }

    public void setAmtCcy(String amtCcy) {
        this.amtCcy = amtCcy;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getDiscAmt() {
        return discAmt;
    }

    public void setDiscAmt(int discAmt) {
        this.discAmt = discAmt;
    }

    public int getNetAmtPay() {
        return netAmtPay;
    }

    public void setNetAmtPay(int netAmtPay) {
        this.netAmtPay = netAmtPay;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    public int getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(int taxAmt) {
        this.taxAmt = taxAmt;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public testing(long key97, String descGoods, int quantity, String quantityType, int rate, String amtCcy, int amt,
            int discAmt, int netAmtPay, int taxRate, int taxAmt, int total, String status) {
        this.key97 = key97;
        this.descGoods = descGoods;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.rate = rate;
        this.amtCcy = amtCcy;
        this.amt = amt;
        this.discAmt = discAmt;
        this.netAmtPay = netAmtPay;
        this.taxRate = taxRate;
        this.taxAmt = taxAmt;
        this.total = total;
        this.status = status;
    }

    
}
