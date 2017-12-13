package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.kernel.dominio.xml.Parameter
import br.com.m2m.frota.util.Const
import br.com.m2msolutions.copiloto.led.modelo.Status
import groovy.transform.CompileStatic

@CompileStatic
class Mtc700 implements Modulo {

    @Override
    List<ComandosMessage> montarComandos(String idModulo, Status status,Boolean openOrCloseTrip) {

        def comandos = []

        if(openOrCloseTrip){
            def comando1 = criarComando idModulo, Const.TYPE_6
            comando1.parameters << new Parameter(Const.SET_DEFAULT_BAUD_RATE, Const.UM)
            comando1.parameters << new Parameter(Const.BAUD_RATE, Const.ZERO_UM)

            def comando2 = criarComando idModulo, Const.TYPE_68
            comando2.parameters << new Parameter(Const.DESTINATION, Const.CINCO_MIL)
            comando2.parameters << new Parameter(Const.TRANSPARENT_OPEN_DATA_HEX, Const.NOVE_ZEROS)

            comandos << comando1 << comando2
        }

        def comando = criarComando idModulo, Const.TYPE_68
        comando.parameters << new Parameter(Const.DESTINATION, Const.CINCO_MIL)
        comando.parameters << new Parameter(Const.TRANSPARENT_OPEN_DATA_HEX, status?.codigo)

        comandos << comando

        return comandos
    }
}
