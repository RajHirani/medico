package com.hd.medico.rest.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginResourceController {
	
	@GetMapping("/login")
	String doLoading(){
		return "You Are successfully Login";
	}
}
