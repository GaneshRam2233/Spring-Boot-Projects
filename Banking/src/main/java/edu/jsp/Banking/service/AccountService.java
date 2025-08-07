package edu.jsp.Banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking.Entity.Account;
import edu.jsp.Banking.Entity.User;
import edu.jsp.Banking.Repository.AccountRepository;
import edu.jsp.Banking.Repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountRepository accountRepository;

	public String createAccount(long userId, Account account) {
		User u = userRepository.findById(userId).orElse(null);
		if (u != null) {
			u.addAccount(account);
			userRepository.save(u);
			return "Account Saved";
		}
		return "User not Found";
	}
	
	public Account getAccountById(long accountId) {
		Account a = accountRepository.findById(accountId).orElse(null);
		if(a!=null) {
			return a;
		}
		return null;
	}
	
	public String updateAccount(long accountId,Account newAccount) {
		Account a = accountRepository.findById(accountId).orElse(null);
		if(a!=null) {
			newAccount.setAccountId(accountId);
			newAccount.setUser(a.getUser());
			accountRepository.save(newAccount);
			return "Account Updated";
		}
		return "Account not Found";
	}
	
	public String deleteAccountById(long userId,long accountId) {
		User u = userRepository.findById(userId).orElse(null);
		if(u!=null) {
			Account a = accountRepository.findById(accountId).orElse(null);
			if(a!=null) {
				u.removeAccount(null);
				accountRepository.deleteById(accountId);
				return "Account Deleted";
			}
			return "Account not Found";
		}
		return "User not Found";
	}
	
	public double getAccountBalance(long accountId) {
		Account a = accountRepository.findById(accountId).orElse(null);
		if(a!=null) {
			return a.getAccountBalance();
		}
		return 0.0;
	}
	
	public List<Account> fetchAccountByUserUid(long userId) {
		return accountRepository.findByUserUid(userId);
	}
}
