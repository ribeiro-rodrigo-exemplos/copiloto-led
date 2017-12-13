package br.com.m2msolutions.copiloto.led.modelo.modulo

/**
 * Created by rodrigo on 12/12/17.
 */
enum Modelo {

    MAXTRACK(Maxtrack), MTC500(Mtc500), MTC550(Mtc550), MTC550FULL(Mtc550Full), MTC600(Mtc600), MTC700(Mtc700),
    MXT100(Mxt100), MXT101(Mxt101),MXT120(Mxt120), MXT140B(Mxt140b), MXT142(Mxt142), MXT150(Mxt150),
    MXT151(Mxt151), MXT700(Mxt700)

    private Class moduloClass

    Modelo(Class moduloClass){
        this.moduloClass = moduloClass
    }

    Modulo obterModulo(){
        moduloClass.newInstance()
    }
}
