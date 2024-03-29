package com.exemplo.aulamc.domain.enums;

public enum TipoCliente {
    PESSOA_FISICA(1, "PF"),
    PESSOA_JURIDICA(2, "PJ");

    private Integer cod;
    private String descricao;

    private TipoCliente(Integer cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(TipoCliente tc : TipoCliente.values()){
            if(cod.equals(tc.getCod())){
                return tc;
            }
        }

        throw new IllegalArgumentException("Cód. inválido: " + cod);
    }
}
