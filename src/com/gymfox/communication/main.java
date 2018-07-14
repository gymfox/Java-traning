package com.gymfox.communication;

//Поле испытаний.

public class main {
    public static void main(String[] args) throws Route.InvalidGatewayException {
        Network net1 = new Network(new IPv4Address("192.168.0.1"), 16);
        Network net2 = new Network(new IPv4Address("154.45.13.5"), 24);

        System.out.println(net1.toString());
        System.out.println(net2.toString());
    }
}
/*
для перевода IP из long -> String
((ipAsLong >> 24) & 0xff) + "." + ((ipAsLong >> 16) & 0xff) + "." + ((ipAsLong >> 8) & 0xff)  + "." + (ipAsLong & 0xff);
*/