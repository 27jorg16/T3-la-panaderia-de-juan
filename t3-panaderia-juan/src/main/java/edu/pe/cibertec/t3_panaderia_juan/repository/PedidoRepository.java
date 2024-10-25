package edu.pe.cibertec.t3_panaderia_juan.repository;

import edu.pe.cibertec.t3_panaderia_juan.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}