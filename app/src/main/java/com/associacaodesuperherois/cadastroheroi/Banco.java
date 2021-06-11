package com.associacaodesuperherois.cadastroheroi;

import java.io.Serializable;

public class Banco implements Serializable {
    private static String banco = "db_herois.db";
    private static String tabela = "herois";

    public static String banco(){
        return banco;
    }

    public static String tabela(){
        return tabela;
    }

    public static String criarTabela(){
        return "CREATE TABLE IF NOT EXISTS " + tabela() + "(\n" +
                "id  integer PRIMARY KEY AUTOINCREMENT," +
                "nomereal varchar NOT NULL, " +
                "nomeheroi varchar NOT NULL, " +
                "idade varchar NOT NULL, " +
                "cpf varchar NOT NULL, " +
                "habilidade varchar NOT NULL, " +
                "descricao varchar NOT NULL" +
                ");";
    }
}
