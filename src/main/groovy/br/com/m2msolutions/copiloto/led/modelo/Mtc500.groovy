package br.com.m2msolutions.copiloto.led.modelo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.util.Const

class Mtc500 implements Modulo {

    @Override
    List<ComandosMessage> montarComandos() {

        def comandos = criarComando(Const.TYPE_12)

        return null
    }
}
