package edu.jsp.Banking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking.Entity.Account;
import edu.jsp.Banking.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam long userId,@RequestBody Account account) {
		return accountService.createAccount(userId, account);
	}
	
	@GetMapping("getAccountById")
	public Account getAccountById(@RequestParam long accountId) {
		return accountService.getAccountById(accountId);
	}
	
	@PutMapping("updateAccount")
	public String updateAccount(@RequestParam long userId,@RequestBody Account newAccount) {
		return accountService.updateAccount(userId, newAccount);
	}
	
	@DeleteMapping("deleteAccountById")
	public String deleteAccountById(@RequestParam long userId,@RequestParam long accountId) {
		return accountService.deleteAccountById(userId, accountId);
	}
	
	@GetMapping("getAccountBalance/{accountId}")
	public double getAccountBalance(@PathVariable long accountId) {
		return accountService.getAccountBalance(accountId);
	}
	
	@GetMapping("fetchAccountByUserUid")
	public List<Account> fetchAccountByUserUid(@RequestParam long userId){
		return accountService.fetchAccountByUserUid(userId);
	}
}
