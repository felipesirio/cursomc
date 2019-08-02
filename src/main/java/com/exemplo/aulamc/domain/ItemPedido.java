package com.exemplo.aulamc.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ItemPedido implements Serializable {
    public static final long serialVersionUID = 1L;

    private Double desconto;
    private Integer quantidade;
    private Double preco;

}
