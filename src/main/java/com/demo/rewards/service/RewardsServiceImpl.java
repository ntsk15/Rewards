package com.demo.rewards.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.rewards.model.Points;
import com.demo.rewards.model.Transaction;
import com.demo.rewards.repository.TransactionData;

@Service
public class RewardsServiceImpl implements RewardsService {
	public  final static int first=50;
	public  final static int second=100;

	/*
	 * Base method to get the total reward points
	 * */
	public static long calculatePoints(long total) {

		if (total <= first) {
			return 0l;
		} else if (total <= second) {
			return total - first;
		} else {
			return first + 2 * (total - second);
		}
	}

	/*Method to get the Transactions for the given time stamp which is currently loaded with dummy data
	 * This can be interlinked with the database and retrieved using the necessary CRUD operations.
	 * */
	private List<Transaction> getDataByTransactionDateBetween(Long custId,
			Timestamp firstTimestamp, Timestamp from) {
		List<Transaction> transactionsList =TransactionData.getAllTransactionData();
		List<Transaction> list=new ArrayList<Transaction>();
		for (Transaction transaction : transactionsList) {
			if(transaction.getCustomerId()==custId&&
					(transaction.getTransactionDate().getTime()>=firstTimestamp.getTime()
					&&transaction.getTransactionDate().getTime()<=from.getTime())) {
				list.add(transaction);
			}
		}
		return list;
	}

	/*
	 * Checks for the user if it is a valid customer id and get the timestamp of the last 3 months
	 * */
	@Override
	public Points getPointsByCustId(Long custId) {

		Timestamp firstTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(30));
		Timestamp secondTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(60));
		Timestamp thirdTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(90));

		boolean isValidUser =checkValidCustomerId(custId);
		if(!isValidUser)
			return null;

		List<Transaction> firstTransactions = getDataByTransactionDateBetween(custId, firstTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> secondTransactions = getDataByTransactionDateBetween(custId, secondTimestamp, firstTimestamp);
		List<Transaction> thirdTransactions = getDataByTransactionDateBetween(custId, thirdTimestamp,secondTimestamp);

		Long firstRewardPoints = getPointsPerMonth(firstTransactions);
		Long secondRewardPoints = getPointsPerMonth(secondTransactions);
		Long thirdRewardPoints = getPointsPerMonth(thirdTransactions);

		double total=firstRewardPoints + secondRewardPoints + thirdRewardPoints;
		Points points = new Points(custId,firstRewardPoints,secondRewardPoints,thirdRewardPoints,total);
		return points;
	}


	/*
	 * Checks if the given customer id is a valid customer as per the given data.
	 * */
	private boolean checkValidCustomerId(Long custId) {
		List<Transaction> transactionsList =TransactionData.getAllTransactionData();
		for (Transaction transaction : transactionsList) {
			if(transaction.getCustomerId()==custId)
				return true;			
		}
		return false;
	}

	/*
	 * Get the respective points per month for the given transaction data
	 * */
	@Override
	public Long getPointsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculatePoints(transaction.getTransactionAmount())).collect(Collectors.summingLong(r -> r.longValue()));
	}
}
