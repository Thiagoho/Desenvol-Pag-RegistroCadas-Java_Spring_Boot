package br.com.Registro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import br.com.Registro.entity.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, String> {

	Optional<Registro> findByUserId(String userId);



}
