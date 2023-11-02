package com.demo.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rewards.model.Points;
import com.demo.rewards.service.RewardsService;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

	@Autowired
	private RewardsService rewardsService;

	/*
	 * Get method to retrive the points for the given customer. 
	 * input - custId
	 * output - Points for the last 3 months
	 * */
	@GetMapping(value = "/customers/{custId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPointsByCustId(@PathVariable("custId") Long custId){
		Points points = rewardsService.getPointsByCustId(custId);
		if(points==null)
			return new ResponseEntity<>("No Transaction found for given id",HttpStatus.OK);

		return new ResponseEntity<>(points,HttpStatus.OK);
	}
}
