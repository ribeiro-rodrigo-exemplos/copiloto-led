package br.com.m2msolutions.copiloto.led.helper

import br.com.m2m.frota.kernel.dominio.mensagem.ComandosMessage
import br.com.m2msolutions.copiloto.led.CopilotoLedException
import groovy.transform.CompileStatic
import redis.clients.jedis.Jedis

@CompileStatic
class DespachanteDeComando {

    private String host
    private Integer port

    void despachar(Integer idCliente,Integer idVeiculo,List<ComandosMessage> comandos){
        def jedis = criarConexao()
        def chave = criarChave idCliente, idVeiculo

        comandos?.each {
            def comandoJson = converter it

            try{
                jedis.publish chave, comandoJson
            }catch (e){
                throw new CopilotoLedException(message: 'Não foi possível enviar o comando')
            }
        }

        jedis?.close()
    }

    private Jedis criarConexao(){
        new Jedis(host,port)
    }

    private String criarChave(Integer idCliente,Integer idVeiculo){
        "comandos:${idCliente}:${idVeiculo}"
    }

    private String converter(ComandosMessage comando){
        new ComandoConverter(comando:comando).toJson()
    }
}
