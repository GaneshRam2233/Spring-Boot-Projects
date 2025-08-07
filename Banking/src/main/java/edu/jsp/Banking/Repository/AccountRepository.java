package edu.jsp.Banking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Banking.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	// using 
	List<Account> findByUserUid(long userId);
	
	// using Query
}
