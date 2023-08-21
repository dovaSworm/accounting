package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.User;
import com.rddesign.countonrd.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User updateUser(User user, Long id) {
		User userDb = (User) userRepo.findById(id).get();
		if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
			userDb.setEmail(user.getEmail());
		}
		if(Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
			userDb.setName(user.getName());
		}
		if(Objects.nonNull(user.getPass()) && !"".equalsIgnoreCase(user.getPass())) {
			userDb.setPass(user.getPass());
		}
		if(Objects.nonNull(user.getRole()) && !"".equalsIgnoreCase(user.getRole())) {
			userDb.setRole(user.getRole());
		}
		return userRepo.save(userDb);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
