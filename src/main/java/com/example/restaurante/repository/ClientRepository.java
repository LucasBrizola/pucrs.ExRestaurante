package com.example.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.restaurante.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query("SELECT COUNT(1) AS existe FROM Client c WHERE c.cpf = :cpf")
	public Long validateExistClientByCpf(@Param("cpf") String cpf);

	@Query("SELECT c FROM Client c WHERE c.cpf = :cpf")
	public Optional<Client> findByCpf(@Param("cpf") String cpf);
}
