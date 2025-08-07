package edu.jsp.Banking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Banking.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByName(String name);
	
}
