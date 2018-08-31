package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.kernel.dominio.xml.Parameter
import br.com.m2m.frota.util.Const
import br.com.m2msolutions.copiloto.led.modelo.Status
import groovy.transform.CompileStatic

@CompileStatic
class Mtc500 implements Modulo{

    @Override
    List<ComandosMessage> montarComandos(String idModulo, Status status,Boolean openOrCloseTrip) {

        def comandos = []

        if(openOrCloseTrip){

            def comando1 = criarComando idModulo, Const.TYPE_12
            comando1.parameters << new Parameter(Const.HEXA, Const.CINCO_MIL)
            comando1.parameters << new Parameter(Const.AUXOUTPUTDATA, Const.NOVE_ZEROS)

            comandos << comando1
        }

        def comando2 = criarComando idModulo, Const.TYPE_12

        comando2.parameters << new Parameter(Const.FORMAT,Const.HEXA) << new Parameter(Const.AUXOUTPUTDATA,status?.codigo)
        comandos << comando2

        comandos
    }
}
