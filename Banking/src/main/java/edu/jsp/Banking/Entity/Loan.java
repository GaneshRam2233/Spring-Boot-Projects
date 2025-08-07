package edu.jsp.Banking.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double amount;
	private LocalDateTime applyDate;
	private LocalDateTime approvalDate;
	private LocalDateTime disbursementDate;
	private double balance;
	private String status;
	// could be "Applied","Approved","Disbursed"
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference // prevents backtracking==> loan has user->user has loan->loan has user....
	private User user;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}
	public LocalDateTime getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(LocalDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}
	public LocalDateTime getDisbursementDate() {
		return disbursementDate;
	}
	public void setDisbursementDate(LocalDateTime disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
