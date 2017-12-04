package br.com.m2msolutions.copiloto.led.infra

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import redis.clients.jedis.Jedis

/**
 * Created by rodrigo on 04/12/17.
 */
class DespachanteDeComando {

    void despachar(Integer idCliente,Integer idVeiculo,ComandosMessage comando){
        def jedis = criarConexao()
        def chave = criarChave idCliente, idVeiculo
        def comandoJson = converter comando
        jedis.set(chave,comandoJson)
        jedis.close()
    }

    private Jedis criarConexao(){
        new Jedis("localhost")
    }

    private String criarChave(Integer idCliente,Integer idVeiculo){
        "comandos:${idCliente}:${idVeiculo}"
    }

    private String converter(ComandosMessage comando){
        new ComandoConverter(comando:comando).toJson()
    }
}
