//package tn.esprit.spring.Service;
//
//
//
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import tn.esprit.spring.entities.Role;
//import tn.esprit.spring.entities.User;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserServiceImplTest {
//
//	@Autowired
//	IUserService userService;
//	
//	@Test
//	public void testAddUser(){
//		List<User> users = userService.retrieveAllUsers();
//		int expected=users.size();
//		User u = new User();
//		u.setEmail("test@");
//		u.setFName("test fname");
//		u.setLName("test lname");
//		u.setPwd("mdp");
//		u.setRole(Role.DEVELOPER);
//		User savedUser = userService.addUser(u);
//		assertEquals(expected+1, userService.retrieveAllUsers().size());
// 
//			}
//
//}
