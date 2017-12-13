package br.com.m2msolutions.copiloto.led.modelo

import groovy.transform.CompileStatic

import java.text.DecimalFormat

@CompileStatic
class Status {

    String codigo
    Integer duracao
    Double tempoMinimo
    Double tempoMaximo

    String getCodigo(){
        if(!duracao)
            return codigo

        "${codigo}${new DecimalFormat('00').format(duracao)}"
    }
}
