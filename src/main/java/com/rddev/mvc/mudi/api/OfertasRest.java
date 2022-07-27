package com.rddev.mvc.mudi.api;

import com.rddev.mvc.mudi.dto.RequisicaoNovaOferta;
import com.rddev.mvc.mudi.model.Oferta;
import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
@RequiredArgsConstructor
public class OfertasRest {

    private final PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<Oferta> criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicaoNovaOferta){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(requisicaoNovaOferta.getPedidoId());
        if (! pedidoOptional.isPresent()) return null;
        Pedido pedido = pedidoOptional.get();

        Oferta oferta = requisicaoNovaOferta.toOferta();
        oferta.setPedido(pedido);

        pedido.getOfertas().add(oferta);
        pedidoRepository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(oferta);
    }
}
