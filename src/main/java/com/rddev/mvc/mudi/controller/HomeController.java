package com.rddev.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
  public ModelAndView home(Principal principal) {

    Sort sort = Sort.by("dataEntrega").descending();
    Pageable page = PageRequest.of(0, 5, sort);

    List<Pedido> pedidos = repository.findByStatus(StatusPedido.ENTREGUE, page);
    ModelAndView modelAndView = new ModelAndView("home");

    modelAndView.addObject("pedidos", pedidos);

    return modelAndView;
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public String onError() {
    return "redirect:/home";
  }
}
