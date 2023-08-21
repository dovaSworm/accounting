/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.User;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dova
 */
public class UserServiceInplTest {
	
	public UserServiceInplTest() {
	}
	
	@BeforeAll
	public static void setUpClass() {
	}
	
	@AfterAll
	public static void tearDownClass() {
	}
	
	@BeforeEach
	public void setUp() {
	}
	
	@AfterEach
	public void tearDown() {
	}

	/**
	 * Test of saveUser method, of class UserServiceImpl.
	 */
	@Test
	public void testSaveUser() {
		System.out.println("saveUser");
		User user = null;
		UserServiceImpl instance = new UserServiceImpl();
		User expResult = null;
		User result = instance.saveUser(user);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUsers method, of class UserServiceImpl.
	 */
	@Test
	public void testGetUsers() {
		System.out.println("getUsers");
		UserServiceImpl instance = new UserServiceImpl();
		List<User> expResult = null;
		List<User> result = instance.getUsers();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of updateUser method, of class UserServiceImpl.
	 */
	@Test
	public void testUpdateUser() {
		System.out.println("updateUser");
		User user = null;
		Long id = null;
		UserServiceImpl instance = new UserServiceImpl();
		User expResult = null;
		User result = instance.updateUser(user, id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteUser method, of class UserServiceImpl.
	 */
	@Test
	public void testDeleteUser() {
		System.out.println("deleteUser");
		Long id = null;
		UserServiceImpl instance = new UserServiceImpl();
		instance.deleteUser(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
