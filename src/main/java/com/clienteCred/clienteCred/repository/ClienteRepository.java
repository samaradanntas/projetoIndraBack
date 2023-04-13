package com.clienteCred.clienteCred.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.clienteCred.clienteCred.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	Page<Cliente> findAll(Pageable pageable);

}
