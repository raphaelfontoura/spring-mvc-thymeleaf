package com.rddev.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.model.StatusPedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
  
  @Autowired
  private PedidoRepository repository;

  @GetMapping()
  public ModelAndView home() {

    List<Pedido> pedidos = repository.findAll();
    ModelAndView modelAndView = new ModelAndView("home");

    modelAndView.addObject("pedidos", pedidos);

    return modelAndView;
  }

  @GetMapping("/aguardando")
  public String aguardando(Model model) {

    List<Pedido> pedidos = repository.findByStatus(StatusPedido.AGUARDANDO);

    model.addAttribute("pedidos", pedidos);

    return "home";
  }
}
