package com.quitevis.multiplayermaze.server.infra.network.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * Monitors client connection and deletion
 * 
 * @author jim.quitevis
 *
 */
@Slf4j
public class BaseMessageHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Client connected: {}", ctx.channel().remoteAddress().toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("An error has occured ({})", 
                ctx.channel().remoteAddress().toString(), cause);
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("Client disconnected: {}", 
                ctx.channel().remoteAddress().toString());
    }
}
