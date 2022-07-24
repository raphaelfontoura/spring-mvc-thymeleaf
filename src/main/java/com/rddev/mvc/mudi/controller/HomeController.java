package com.rddev.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
  
  @Autowired
  private PedidoRepository repository;

  @GetMapping("/home")
  public ModelAndView home() {

    List<Pedido> pedidos = repository.findAll();
    ModelAndView modelAndView = new ModelAndView("home");

    modelAndView.addObject("pedidos", pedidos);

    return modelAndView;
  }
}
