package br.com.m2msolutions.copiloto.led.modelo

class StatusResolver {

    private todosOsStatus = []

    Status resolveStatus(Double minutos){
        if(!todosOsStatus)
            criarStatus()

        todosOsStatus.find{
            Status status ->
                minutos >= status.tempoMinimo && minutos <= status.tempoMaximo
        }
    }

    private criarStatus(){

        todosOsStatus = [
            new Status(tempoMinimo: Double.MIN_VALUE,tempoMaximo: -3.1, codigo: 'fff80000'),
            new Status(tempoMinimo: -2.0,tempoMaximo: -1.1, codigo: '00f80000'),
            new Status(tempoMinimo: -3.0,tempoMaximo: -2.1, codigo: '0ff80000'),
            new Status(tempoMinimo: -1.0,tempoMaximo: 1.0, codigo: '00060000'),
            new Status(tempoMinimo: 1.1,tempoMaximo: 2.0, codigo: '0001f000'),
            new Status(tempoMinimo: 2.1,tempoMaximo: 3.0, codigo: '0001ff00'),
            new Status(tempoMinimo: 3.1,tempoMaximo: Double.MAX_VALUE ,codigo: '0001fff8')
        ]
    }
}
