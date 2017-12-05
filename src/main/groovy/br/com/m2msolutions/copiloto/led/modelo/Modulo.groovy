package br.com.m2msolutions.copiloto.led.modelo

import br.com.m2m.frota.kernel.dominio.enums.EnumComandos
import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import groovy.transform.CompileStatic
import groovy.transform.PackageScope

@PackageScope
@CompileStatic
trait Modulo {

    Integer id
    
    abstract List<ComandosMessage> montarComandos()

    ComandosMessage criarComando(Integer tipo){
        def modelo = this.getClass().simpleName.toUpperCase()
        new ComandosMessage(modelo:modelo,comando: EnumComandos.COPILOTO_LED.id(), idModulo: id, type: tipo)
    }

}
