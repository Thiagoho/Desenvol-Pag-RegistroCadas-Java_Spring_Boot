package br.com.Registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.Registro.entity.Registro;
import br.com.Registro.repository.RegistroRepository;

@Controller
public class RegistroController { // HTML
	
	@Autowired
	private RegistroRepository rer; 
	
	
	@GetMapping("/")
	public String login(Model model) {
		Registro regis=new Registro();
		model.addAttribute("regis", regis);
		return "login";
	}
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("regis") Registro regis) {		
		String userId=regis.getUserId();
		Registro userdata=rer.findbyUserId(userId);
		if(rer.getPassword().equals(userdata.getPassword())) {
			return "home";
		} else {
			return "error";
		}
		
	}

}
