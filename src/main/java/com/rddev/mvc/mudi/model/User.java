package com.rddev.mvc.mudi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data @ToString(exclude = "pedidos")
public class User {
  
  @Id
  private String username;
  private String password;
  private Boolean enabled;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
  @JsonManagedReference
  private final List<Pedido> pedidos = new ArrayList<>();

}
