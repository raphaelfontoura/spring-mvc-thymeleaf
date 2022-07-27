package com.rddev.mvc.mudi.dto;

import com.rddev.mvc.mudi.model.Oferta;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RequisicaoNovaOferta {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;
    private String valor;
    private String dataEntrega;
    private String comentario;

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatter));

        oferta.setValor(new BigDecimal(valor));

        return oferta;
    }
}
