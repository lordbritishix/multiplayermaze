package com.quitevis.multiplayermaze.tests;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
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
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(handler);
            }
        });
        
        channel = b.connect(host, port).sync().channel();
    }
    
    public void sendMessage(String message) throws InterruptedException {
        channel.writeAndFlush(Unpooled.copiedBuffer(message, CharsetUtil.US_ASCII)).sync();
    }
    
    @Override
    protected void after() {
        workerGroup.shutdownGracefully();
    }
}
