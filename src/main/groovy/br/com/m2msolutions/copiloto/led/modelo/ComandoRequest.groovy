package br.com.m2msolutions.copiloto.led.modelo

class ComandoRequest implements Serializable {

    Status status
    String modeloDoModulo
    Integer minutos
    Integer clienteId
    Integer veiculoId
    String moduloId
    Boolean openOrCloseTrip

    @Override
    boolean equals(ComandoRequest request) {
        request?.status == status && request?.veiculoId == veiculoId
    }
}
