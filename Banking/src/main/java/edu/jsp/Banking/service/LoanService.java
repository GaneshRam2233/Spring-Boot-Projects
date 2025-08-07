package edu.jsp.Banking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking.Entity.Loan;
import edu.jsp.Banking.Entity.User;
import edu.jsp.Banking.Repository.LoanRepository;
import edu.jsp.Banking.Repository.UserRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private UserRepository userRepository;

	public String applyForLoan(long userId, Loan l) {
		
		User u = userRepository.findById(userId).orElse(null);
		
		if (u != null) {
			u.addLoan(l);
			userRepository.save(u);
			return "Successfull";
		}
		return "Problem Occured";
	}
	
	public String deleteLoan(long userId,long loanId) {
		User u = userRepository.findById(userId).orElse(null);
		if(u!=null) {
			Loan l = loanRepository.findById(loanId).orElse(null);
			if(l!=null) {
				
				u.removeLoan(l);
				loanRepository.deleteById(loanId);
				return "Loan Deleted";
			}
			return "Loan details not found";
		}
		return "User not found";
	}
	
	public Loan getLoanById(long loanId) {
		return loanRepository.findById(loanId).orElse(null);
	}
	
	public String updateLoanById(long loanId,Loan newLoan) {
		Loan l = getLoanById(loanId);
		if(l!=null) {
			newLoan.setId(loanId);
			newLoan.setUser(l.getUser());
			loanRepository.save(newLoan);
			return "Data Updated"; 
		}
		return "Loan not Found";
	}
	
	public List<Loan> getLoansByUserId(long userId){
		User u = userRepository.findById(userId).orElse(null);
		if(u!=null) {
			return new ArrayList<>(u.getLoans());
		}
		return null;
	}
	
	public String getLoanStatus(long loanId) {
		Loan l = getLoanById(loanId);
		if(l!=null) {
			return l.getStatus();
		}
		return "Loan not found";
	}
	
	public String repayLoan(long loanId,double amount) {
		Loan l = loanRepository.findById(loanId).orElse(null);
		if(l!=null) {
			double balance = l.getAmount()-amount;
			l.setBalance(balance);
			loanRepository.save(l);
			return "Repay Successfull";
		}
		return "Not Successfull";
	}
}
