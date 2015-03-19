package com.quitevis.multiplayermaze.server;

import com.quitevis.multiplayermaze.server.infra.network.MazeServer;

/**
 * Server entry point
 * 
 * @author jim.quitevis
 *
 */
public class Main {
    public static final int DEFAULT_PORT = 10500;

    public static void main(String[] args) throws Exception {
        MazeServer server = new MazeServer(DEFAULT_PORT);
        
        //Start the server. This will block until the server exits
        server.run();
    }
}
