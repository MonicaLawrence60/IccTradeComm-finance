package com.finastra.ett.financier.model;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(schema = "icc_marketplace",name="invoiceDetails")
public class InvoiceDetails implements Serializable {
    
    public InvoiceDetails(){}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_dtls_key")
	private long id;

    // @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "inv_key")
	// private long invKey;

   

    @Column(name = "SME_ID")
    private String smeId;

    @Column(name ="ref_no")
    private String invoiceRef;

    @Column(name ="INV_NO")
    private String invoiceNo;
       
    @Column(name = "INV_AMT")
    private Double invoiceAmt;

    @Column(name = "INV_CCY")
    private String invoiceCcy;

    @Column(name = "BUYER_NAME")
    private String buyerName;
    
    @Column(name = "Req_Date")
    private Date invoiceDate; 

    @Column(name = "DUE_DATE")
    private Date invDueDate;

    @Column(name = "INV_ID")
    private String invoiceId;
    
    @Column(name = "Buyer_Location")
    private String buyerAddr;

    @Column(name = "dispatch_date")
    private Date dispDate;

    @Column(name = "base_amt",columnDefinition = "Decimal(15,2)")
    private Double baseAmt;
    
    @Column(name = "base_ccy")
    private String baseCcy;

    @Column(name = "fxrate")
    private String fxRate;

    @Column(name = "transaction_rating")
    private int transactionRating;

    @Column(name = "sme_rating")
    private int smeRating;
   
    @Column(name = "source")
    private String source;

    @Column(name = "status")
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

  

    public String getSmeId() {
        return smeId;
    }

    public void setSmeId(String smeId) {
        this.smeId = smeId;
    }

    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Double getInvoiceAmt() {
        return invoiceAmt;
    }

    public void setInvoiceAmt(Double invoiceAmt) {
        this.invoiceAmt = invoiceAmt;
    }

    public String getInvoiceCcy() {
        return invoiceCcy;
    }

    public void setInvoiceCcy(String invoiceCcy) {
        this.invoiceCcy = invoiceCcy;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvDueDate() {
        return invDueDate;
    }

    public void setInvDueDate(Date invDueDate) {
        this.invDueDate = invDueDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }


    public Double getBaseAmt() {
        return baseAmt;
    }

    public void setBaseAmt(Double baseAmt) {
        this.baseAmt = baseAmt;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    public String getFxRate() {
        return fxRate;
    }

    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    public int getTransactionRating() {
        return transactionRating;
    }

    public void setTransactionRating(int transactionRating) {
        this.transactionRating = transactionRating;
    }

    public int getSmeRating() {
        return smeRating;
    }

    public void setSmeRating(int smeRating) {
        this.smeRating = smeRating;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuyerAddr() {
        return buyerAddr;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public InvoiceDetails(long id, String smeId, String invoiceRef, String invoiceNo, Double invoiceAmt,
            String invoiceCcy, String buyerName, Date invoiceDate, Date invDueDate, String invoiceId, String buyerAddr,
            Date dispDate, Double baseAmt, String baseCcy, String fxRate, int transactionRating, int smeRating,
            String source, String status) {
        this.id = id;
        this.smeId = smeId;
        this.invoiceRef = invoiceRef;
        this.invoiceNo = invoiceNo;
        this.invoiceAmt = invoiceAmt;
        this.invoiceCcy = invoiceCcy;
        this.buyerName = buyerName;
        this.invoiceDate = invoiceDate;
        this.invDueDate = invDueDate;
        this.invoiceId = invoiceId;
        this.buyerAddr = buyerAddr;
        this.dispDate = dispDate;
        this.baseAmt = baseAmt;
        this.baseCcy = baseCcy;
        this.fxRate = fxRate;
        this.transactionRating = transactionRating;
        this.smeRating = smeRating;
        this.source = source;
        this.status = status;
    }

   

   
    
}