package com.atharva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atharva.model.Users;
import com.atharva.repository.UserRepository;
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<Users>getAllUsers(){
		
		return userRepository.findAll();//returns all the users
		
	}
	
	@GetMapping("/{userid}")
	public Users getUserById(@PathVariable Long userid) {
		return userRepository.findById(userid).orElse(null);
		
	}
    @PostMapping
    public Users createUsers(@RequestBody Users user) {
        return userRepository.save(user);
    }
	
    @PutMapping("/{userid}")
    public Users updateUser(@PathVariable Long userid, @RequestBody Users user) {
        if (userRepository.existsById(userid)) {
            user.setUserid(userid);
            return userRepository.save(user);
            
        }
        return null;
    }
    @DeleteMapping("/{userid}")
    public void deleteEmployee(@PathVariable Long userid) {
        userRepository.deleteById(userid);
    }

}
