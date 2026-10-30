package com.algaworks.service;

import com.algaworks.model.Passageiro;
import com.algaworks.model.TipoPassageiro;
import com.algaworks.model.Voo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrecoPassagemServiceTest {

    private PrecoPassagemService precoPassagemService;

    @BeforeEach
    void setUp() {
        precoPassagemService = new PrecoPassagemService();
    }

    @Test
    void deveCalcularValorPassagemParaPassageiroGoldComValorAteOLimite() {
        assertEquals(90.0, calcular(TipoPassageiro.GOLD, 100.0), 0.01);
    }

    @Test
    void deveCalcularValorPassagemParaPassageiroGoldComValorAcimaDoLimite() {
        assertEquals(510.0, calcular(TipoPassageiro.GOLD, 600.0), 0.01);
    }

    @Test
    void deveCalcularValorPassagemParaPassageiroSilverComValorAteOLimite() {
        assertEquals(94.0, calcular(TipoPassageiro.SILVER, 100.0), 0.01);
    }

    @Test
    void deveCalcularValorPassagemParaPassageiroSilverComValorAcimaDoLimite() {
        assertEquals(720.0, calcular(TipoPassageiro.SILVER, 800.0), 0.01);
    }

    private double calcular(TipoPassageiro tipoPassageiro, double preco) {
        Passageiro passageiro = new Passageiro("João", tipoPassageiro);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", preco);

        return precoPassagemService.calcular(passageiro, voo);
    }
}
