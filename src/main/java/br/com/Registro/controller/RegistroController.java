package br.com.Registro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.Registro.entity.Registro;
import br.com.Registro.entity.RespostaModel;
import br.com.Registro.service.RegistroServic;


@Controller
public class RegistroController { // HTML
	
	@Autowired(required = true)
	private RegistroServic rs; 
	
	
	@GetMapping("/")
	public String login(Model model) {
		Registro regis=new Registro();
		model.addAttribute("regis", regis);
		return "login";
	}

	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("regis") Registro regis, Model model) {
		ResponseEntity<?> response = rs.loginUser(regis);
		
		if(response.getStatusCode().is2xxSuccessful()) {
		RespostaModel resposta = (RespostaModel) response.getBody();
		model.addAttribute("mensagem", resposta.getMensagem());
		return "home";
	} else {
		RespostaModel resposta = (RespostaModel) response.getBody();
		model.addAttribute("mensagem", resposta.getMensagem());
		return "error";
		
	}

	}
}
