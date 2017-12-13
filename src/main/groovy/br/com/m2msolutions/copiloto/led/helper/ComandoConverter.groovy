package br.com.m2msolutions.copiloto.led.helper

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by rodrigo on 04/12/17.
 */
class ComandoConverter {

    ComandosMessage comando

    String toJson(){
        new ObjectMapper().writeValueAsString comando
    }
}
