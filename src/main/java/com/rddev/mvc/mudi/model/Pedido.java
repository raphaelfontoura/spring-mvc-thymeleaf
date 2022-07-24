package com.rddev.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nomeProduto;
  private BigDecimal valorNegociado;
  private LocalDate dataEntrega;
  private String urlProduto;
  private String urlImagem;
  @Column(columnDefinition = "TEXT")
  private String descricao;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

}
