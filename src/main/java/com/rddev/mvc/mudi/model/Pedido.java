package com.rddev.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Oferta> ofertas;

}
