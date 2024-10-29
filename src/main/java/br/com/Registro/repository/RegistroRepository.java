package br.com.Registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import br.com.Registro.entity.Registro;

//@Repository
public interface RegistroRepository extends JpaRepository<Registro, String> {

	Registro findByUserId(String userId);



}
