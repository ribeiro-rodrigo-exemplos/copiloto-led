package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.kernel.dominio.xml.Parameter
import br.com.m2m.frota.util.Const
import br.com.m2msolutions.copiloto.led.modelo.Status
import groovy.transform.CompileStatic

@CompileStatic
class Mxt700 implements Modulo {

    @Override
    List<ComandosMessage> montarComandos(String idModulo, Status status, Boolean openOrCloseTrip) {
        def comando = criarComando idModulo, Const.TYPE_68
        comando.parameters << new Parameter(Const.DESTINATION, Const.CINCO_MIL)
        comando.parameters << new Parameter(Const.TRANSPARENT_OPEN_DATA_HEX, status?.codigo)

        [comando]
    }
}
