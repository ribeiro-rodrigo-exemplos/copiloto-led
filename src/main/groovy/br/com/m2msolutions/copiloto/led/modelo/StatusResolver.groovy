package br.com.m2msolutions.copiloto.led.modelo

/**
 * Created by rodrigo on 04/12/17.
 */
class StatusResolver {

    private todosOsStatus = []

    Status resolveStatus(Integer minutos){
        if(!todosOsStatus)
            criarStatus()

        todosOsStatus.find{
            it.range.contains minutos
        }
    }

    private criarStatus(){

        todosOsStatus = [
                new Status(range: (Integer.MIN_VALUE..<-3),codigo: 'fff80000'),
                new Status(range: [-2],codigo: '00f80000'),
                new Status(range: [-3],codigo: '0ff80000'),
                new Status(range: (-1..1),codigo: '00060000'),
                new Status(range: [2],codigo: '0001f000'),
                new Status(range: [3],codigo: '0001ff00'),
                new Status(range: (4 .. Integer.MAX_VALUE),codigo: '0001fff8')
        ]
    }
}
