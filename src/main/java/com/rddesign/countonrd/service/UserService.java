package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.User;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface UserService {

	User saveUser(User user);

	List<User> getUsers();

	User updateUser(User user, Long id);

	void deleteUser(Long id);
}
