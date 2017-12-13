package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.kernel.dominio.xml.Parameter
import br.com.m2msolutions.copiloto.led.modelo.Status
import groovy.transform.CompileStatic

@CompileStatic
class Virloc10 implements Modulo {

    @Override
    List<ComandosMessage> montarComandos(String idModulo, Status status, Boolean openOrCloseTrip) {
        def comando = criarComando idModulo
        comando.parameters << new Parameter(null, null) << new Parameter(null, status?.codigo)

        [comando]
    }
}
