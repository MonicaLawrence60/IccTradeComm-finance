package com.finastra.ett.financier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="FINANCE_BIDDING")
public class Financier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "BID_REF_NO")
	private String bidRefNo;

	@Column(name = "FINANCIER_NAME")
	private String financierName;

	@Column(name = "FINANCIER_AMT")
	private String financierAmount;

	@Column(name = "CCY")
	private String financierCurrency;

	@Column(name = "FX_RATE")
	private String fxRate;

	@Column(name = "MARGIN")
	private String margin;

	@Column(name = "DISC_RATE")
	private String discRate;

	@Column(name = "DISC_AMT")
	private String discAmount;

	@Column(name = "NET_AMT_DISC")
	private String netAmountDisc;

	@Column(name = "NET_AMT")
	private String netAmount;

	@Column(name = "DUE_DATE")
	private String dueDate;

	@Column(name = "EXPIRY_PERIOD")
	private String expiryPeriod;

	@Column(name = "STATUS")
	private String status;
	
	
	public Financier(){}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getBidRefNo() {
		return bidRefNo;
	}



	public void setBidRefNo(String bidRefNo) {
		this.bidRefNo = bidRefNo;
	}



	public String getFinancierName() {
		return financierName;
	}



	public void setFinancierName(String financierName) {
		this.financierName = financierName;
	}



	public String getFinancierAmount() {
		return financierAmount;
	}



	public void setFinancierAmount(String financierAmount) {
		this.financierAmount = financierAmount;
	}



	public String getFinancierCurrency() {
		return financierCurrency;
	}



	public void setFinancierCurrency(String financierCurrency) {
		this.financierCurrency = financierCurrency;
	}



	public String getFxRate() {
		return fxRate;
	}



	public void setFxRate(String fxRate) {
		this.fxRate = fxRate;
	}



	public String getMargin() {
		return margin;
	}



	public void setMargin(String margin) {
		this.margin = margin;
	}



	public String getDiscRate() {
		return discRate;
	}



	public void setDiscRate(String discRate) {
		this.discRate = discRate;
	}



	public String getDiscAmount() {
		return discAmount;
	}



	public void setDiscAmount(String discAmount) {
		this.discAmount = discAmount;
	}



	public String getNetAmountDisc() {
		return netAmountDisc;
	}



	public void setNetAmountDisc(String netAmountDisc) {
		this.netAmountDisc = netAmountDisc;
	}



	public String getNetAmount() {
		return netAmount;
	}



	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}



	public String getDueDate() {
		return dueDate;
	}



	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}



	public String getExpiryPeriod() {
		return expiryPeriod;
	}



	public void setExpiryPeriod(String expiryPeriod) {
		this.expiryPeriod = expiryPeriod;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Financier(String bidRefNo, String financierName, String financierAmount, String financierCurrency,
			String fxRate, String margin, String discRate, String discAmount, String netAmountDisc, String netAmount,
			String dueDate, String expiryPeriod, String status) {
				super();
		this.bidRefNo = bidRefNo;
		this.financierName = financierName;
		this.financierAmount = financierAmount;
		this.financierCurrency = financierCurrency;
		this.fxRate = fxRate;
		this.margin = margin;
		this.discRate = discRate;
		this.discAmount = discAmount;
		this.netAmountDisc = netAmountDisc;
		this.netAmount = netAmount;
		this.dueDate = dueDate;
		this.expiryPeriod = expiryPeriod;
		this.status = status;
	}



	public Financier(long id) {
		this.id = id;
	}

	

	
}