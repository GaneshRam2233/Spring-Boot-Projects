package edu.jsp.Banking.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;

//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	private long accountNo;
	private double accountBalance;
//	 double tranferAmount;
//	String transferTo;
//	List<String> transactions;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
	private Set<Transaction> transaction;
	
	public void addTransaction(Transaction t) {
		transaction.add(t);
		t.setAccount(this);
	}
	public void removeTransaction(Transaction t) {
		transaction.remove(t);
		t.setAccount(null);
	}

	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
//	public double getTranferAmount() {
//		return tranferAmount;
//	}
//	public void setTranferAmount(double tranferAmount) {
//		this.tranferAmount = tranferAmount;
//	}
//	public String getTransferTo() {
//		return transferTo;
//	}
//	public void setTransferTo(String transferTo) {
//		this.transferTo = transferTo;
//	}
//	public List<String> getTransactions() {
//		return transactions;
//	}
//	public void setTransactions(List<String> transactions) {
//		this.transactions = transactions;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
