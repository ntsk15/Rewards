package com.demo.rewards.service;

import java.util.List;

import com.demo.rewards.model.Points;
import com.demo.rewards.model.Transaction;

public interface RewardsService {
	public Points getPointsByCustId(Long custId);

	public Long getPointsPerMonth(List<Transaction> transactionList);
}
