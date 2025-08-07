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

import edu.jsp.Banking.Entity.User;
import edu.jsp.Banking.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/getUserById")
	public User getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping(value = "/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping(value = "/updateUser/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User newUser) {
		return userService.updateUser(id, newUser);
	}
	
	@DeleteMapping(value = "/deleteUserById/{id}")
	public String deleteUserById(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
	@GetMapping(value = "/searchUserByName")
	public List<User> searchUserByName(@RequestParam String name){
		return userService.searchUserByName(name);
	}
}
