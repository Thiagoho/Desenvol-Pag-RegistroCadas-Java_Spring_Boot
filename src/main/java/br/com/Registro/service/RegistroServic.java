package br.com.Registro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.Registro.entity.Registro;
import br.com.Registro.entity.RespostaModel;
import br.com.Registro.repository.RegistroRepository;

@Service
public class RegistroServic {
	
	@Autowired
	private RegistroRepository rer;
	
	@Autowired
	private RespostaModel rm;
	
	//Método de verificar de Login
	public ResponseEntity<?> loginUser(Registro regis) {
		Optional<Registro> userdata = rer.findById(regis.getUserId());
		if(userdata.isPresent()) {
			if(regis.getPassword().equals(userdata.get().getPassword())) {
				rm.setMensagem("Parábens por ter feito o login com sucesso!");
				return new ResponseEntity<RespostaModel>(rm, HttpStatus.OK);
			}
			else {
				rm.setMensagem("Por favor, corrija o NomeId e a senha!");
				return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
			}
		}else {
				rm.setMensagem("Usuário não encontrado!");
				return new ResponseEntity<RespostaModel>(rm, HttpStatus.NOT_FOUND);
			
		}
	}
}
