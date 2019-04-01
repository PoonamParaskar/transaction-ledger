package com.blockchain.transactionledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blockchain.transactionledger.service.Blockchain;

@SpringBootApplication
public class TransactionLedgerApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionLedgerApplication.class, args);
		Blockchain.main(null);
	}

}
