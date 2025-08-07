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

import edu.jsp.Banking.Entity.Loan;
import edu.jsp.Banking.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("applyForLoan")
	public String applyForLoan(@RequestParam long userId,@RequestBody Loan l) {
		return loanService.applyForLoan(userId, l);
	}
	
	@DeleteMapping("deleteLoan/{userId}/{loanId}")
	public String deleteLoan(@PathVariable long userId,@PathVariable long loanId) {
		return loanService.deleteLoan(userId, loanId);
	}
	
	@GetMapping(value = "/getLoanById")
	public Loan getLoanById(@RequestParam long loanId) {
		return loanService.getLoanById(loanId);
	}
	
	@PutMapping("updateLoanById/{loanId}")
	public String updateLoanById(@PathVariable long loanId,@RequestBody Loan newLoan) {
		return loanService.updateLoanById(loanId, newLoan);
	}
	
	@GetMapping("/getLoansByUserId")
	public List<Loan> getLoansByUserId(@RequestParam long userId){
		return loanService.getLoansByUserId(userId);
	}
	
	@GetMapping("/getLoanStatus")
	public String getLoanStatus(@RequestParam long loanId) {
		return loanService.getLoanStatus(loanId);
	}
	
	@GetMapping("/loanRepay")
	public String loanRepay(@RequestParam long loanId,@RequestParam double amount) {
		return loanService.repayLoan(loanId, amount);
	}
	
}
