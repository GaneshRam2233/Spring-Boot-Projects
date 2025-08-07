package edu.jsp.Banking.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.Banking.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "select t from Transaction t where t.account.user.uid = ?1 order by t.date")
	List<Transaction> getAllTransactionByUserId(long userId);
	
	@Query(value = "select t from Transaction t where t.account.user.uid = ?1 and t.date between ?2 and ?3")
	List<Transaction> getUserTransactionsWithDateRange(long userId,LocalDateTime start,LocalDateTime end);
	
	@Query(value = "select t from Transaction t where t.account.user.uid = ?1 and t.amount between ?2 and ?3")
	List<Transaction> getUserTransactionsWithAmountRange(long userId,double start,double end);
}
