package dev.andreyrsy.mspedidos.repository;

import dev.andreyrsy.mspedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
