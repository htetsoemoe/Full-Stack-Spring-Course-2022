package com.jdc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@IdClass(SalePK.class)
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seq_number", nullable = false)
	private int seqNumber;
	@Id
	@Column(name = "transaction_type", nullable = false)
	private int transactionType;

	private int sales;
	
	@Basic(optional = false)
	@Lob
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "sale_date")
	private Date saleDate;
	
	@Transient
	private boolean deleted;

	public int getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
