package com.finastra.ett.financier.model;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "icc_marketplace", name = "BIDDING_DETAILS_REMARKS")
public class BiddingInvoice {
    
    public BiddingInvoice() {
    }
    @Id
    @Column(name = "Inv_Discount_Low")
   private Boolean Inv_Discount_Low;
   
   @Column(name = "Annual_Yield")
   private Boolean Annual_Yield;
   
   @Column(name = "Fundable_percentage_low")
   private Boolean Fundable_percentage_low;
   
   @Column(name = "Funding_Amount_High")
   private Boolean Funding_Amount_High;
   
   @Column(name = "Net_payable")
   private Boolean Net_payable;
   
   @Column(name = "Base_Amount")
   private Boolean Base_Amount;
   
   @Column(name = "invoiceAmt")
   private Boolean invoiceAmt;

   @Column(name = "Repayment_Date")
   private Boolean Repayment_Date;

   @Column(name = "Funding_CCY")
   private Boolean Funding_CCY;

   @Column(name = "Off_date")
   private Boolean Off_date;

   @Column(name = "Others")
   private Boolean Others;

   @Column(name = "OthersRemarks")
   private Boolean OthersRemarks;
   
   @ManyToOne
   @JoinColumn(name = "invoice_id")
   private BiddingDetails biddingDetails;

public Boolean getInv_Discount_Low() {
    return Inv_Discount_Low;
}
public void setInv_Discount_Low(Boolean inv_Discount_Low) {
    Inv_Discount_Low = inv_Discount_Low;
}
public Boolean getAnnual_Yield() {
    return Annual_Yield;
}
public void setAnnual_Yield(Boolean annual_Yield) {
    Annual_Yield = annual_Yield;
}
public Boolean getFundable_percentage_low() {
    return Fundable_percentage_low;
}
public void setFundable_percentage_low(Boolean fundable_percentage_low) {
    Fundable_percentage_low = fundable_percentage_low;
}
public Boolean getFunding_Amount_High() {
    return Funding_Amount_High;
}
public void setFunding_Amount_High(Boolean funding_Amount_High) {
    Funding_Amount_High = funding_Amount_High;
}
public Boolean getNet_payable() {
    return Net_payable;
}
public void setNet_payable(Boolean net_payable) {
    Net_payable = net_payable;
}
public Boolean getBase_Amount() {
    return Base_Amount;
}
public void setBase_Amount(Boolean base_Amount) {
    Base_Amount = base_Amount;
}
public Boolean getInvoiceAmt() {
    return invoiceAmt;
}
public void setInvoiceAmt(Boolean invoiceAmt) {
    this.invoiceAmt = invoiceAmt;
}
public Boolean getRepayment_Date() {
    return Repayment_Date;
}
public void setRepayment_Date(Boolean repayment_Date) {
    Repayment_Date = repayment_Date;
}
public Boolean getFunding_CCY() {
    return Funding_CCY;
}
public void setFunding_CCY(Boolean funding_CCY) {
    Funding_CCY = funding_CCY;
}
public Boolean getOff_date() {
    return Off_date;
}
public void setOff_date(Boolean off_date) {
    Off_date = off_date;
}
public Boolean getOthers() {
    return Others;
}
public void setOthers(Boolean others) {
    Others = others;
}
public Boolean getOthersRemarks() {
    return OthersRemarks;
}
public void setOthersRemarks(Boolean othersRemarks) {
    OthersRemarks = othersRemarks;
}
public BiddingDetails getBiddingDetails() {
    return biddingDetails;
}
public void setBiddingDetails(BiddingDetails biddingDetails) {
    this.biddingDetails = biddingDetails;
}
public BiddingInvoice(Boolean inv_Discount_Low, Boolean annual_Yield, Boolean fundable_percentage_low,
        Boolean funding_Amount_High, Boolean net_payable, Boolean base_Amount, Boolean invoiceAmt,
        Boolean repayment_Date, Boolean funding_CCY, Boolean off_date, Boolean others, Boolean othersRemarks,
        BiddingDetails biddingDetails) {
    Inv_Discount_Low = inv_Discount_Low;
    Annual_Yield = annual_Yield;
    Fundable_percentage_low = fundable_percentage_low;
    Funding_Amount_High = funding_Amount_High;
    Net_payable = net_payable;
    Base_Amount = base_Amount;
    this.invoiceAmt = invoiceAmt;
    Repayment_Date = repayment_Date;
    Funding_CCY = funding_CCY;
    Off_date = off_date;
    Others = others;
    OthersRemarks = othersRemarks;
    this.biddingDetails = biddingDetails;
}

   
}
