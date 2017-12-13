package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.kernel.dominio.xml.Parameter
import br.com.m2m.frota.util.Const
import br.com.m2msolutions.copiloto.led.modelo.Status
import groovy.transform.CompileStatic

@CompileStatic
class Mtc550 implements Modulo{

    List<ComandosMessage> montarComandos(String idModulo, Status status,Boolean openOrCloseTrip) {

        def comando = criarComando idModulo, Const.TYPE_12

        comando.parameters << new Parameter(Const.FORMAT,Const.HEXA) << new Parameter(Const.AUXOUTPUTDATA,status?.codigo)
        [comando]
    }
}
