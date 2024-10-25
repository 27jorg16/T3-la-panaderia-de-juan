package edu.pe.cibertec.t3_panaderia_juan.repository;

import edu.pe.cibertec.t3_panaderia_juan.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}