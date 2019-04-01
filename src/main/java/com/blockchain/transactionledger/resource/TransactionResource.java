package com.blockchain.transactionledger.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.transactionledger.entity.Block;
import com.blockchain.transactionledger.service.Blockchain;

@RestController
public class TransactionResource {

	@Autowired
	Blockchain blockchain;
	
	@GetMapping
	public ArrayList<Block> allTransactions() {
		return blockchain.ledger;
	}

	@GetMapping("/{transactionId}")
	public void getTransactionById() {
		

	}

	@PostMapping
	public void addTransaction() {

	}
	
	@PutMapping
	public void updateTransaction() {
		
	}

}
