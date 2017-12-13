package br.com.m2msolutions.copiloto.led.helper

import groovy.transform.CompileStatic

@CompileStatic
class DespachanteDeComandoFactory {

    private static DespachanteDeComando despachanteDeComando

    static DespachanteDeComando obterDespachante(String host,Integer porta){
        if(!despachanteDeComando)
            despachanteDeComando = new DespachanteDeComando(host: host,port: porta)

        despachanteDeComando
    }
}
