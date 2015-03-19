package com.quitevis.multiplayermaze.client;

import com.quitevis.multiplayermaze.client.infra.network.Client;

/**
 * Client entry point
 * 
 * @author jim.quitevis
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.run();
    }
}
