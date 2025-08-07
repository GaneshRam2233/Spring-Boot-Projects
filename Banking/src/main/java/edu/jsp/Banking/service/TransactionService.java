package edu.jsp.Banking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking.Entity.Account;
import edu.jsp.Banking.Entity.Transaction;
import edu.jsp.Banking.Repository.AccountRepository;
import edu.jsp.Banking.Repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public String addTransaction(long accountId,Transaction transaction) {
		Account a = accountRepository.findById(accountId).orElse(null);
		if(a!=null) {
			a.addTransaction(transaction);
			accountRepository.save(a);
			return "Transaction added SuccessFully";
		}
		return "Account not Found";
	}
	
	public List<Transaction> getAllTransactionByUserId(long userId){
		return transactionRepository.getAllTransactionByUserId(userId);
	}
	
	public List<Transaction> getUserTransactionsWithDateRange(long userId,LocalDateTime start,LocalDateTime end){
		return transactionRepository.getUserTransactionsWithDateRange(userId, start, end);
	}
	
	public List<Transaction> getUserTransactionsWithAmountRange(long userId,double start,double end){
		return transactionRepository.getUserTransactionsWithAmountRange(userId, start, end);
	}
	
}
