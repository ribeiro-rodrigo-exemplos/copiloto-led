package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.enums.EnumComandos
import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2msolutions.copiloto.led.modelo.Status
import groovy.transform.CompileStatic


@CompileStatic
trait Modulo {

    abstract List<ComandosMessage> montarComandos(String idModulo, Status status,Boolean openOrCloseTrip)

    ComandosMessage criarComando(String idModulo,Integer tipo = null){
        def modelo = this.getClass().simpleName.toUpperCase()
        new ComandosMessage(modelo:modelo,comando: EnumComandos.COPILOTO_LED.id(), idModulo: idModulo, type: tipo,attempts: 14)
    }

}
