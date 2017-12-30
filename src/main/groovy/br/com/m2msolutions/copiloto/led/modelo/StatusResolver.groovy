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
            new Status(tempoMinimo: Double.NEGATIVE_INFINITY,tempoMaximo: -3.01, codigo: 'fff80000'),
            new Status(tempoMinimo: -2.0,tempoMaximo: -1.01, codigo: '00f80000'),
            new Status(tempoMinimo: -3.0,tempoMaximo: -2.01, codigo: '0ff80000'),
            new Status(tempoMinimo: -1.0,tempoMaximo: 1.0, codigo: '00060000'),
            new Status(tempoMinimo: 1.01,tempoMaximo: 2.0, codigo: '0001f000'),
            new Status(tempoMinimo: 2.01,tempoMaximo: 3.0, codigo: '0001ff00'),
            new Status(tempoMinimo: 3.01,tempoMaximo: Double.POSITIVE_INFINITY ,codigo: '0001fff8')
        ]
    }
}
