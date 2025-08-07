package edu.jsp.Banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking.Entity.User;
import edu.jsp.Banking.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(int id,User newUser) {
		User u = getUserById(id);
		if(u!=null) {
			newUser.setUid(id);
			return userRepository.save(newUser);
		}
		return null;
	}
	
	public String deleteUserById(long id) {
		User u = getUserById(id);
		if(u!=null) {
			userRepository.deleteById(id);
			return "Data deleted";
		}
		return "id not found";
	}
	
	public List<User> searchUserByName(String name) {
		return userRepository.findByName(name);
	}
}
