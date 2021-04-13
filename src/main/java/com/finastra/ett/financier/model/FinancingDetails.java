package com.finastra.ett.financier.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

 @Entity
 @Table(schema = "icc_marketplace",name="FINANCING_DETAILS")
 
public class FinancingDetails {

    public FinancingDetails(){}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fin_key")
	private long id;

    @Column(name = "fin_id")
    private String finId;

    @Column(name = "SME_ID")
    private String smeId;

    @Column(name = "inv_key")
    private long invKey;

    @Column(name = "bid_key")
    private long bidKey;

    @Column(name = "bid_Acc_key")
    private long bidAccKey;

    @Column(name = "finance_ccy")
    private String financeCcy; 

    @Column(name = "finance_amt")
    private Double baseCcyNetAmtPayable;

    @Column(name = "REPAYMENT_DATE")
    private Date RepaymentDate;
 

    @Column(name = "ANNUAL_YEILD")
    private String annualYeild;

    @Column(name = "STATUS")
    private String status; 

    @Column(name = "INV_ID")
    private String invoiceId;

    @Column(name ="INV_NO")
    private String invoiceNo;

    @Column(name = "EXPIRY_DATE_TIME")
    private Date finIntiatedDate;

    @Column(name ="fin_file_id")
    private String finFileId;

    @Column(name ="creationSource")
    private String creationSource;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finance_date")
    private Date financeDate;

   @Column(name = "BASECCY_FUNDAMT")
   private Double baseCcyFundingAmt;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getFinId() {
    return finId;
}

public void setFinId(String finId) {
    this.finId = finId;
}

public String getSmeId() {
    return smeId;
}

public void setSmeId(String smeId) {
    this.smeId = smeId;
}

public long getInvKey() {
    return invKey;
}

public void setInvKey(long invKey) {
    this.invKey = invKey;
}

public long getBidKey() {
    return bidKey;
}

public void setBidKey(long bidKey) {
    this.bidKey = bidKey;
}

public long getBidAccKey() {
    return bidAccKey;
}

public void setBidAccKey(long bidAccKey) {
    this.bidAccKey = bidAccKey;
}

public String getFinanceCcy() {
    return financeCcy;
}

public void setFinanceCcy(String financeCcy) {
    this.financeCcy = financeCcy;
}

public Double getBaseCcyNetAmtPayable() {
    return baseCcyNetAmtPayable;
}

public void setBaseCcyNetAmtPayable(Double baseCcyNetAmtPayable) {
    this.baseCcyNetAmtPayable = baseCcyNetAmtPayable;
}

public Date getRepaymentDate() {
    return RepaymentDate;
}

public void setRepaymentDate(Date repaymentDate) {
    RepaymentDate = repaymentDate;
}

public String getAnnualYeild() {
    return annualYeild;
}

public void setAnnualYeild(String annualYeild) {
    this.annualYeild = annualYeild;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getInvoiceId() {
    return invoiceId;
}

public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
}

public String getInvoiceNo() {
    return invoiceNo;
}

public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
}

public Date getFinIntiatedDate() {
    return finIntiatedDate;
}

public void setFinIntiatedDate(Date finIntiatedDate) {
    this.finIntiatedDate = finIntiatedDate;
}

public String getFinFileId() {
    return finFileId;
}

public void setFinFileId(String finFileId) {
    this.finFileId = finFileId;
}

public String getCreationSource() {
    return creationSource;
}

public void setCreationSource(String creationSource) {
    this.creationSource = creationSource;
}

public Date getFinanceDate() {
    return financeDate;
}

public void setFinanceDate(Date financeDate) {
    this.financeDate = financeDate;
}

public Double getBaseCcyFundingAmt() {
    return baseCcyFundingAmt;
}

public void setBaseCcyFundingAmt(Double baseCcyFundingAmt) {
    this.baseCcyFundingAmt = baseCcyFundingAmt;
}

public FinancingDetails(long id, String finId, String smeId, long invKey, long bidKey, long bidAccKey,
        String financeCcy, Double baseCcyNetAmtPayable, Date repaymentDate, String annualYeild, String status,
        String invoiceId, String invoiceNo, Date finIntiatedDate, String finFileId, String creationSource,
        Date financeDate, Double baseCcyFundingAmt) {
    this.id = id;
    this.finId = finId;
    this.smeId = smeId;
    this.invKey = invKey;
    this.bidKey = bidKey;
    this.bidAccKey = bidAccKey;
    this.financeCcy = financeCcy;
    this.baseCcyNetAmtPayable = baseCcyNetAmtPayable;
    RepaymentDate = repaymentDate;
    this.annualYeild = annualYeild;
    this.status = status;
    this.invoiceId = invoiceId;
    this.invoiceNo = invoiceNo;
    this.finIntiatedDate = finIntiatedDate;
    this.finFileId = finFileId;
    this.creationSource = creationSource;
    this.financeDate = financeDate;
    this.baseCcyFundingAmt = baseCcyFundingAmt;
}


  
    
 

   
}
