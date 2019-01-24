package com.gymfox.communication;

//Поле испытаний.

import java.util.TreeSet;

public class main {
     public static void main(String[] args) {
         TreeSet<Route> routes = new TreeSet<Route>(new Router.RouteComparator()) {{
             add(new Route(new Network(new IPv4Address("10.0.0.0"), 8),"en1", 10, new IPv4Address("10.123.0.1")));
             add(new Route(new Network(new IPv4Address("192.168.5.0"), 25), "en0", 10, new IPv4Address("10.123.0.0")));
             add(new Route(new Network(new IPv4Address("192.168.5.0"), 24), "en0", 5, new IPv4Address("192.168.2.1")));
             add(new Route(new Network(new IPv4Address("192.168.1.128"), 25),  "en0", 3));
             add(new Route(new Network(new IPv4Address("10.123.0.0"), 20),  "en1", 10));
         }};

         Router router = new Router(routes);
         System.out.println(router.getRouteForAddress(new IPv4Address("192.168.5.178")));

     }
}
/*
для перевода IP из long -> String
((ipAsLong >> 24) & 0xff) + "." + ((ipAsLong >> 16) & 0xff) + "." + ((ipAsLong >> 8) & 0xff)  + "." + (ipAsLong & 0xff);
*/