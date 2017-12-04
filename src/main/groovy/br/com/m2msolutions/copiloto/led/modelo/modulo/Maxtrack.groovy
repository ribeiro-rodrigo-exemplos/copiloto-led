package br.com.m2msolutions.copiloto.led.modelo.modulo

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2m.frota.kernel.dominio.xml.Parameter
import br.com.m2msolutions.copiloto.led.modelo.Status

/**
 * Created by rodrigo on 04/12/17.
 */
class Maxtrack{

    ComandosMessage montarComandos(Integer id, Status status) {
        def comando = criarComando id
        comando.parameters << new Parameter(null,null) << new Parameter(null,'')
        comando
    }
}
