package com.quitevis.multiplayermaze.tests;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import org.junit.rules.ExternalResource;

public class ClientTestResource extends ExternalResource {
    private EventLoopGroup workerGroup;
    private Channel channel;
    private final String host;
    private final int port;
    private final ChannelHandler handler;
    
    public ClientTestResource(String host, int port, ChannelHandler handler) {
        this.host = host;
        this.port = port;
        this.handler = handler;
    }
    
    @Override
    protected void before() throws Throwable {
        workerGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                ch.pipeline().addLast(new ProtobufEncoder());
                ch.pipeline().addLast(handler);
            }
        });
        
        channel = b.connect(host, port).sync().channel();
    }
    
    public void sendMessage(Object message) throws InterruptedException {
        channel.writeAndFlush(message).sync();
    }
    
    @Override
    protected void after() {
        workerGroup.shutdownGracefully();
    }
}
