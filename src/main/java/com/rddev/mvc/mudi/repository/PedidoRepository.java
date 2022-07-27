package com.rddev.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

  List<Pedido> findByStatusAndUserUsername(StatusPedido status, String username);

  List<Pedido> findAllByUserUsername(String username);

  @Cacheable("pedidos")
  List<Pedido> findByStatus(StatusPedido entregue, Pageable pageable);
  
}
