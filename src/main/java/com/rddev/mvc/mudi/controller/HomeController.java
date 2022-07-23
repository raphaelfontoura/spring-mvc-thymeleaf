package com.rddev.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
  
  @Autowired
  private PedidoRepository repository;

  @GetMapping("/home")
  public String home(Model model) {

    List<Pedido> pedidos = repository.recuperaPedidos();

    model.addAttribute("pedidos", pedidos);

    return "home";
  }
}
