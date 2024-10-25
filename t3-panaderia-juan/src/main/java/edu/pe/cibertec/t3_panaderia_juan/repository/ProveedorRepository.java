package edu.pe.cibertec.t3_panaderia_juan.repository;

import edu.pe.cibertec.t3_panaderia_juan.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}