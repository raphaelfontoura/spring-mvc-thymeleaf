package com.rddev.mvc.mudi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.rddev.mvc.mudi.model.Pedido;
import com.rddev.mvc.mudi.model.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoNovoPedido {
  
  @NotBlank // NotBlank.requisicaoNovoPedido.nomeProduto= não pode estar em branco.
  @Min(3)
  private String nomeProduto;
  @NotBlank
  private String urlProduto;
  @NotBlank
  private String urlImagem;
  private String descricao;

  public Pedido toPedido() {
    Pedido pedido = new Pedido();
    pedido.setNomeProduto(nomeProduto);
    pedido.setUrlProduto(urlProduto);
    pedido.setUrlImagem(urlImagem);
    pedido.setDescricao(descricao);
    pedido.setStatus(StatusPedido.AGUARDANDO);
    return pedido;
  }

}
