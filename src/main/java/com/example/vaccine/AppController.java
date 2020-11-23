package com.example.vaccine;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class AppController {

	@Autowired
	private OrganizationsRepository orgRepository;

	@Autowired
	private HttpSession httpSession;

	@PostMapping("/org/signup")
	public Organization signUp(@RequestBody Organization org) {
		return null;
	}

	@PostMapping("/org/signin")
	public Organization signIn(@RequestBody Organization org) {

		return null;
	}
}
