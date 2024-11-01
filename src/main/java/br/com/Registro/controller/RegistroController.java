package br.com.Registro.controller;

import java.util.Optional;

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
	
	@Autowired(required = true)
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
		Optional<Registro> userdata =rer.findById(userId);
		
		if(regis.getPassword().equals(userdata.get().getPassword())) {
			return "home";
		}else
			return "error";
	}

}
