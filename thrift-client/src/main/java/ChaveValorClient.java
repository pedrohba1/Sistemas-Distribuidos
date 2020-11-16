/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
package chavevalor;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ChaveValorClient {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 3000);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ChaveValor.Client client = new ChaveValor.Client(protocol);

            

            System.out.println(client.setKV(1, "chave 1"));
            System.out.println(client.setKV(3, "chave 2"));
            System.out.println(client.setKV(10, "chave 3"));



            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}