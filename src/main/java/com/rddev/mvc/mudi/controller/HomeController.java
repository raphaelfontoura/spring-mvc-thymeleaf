package com.rddev.mvc.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rddev.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
  
  @PersistenceContext
  private EntityManager entityManager;
  private Query query;

  @GetMapping("/home")
  public String home(Model model) {

    Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
    List<Pedido> pedidos = query.getResultList();

    model.addAttribute("pedidos", pedidos);

    return "home";
  }
}
