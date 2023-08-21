package com.rddesign.countonrd.repository;

import com.rddesign.countonrd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dova
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
