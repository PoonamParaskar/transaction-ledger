package com.blockchain.transactionledger.service;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.transactionledger.entity.Block;
import com.blockchain.transactionledger.repository.TransactionRepository;

@Service
public class Blockchain {

    @Autowired
    private TransactionRepository repository;
    
    public static int difficulty = 4;
    static Logger logger = Logger.getLogger(Blockchain.class.getName());

    
    public ArrayList<Block> getAllTransactions() {
    	return repository.ledger;
	}
    
    public boolean addTransaction(Block block) {
    	block.previousHash=repository.ledger.get(repository.ledger.size()-1).hash;
    	repository.add(block);
    	repository.ledger.get(repository.ledger.size()-1).mineBlock(difficulty);
    	
    	return true;
    }
    
    public void updateTransaction(Block block) {
    	repository.update(block.transaction.transactionId,block);		
	}
    
    public void deleteTransaction(Block block) {
		repository.remove(block);
	}
    
    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:


        
		/*
		 * String blockchainJson = new
		 * GsonBuilder().setPrettyPrinting().create().toJson(ledger);
		 * logger.info("\nThe block chain: "); logger.info(blockchainJson);
		 */
        //second block is changed
//        secondBlock.transaction=new Transaction("Shubham","Poonam",120,"Rs 120 has been sent");
//        ledger.set(1, secondBlock);
//        ledger.get(1).mineBlock(difficulty);
//        logger.info("\nBlockchain is Valid: " + isChainValid());

		/* 
		 * String blockchainAfterJson = new
		 * GsonBuilder().setPrettyPrinting().create().toJson(ledger);
		 * logger.info("\nThe block chain: "); logger.info(blockchainJson);
		 */
    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for(int i=1; i < repository.ledger.size(); i++) {
            currentBlock = repository.ledger.get(i);
            previousBlock = repository.ledger.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                logger.info("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                logger.info("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                logger.info("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }

	public Block getTransactionByTransactionId(Integer transactionId) {
		return repository.getTransactionByTransactionId(transactionId);
	}

}