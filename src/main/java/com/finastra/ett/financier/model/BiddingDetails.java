package com.finastra.ett.financier.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@Table(schema = "icc_marketplace", name = "BIDDING_DETAIL")
public class BiddingDetails {
    public BiddingDetails(){}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_key")
	private long id;

    @Column(name = "inv_key")
    private long invoiceId;

    @Column(name = "invNo")
    private String invNo;

    @Column(name = "bid_id")
    private String bidId;
    
    @Column(name = "fin_id")
    private String finId;

    @Column(name = "BASECCYAMT" ,columnDefinition = "Decimal(15,2)")
    private Double  baseCcyAmt;

    @Column(name = "funding_ccy")
    private String fundingCcy;

    @Column(name = "funding_amt" ,columnDefinition = "Decimal(15,2)")
    private Double baseCcyFundingAmt;
    
    
   @Column(name = "fxrate")
   private String fxRate;

   @Column(name = "inv_fundccy")
   private String invFundCcy;

   @Column(name = "inv_amt")
   private Double invoiceAmt;

   @Column(name = "funding_percent")
   private String fundablePercent;

   @Column(name = "funding_invccy")
   private String fundingInvCcy;

   @Column(name = "funding_amt_invccy" ,columnDefinition = "Decimal(15,2)")
   private Double invCcyFundingAmt;
   
   @Column(name = "Repay_date")
   private String RepaymentDate;

   @Column(name = "Inv_disc_percent")
   private String invDiscRate;

   @Column(name = "disc_amt_fundccy" ,columnDefinition = "Decimal(15,2)")
   private Double baseCcyDiscAmt;

   @Column(name = "disc_fundccy")
   private String fundCcyDisc;
   
   @Column(name = "disc_amt_invccy" ,columnDefinition = "Decimal(15,2)")
   private Double invCcyDiscAmt;

   @Column(name = "disc_invccy")
   private String invCcyDisc;
   
   @Column(name = "Annual_yield")
   private String annualYeild;

   @Column(name = "Tenor_days")
   private String tenor;

   @Column(name = "Payable_amt_fundccy",columnDefinition = "Decimal(15,2)")
   private Double baseCcyNetAmtPayable;
   
   @Column(name = "Payable_fundccy")
   private String baseCcyFunding;

   @Column(name = "Payable_amt_invccy",columnDefinition = "Decimal(15,2)")
   private Double invCcyNetAmtPayable;
   
   @Column(name = "payable_invccy")
   private String payableInvCcy;

   @Column(name = "Offer_ExpiryPeriod")
    private String offerExpPeriod;

    @Column(name = "Offer_Expiry_Date")
    private Date offerExpDateTime;

    @Column(name = "Offer_Notes")
    private String OfferNotes;

    @Column(name = "Fin_Bid_Status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    @OneToMany(targetEntity = BiddingDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<BiddingInvoice> biddingInvoice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getFinId() {
        return finId;
    }

    public void setFinId(String finId) {
        this.finId = finId;
    }

    public Double getBaseCcyAmt() {
        return baseCcyAmt;
    }

    public void setBaseCcyAmt(Double baseCcyAmt) {
        this.baseCcyAmt = baseCcyAmt;
    }

    public String getFundingCcy() {
        return fundingCcy;
    }

    public void setFundingCcy(String fundingCcy) {
        this.fundingCcy = fundingCcy;
    }

    public Double getBaseCcyFundingAmt() {
        return baseCcyFundingAmt;
    }

    public void setBaseCcyFundingAmt(Double baseCcyFundingAmt) {
        this.baseCcyFundingAmt = baseCcyFundingAmt;
    }

