package br.com.m2msolutions.copiloto.led

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2msolutions.copiloto.led.infra.ComandoConverter
import br.com.m2msolutions.copiloto.led.infra.DespachanteDeComando
import br.com.m2msolutions.copiloto.led.modelo.Status
import br.com.m2msolutions.copiloto.led.modelo.StatusResolver
import br.com.m2msolutions.copiloto.led.modelo.modulo.Modulo
import br.com.m2msolutions.copiloto.led.modelo.modulo.Mtc500

class Main {
    static void main(String[] args){

        StatusResolver resolver = new StatusResolver()
        Status status = resolver.resolveStatus(-4)

        Modulo modulo = new Mtc500()
        ComandosMessage comando = modulo.montarComandos('idmodulo',status)

        def converter = new ComandoConverter(comando:comando)

        def despachante = new DespachanteDeComando()
        despachante.despachar(209,14,comando)
        despachante.despachar(300,15,comando)

        println converter.toJson()

    }
}
