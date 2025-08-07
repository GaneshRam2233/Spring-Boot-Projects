package edu.jsp.Banking.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long uid;
	private String name;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	Set<Loan> loans;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Account> accounts;

	public void addAccount(Account account) {
		accounts.add(account);
		account.setUser(this);
	}
	public void removeAccount(Account account) {
		accounts.remove(account);
		account.setUser(null);
	}

	public void addLoan(Loan l) {
		loans.add(l);
		l.setUser(this);
	}
	public void removeLoan(Loan l) {
		loans.remove(l);
		l.setUser(null);
	}
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Loan> getLoans() {
		return loans;
	}
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
}