    public String getFxRate() {
        return fxRate;
    }

    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }


    public Double getInvoiceAmt() {
        return invoiceAmt;
    }

    public void setInvoiceAmt(Double invoiceAmt) {
        this.invoiceAmt = invoiceAmt;
    }

    public String getFundablePercent() {
        return fundablePercent;
    }

    public void setFundablePercent(String fundablePercent) {
        this.fundablePercent = fundablePercent;
    }

    public String getFundingInvCcy() {
        return fundingInvCcy;
    }

    public void setFundingInvCcy(String fundingInvCcy) {
        this.fundingInvCcy = fundingInvCcy;
    }

  
    public String getRepaymentDate() {
        return RepaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        RepaymentDate = repaymentDate;
    }

    public String getInvDiscRate() {
        return invDiscRate;
    }

    public void setInvDiscRate(String invDiscRate) {
        this.invDiscRate = invDiscRate;
    }

    public Double getBaseCcyDiscAmt() {
        return baseCcyDiscAmt;
    }

    public void setBaseCcyDiscAmt(Double baseCcyDiscAmt) {
        this.baseCcyDiscAmt = baseCcyDiscAmt;
    }

    public String getFundCcyDisc() {
        return fundCcyDisc;
    }

    public void setFundCcyDisc(String fundCcyDisc) {
        this.fundCcyDisc = fundCcyDisc;
    }

    public Double getInvCcyDiscAmt() {
        return invCcyDiscAmt;
    }

    public void setInvCcyDiscAmt(Double invCcyDiscAmt) {
        this.invCcyDiscAmt = invCcyDiscAmt;
    }

    public String getInvCcyDisc() {
        return invCcyDisc;
    }

    public void setInvCcyDisc(String invCcyDisc) {
        this.invCcyDisc = invCcyDisc;
    }

    public String getAnnualYeild() {
        return annualYeild;
    }

    public void setAnnualYeild(String annualYeild) {
        this.annualYeild = annualYeild;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public Double getBaseCcyNetAmtPayable() {
        return baseCcyNetAmtPayable;
    }

    public void setBaseCcyNetAmtPayable(Double baseCcyNetAmtPayable) {
        this.baseCcyNetAmtPayable = baseCcyNetAmtPayable;
    }

    public String getBaseCcyFunding() {
        return baseCcyFunding;
    }

    public void setBaseCcyFunding(String baseCcyFunding) {
        this.baseCcyFunding = baseCcyFunding;
    }

    public Double getInvCcyNetAmtPayable() {
        return invCcyNetAmtPayable;
    }

    public void setInvCcyNetAmtPayable(Double invCcyNetAmtPayable) {
        this.invCcyNetAmtPayable = invCcyNetAmtPayable;
    }

    public String getPayableInvCcy() {
        return payableInvCcy;
    }

    public void setPayableInvCcy(String payableInvCcy) {
        this.payableInvCcy = payableInvCcy;
    }

    public String getOfferExpPeriod() {
        return offerExpPeriod;
    }

    public void setOfferExpPeriod(String offerExpPeriod) {
        this.offerExpPeriod = offerExpPeriod;
    }

    public Date getOfferExpDateTime() {
        return offerExpDateTime;
    }

    public void setOfferExpDateTime(Date offerExpDateTime) {
        this.offerExpDateTime = offerExpDateTime;
    }

    public String getOfferNotes() {
        return OfferNotes;
    }

    public void setOfferNotes(String offerNotes) {
        OfferNotes = offerNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

  

    public String getInvFundCcy() {
        return invFundCcy;
    }

    public void setInvFundCcy(String invFundCcy) {
        this.invFundCcy = invFundCcy;
    }

    public Double getInvCcyFundingAmt() {
        return invCcyFundingAmt;
    }

    public void setInvCcyFundingAmt(Double invCcyFundingAmt) {
        this.invCcyFundingAmt = invCcyFundingAmt;
    }


    public List<BiddingInvoice> getBiddingInvoice() {
        return biddingInvoice;
    }

    public void setBiddingInvoice(List<BiddingInvoice> biddingInvoice) {
        this.biddingInvoice = biddingInvoice;
    }

    public BiddingDetails(long id, long invoiceId, String invNo, String bidId, String finId, Double baseCcyAmt,
            String fundingCcy, Double baseCcyFundingAmt, String fxRate, String invFundCcy, Double invoiceAmt,
            String fundablePercent, String fundingInvCcy, Double invCcyFundingAmt, String repaymentDate,
            String invDiscRate, Double baseCcyDiscAmt, String fundCcyDisc, Double invCcyDiscAmt, String invCcyDisc,
            String annualYeild, String tenor, Double baseCcyNetAmtPayable, String baseCcyFunding,
            Double invCcyNetAmtPayable, String payableInvCcy, String offerExpPeriod, Date offerExpDateTime,
            String offerNotes, String status, String remarks, List<BiddingInvoice> biddingInvoice) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.invNo = invNo;
        this.bidId = bidId;
        this.finId = finId;
        this.baseCcyAmt = baseCcyAmt;
        this.fundingCcy = fundingCcy;
        this.baseCcyFundingAmt = baseCcyFundingAmt;
        this.fxRate = fxRate;
        this.invFundCcy = invFundCcy;
        this.invoiceAmt = invoiceAmt;
        this.fundablePercent = fundablePercent;
        this.fundingInvCcy = fundingInvCcy;
        this.invCcyFundingAmt = invCcyFundingAmt;
        RepaymentDate = repaymentDate;
        this.invDiscRate = invDiscRate;
        this.baseCcyDiscAmt = baseCcyDiscAmt;
        this.fundCcyDisc = fundCcyDisc;
        this.invCcyDiscAmt = invCcyDiscAmt;
        this.invCcyDisc = invCcyDisc;
        this.annualYeild = annualYeild;
        this.tenor = tenor;
        this.baseCcyNetAmtPayable = baseCcyNetAmtPayable;
        this.baseCcyFunding = baseCcyFunding;
        this.invCcyNetAmtPayable = invCcyNetAmtPayable;
        this.payableInvCcy = payableInvCcy;
        this.offerExpPeriod = offerExpPeriod;
        this.offerExpDateTime = offerExpDateTime;
        OfferNotes = offerNotes;
        this.status = status;
        this.remarks = remarks;
        this.biddingInvoice = biddingInvoice;
    }

    
   
    
}