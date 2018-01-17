package br.com.m2msolutions.copiloto.led

import br.com.m2msolutions.copiloto.led.helper.DespachanteDeComando
import br.com.m2msolutions.copiloto.led.helper.DespachanteDeComandoFactory
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

    void enviarComando(Integer clienteId, Integer veiculoId, String modeloDoModulo, String moduloId,Integer minutos,
                       Integer tempo = 1, Boolean openOrCloseTrip = false){

        def modulo = obterModulo modeloDoModulo
        def status = statusResolver.resolveStatus minutos

        status.duracao = tempo

        def comandos = modulo.montarComandos moduloId, status, openOrCloseTrip

        despachante = DespachanteDeComandoFactory.obterDespachante host, porta

        despachante.despachar clienteId, veiculoId, comandos
    }

    private Modulo obterModulo(String modeloDoModulo){
        Modelo modelo = modeloDoModulo.toUpperCase() as Modelo
        modelo.obterModulo()
    }
}
