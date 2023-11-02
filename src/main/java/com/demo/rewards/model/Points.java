package com.demo.rewards.model;

public class Points {
	private long custId;
	private double firstPoints;
	private double secondPoints;
	private double thirdPoints;
	private double totalPoints;  

	public Points(long custId, double firstPoints, double secondPoints, double thirdPoints, double totalPoints) {
		super();
		this.custId = custId;
		this.firstPoints = firstPoints;
		this.secondPoints = secondPoints;
		this.thirdPoints = thirdPoints;
		this.totalPoints = totalPoints;
	}


	public long getCustomerId() {
		return custId;
	}


	public void setCustomerId(long custId) {
		this.custId = custId;
	}


	public double getFirstPoints() {
		return firstPoints;
	}


	public void setFirstPoints(double firstPoints) {
		this.firstPoints = firstPoints;
	}


	public double getSecondPoints() {
		return secondPoints;
	}


	public void setSecondPoints(double secondPoints) {
		this.secondPoints = secondPoints;
	}


	public double getThirdPoints() {
		return thirdPoints;
	}


	public void setThirdPoints(double thirdPoints) {
		this.thirdPoints = thirdPoints;
	}


	public double getTotalPoints() {
		return totalPoints;
	}


	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}

	@Override
	public String toString() {
		return "Points [custId=" + custId + ", firstPoints=" + firstPoints + ", secondPoints=" + secondPoints
				+ ", thirdPoints=" + thirdPoints + ", totalPoints=" + totalPoints + "]";
	}
}
