package com.rddev.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.model.StatusPedido;
import com.rddev.mvc.mudi.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioController {

  private final PedidoRepository repository;

  @GetMapping("pedido")
  public ModelAndView home(Principal principal) {

    List<Pedido> pedidos = repository.findAllByUserUsername(principal.getName());
    ModelAndView modelAndView = new ModelAndView("usuario/home");

    modelAndView.addObject("pedidos", pedidos);

    return modelAndView;
  }

  @GetMapping("pedido/{status}")
  public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {

    List<Pedido> pedidos = repository.findByStatusAndUserUsername(StatusPedido.valueOf(status.toUpperCase()), principal.getName());

    model.addAttribute("pedidos", pedidos);
    model.addAttribute("status", status);

    return "usuario/home";
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public String onError() {
    return "redirect:/usuario/home";
  }
}
