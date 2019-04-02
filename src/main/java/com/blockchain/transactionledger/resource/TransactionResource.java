package com.blockchain.transactionledger.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.transactionledger.entity.Block;
import com.blockchain.transactionledger.service.Blockchain;

@RestController
public class TransactionResource {

	@Autowired
	Blockchain blockchain;
	
	@GetMapping
	public ArrayList<Block> allTransactions() {
		return blockchain.getAllTransactions();
	}

	@GetMapping("/{transactionId}")
	public Block getTransactionById(@PathVariable Integer transactionId) {		
		return blockchain.getTransactionByTransactionId(transactionId);
	}

	@PostMapping
	public void addTransaction(@RequestBody Block block) {
		blockchain.addTransaction(block);
	}
	
	@PutMapping
	public void updateTransaction(@RequestBody Block block) {
		blockchain.updateTransaction(block);
	}
	
	@DeleteMapping("delete/{transactionId}")
	public void deleteTransaction(@PathVariable Integer transactionId) {
		blockchain.deleteTransaction(blockchain.getTransactionByTransactionId(transactionId));
	}

}
