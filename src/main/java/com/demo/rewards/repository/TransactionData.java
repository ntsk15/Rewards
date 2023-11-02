package com.demo.rewards.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.rewards.model.Transaction;

public class TransactionData {

	public static List<Transaction>  getAllTransactionData() {
		List<Transaction> transactions=new ArrayList<>();

		Transaction transaction1=new Transaction(1l,101,new Timestamp(new Date().getTime()),1l);
		transactions.add(transaction1);

		Transaction transaction2=new Transaction(2l,102,new Timestamp(new Date().getTime()),2l);
		transactions.add(transaction2);

		Transaction transaction3=new Transaction(3l,103,new Timestamp(new Date().getTime()),3l);
		transactions.add(transaction3);

		Transaction transaction4=new Transaction(4l,104,Timestamp.valueOf("2023-10-09 00:00:00"),1l);
		transactions.add(transaction4);

		Transaction transaction5=new Transaction(2l,105,Timestamp.valueOf("2023-10-09 00:00:00"),2l);
		transactions.add(transaction5);

		Transaction transaction6=new Transaction(3l,106,Timestamp.valueOf("2023-10-09 00:00:00"),3l);
		transactions.add(transaction6);

		Transaction transaction7=new Transaction(4l,107,Timestamp.valueOf("2023-09-09 00:00:00"),1l);
		transactions.add(transaction7);

		Transaction transaction8=new Transaction(2l,108,Timestamp.valueOf("2023-09-09 00:00:00"),2l);
		transactions.add(transaction8);

		Transaction transaction9=new Transaction(3l,109,Timestamp.valueOf("2023-09-09 00:00:00"),3l);
		transactions.add(transaction9);

		return transactions;

	}
}
