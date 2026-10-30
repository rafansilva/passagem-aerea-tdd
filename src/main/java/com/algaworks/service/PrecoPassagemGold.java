package com.algaworks.service;

import com.algaworks.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

    private static final double LIMITE_DESCONTO = 100.0;
    private static final double DESCONTO_ATE_LIMITE = 0.9;
    private static final double DESCONTO_ACIMA_LIMITE = 0.85;

    @Override
    public double calcular(Voo voo) {
        return voo.getPreco() * percentualDesconto(voo.getPreco());
    }

    private double percentualDesconto(double preco) {
        return preco <= LIMITE_DESCONTO
                ? DESCONTO_ATE_LIMITE
                : DESCONTO_ACIMA_LIMITE;
    }
}
