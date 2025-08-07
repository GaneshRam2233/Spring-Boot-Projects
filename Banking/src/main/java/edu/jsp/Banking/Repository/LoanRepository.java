package edu.jsp.Banking.Repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import edu.jsp.Banking.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
//	@Query("select l from Loan l where l.User.uid= :userId")
//	public List<Loan> getLoanByUserId(@Param("userId") long userId);
}
