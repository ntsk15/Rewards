package com.demo.rewards.model;

import java.sql.Timestamp;

public class Transaction {
    
    private Long transactionId;

    private Long custId;

    private Timestamp transactionDate;

    private long transactionAmount;

    public Transaction()
    {
    }

    public Transaction( Long custId, long transactionAmount,Timestamp transactionDate,Long transactionId) {
		super();
		this.transactionId = transactionId;
		this.custId = custId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getCustomerId() {
        return custId;
    }

    public void setCustomerId(Long custId) {
        this.custId = custId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
