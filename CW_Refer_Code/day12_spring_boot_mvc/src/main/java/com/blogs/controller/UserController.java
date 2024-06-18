package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.entities.User;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// depcy : user service i/f
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	// add a method to render the login form
	// http:host:port/spring_boot/user/login , method=GET
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form ");
		return "/user/login";// AVN - /WEB-INF/views/user/login.jsp
	}

	// add a method to process the login form
	// http://host:port/spring_boot/user/login , method=POST
	@PostMapping("/login")
	public String processLogin(@RequestParam String em, @RequestParam String pass, Model map, HttpSession session) {
		System.out.println("in process login " + em + " " + pass);
		// add user details
		try {
			User user = userService.signIn(em, pass);
			// store user details
			session.setAttribute("user_dtls", user);
			// forward the clnt to blogger's home page
			return "redirect:/blogger/home";
			/*
			 * SC(WC) sends Temp redirect resp to the clnt Next req --
			 * http://host:port/spring_boot/blogger/home
			 */
		} catch (RuntimeException e) {
			// add err mesg
			map.addAttribute("mesg", e.getMessage());
			// failure --forward the clnt to login
			return "/user/login";
		}

	}
	// add a method to handle logout link
	// http://host:port/spring_boot/user/logout , method=GET
	@GetMapping("/logout")
	public String userLogout(HttpSession session,Model map)
	{
		System.out.println("in logout ");
		//store user details as model attribute
		map.addAttribute("user_details",
				session.getAttribute("user_dtls"));
		//invalidate session
		session.invalidate();		
		return "/user/logout";
	}
}
