package com.rddev.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rddev.mvc.mudi.dto.RequisicaoNovoPedido;
import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

  @Autowired
  private PedidoRepository pedidoRepository;

  @GetMapping("formulario")
  public String formulario(RequisicaoNovoPedido novoPedido) {
    return "pedido/formulario";
  }

  @PostMapping("novo")
  public String novo(@Valid RequisicaoNovoPedido novoPedido, BindingResult result) {
    if (result.hasErrors()) return "pedido/formulario";

    Pedido pedido = novoPedido.toPedido();
    pedidoRepository.save(pedido);

    return "redirect:/home";
  }
}
