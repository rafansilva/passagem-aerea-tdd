package com.algaworks.service;

import com.algaworks.model.Passageiro;
import com.algaworks.model.TipoPassageiro;
import com.algaworks.model.Voo;

import java.util.Objects;

public class PrecoPassagemService {

    public double calcular(Passageiro passageiro, Voo voo) {
        Objects.requireNonNull(passageiro, "passageiro não pode ser nulo");
        Objects.requireNonNull(voo, "voo não pode ser nulo");

        TipoPassageiro tipoPassageiro = Objects.requireNonNull(
                passageiro.getTipo(), "tipo do passageiro não pode ser nulo");

       return tipoPassageiro.getCalculadora().calcular(voo);
    }
}
