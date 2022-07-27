package com.rddev.mvc.mudi.api;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.model.StatusPedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
  
  @Autowired
  private PedidoRepository pedidoRepository;

  @GetMapping("/aguardando")
  public ResponseEntity<List<Pedido>> getPedidosAguardandoOfertas() {
    Pageable page = PageRequest.of(0, 10, Sort.by("id").descending());
    
    return ResponseEntity.ok(pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, page));
  }
}
