package br.com.m2msolutions.copiloto.led

import br.com.m2msolutions.copiloto.led.helper.DespachanteDeComando
import br.com.m2msolutions.copiloto.led.helper.DespachanteDeComandoFactory
import br.com.m2msolutions.copiloto.led.modelo.ComandoRequest
import br.com.m2msolutions.copiloto.led.modelo.Status
import br.com.m2msolutions.copiloto.led.modelo.StatusResolver
import br.com.m2msolutions.copiloto.led.modelo.modulo.Modelo
import br.com.m2msolutions.copiloto.led.modelo.modulo.Modulo
import groovy.transform.CompileStatic

@CompileStatic
class CopilotoLed {

    String host
    Integer porta

    private StatusResolver statusResolver = new StatusResolver()
    private DespachanteDeComando despachante

    Status obterStatus(Integer minutos){
        statusResolver.resolveStatus minutos
    }

    void enviarComando(Integer clienteId, Integer veiculoId, String modeloDoModulo, String moduloId, Integer minutos,
                                Integer duracaoDaIluminacao = 1, Boolean openOrCloseTrip = false){

        def status = obterStatus minutos
        status.duracao = duracaoDaIluminacao

        def modulo = obterModulo modeloDoModulo
        def comandos = modulo.montarComandos moduloId, status, openOrCloseTrip

        despachante = DespachanteDeComandoFactory.obterDespachante host, porta

        despachante.despachar clienteId, veiculoId, comandos
    }

    private Modulo obterModulo(String modeloDoModulo){
        Modelo modelo = modeloDoModulo.toUpperCase() as Modelo
        modelo.obterModulo()
    }
}
