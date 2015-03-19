package com.quitevis.multiplayermaze.server.infra.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Code to start the socket (TCP/IP) server and bind clients to channels (handlers)
 * Each connected client will have its own ClientMessageHandler instance 
 * 
 * @author jim.quitevis
 *
 */
@Slf4j
public class MazeServer {
    private final int port;
    
    public MazeServer(int port) {
        this.port = port;
    }
    
    public void run() throws Exception {
        //Requests for connection goes here
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        
        //Requests for message handling goes here
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        log.info("Starting mazeserver");
        
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .childHandler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 public void initChannel(SocketChannel ch) throws Exception {
                     //Add our message handler to the pipeline
                     ch.pipeline().addLast(new ClientMesageHandler());
                 }
             })
             .option(ChannelOption.SO_BACKLOG, 128)     
             .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync();

            log.info("Mazeserver started. Listening to port: {}", port);
            
            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
