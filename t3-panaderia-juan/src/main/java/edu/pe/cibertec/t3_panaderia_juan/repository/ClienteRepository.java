package edu.pe.cibertec.t3_panaderia_juan.repository;

import edu.pe.cibertec.t3_panaderia_juan.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}