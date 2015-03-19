package com.quitevis.multiplayermaze.client.infra.network;

import lombok.extern.slf4j.Slf4j;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@Slf4j
public class ServerMessageHandler extends ChannelInboundHandlerAdapter {
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Client connected to: {}", ctx.channel().remoteAddress().toString());
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("Client disconnected from: {}", ctx.channel().remoteAddress().toString());
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            log.info("Client received message from sever ({}): {}",
                    ctx.channel().remoteAddress().toString(),
                    m.toString(CharsetUtil.US_ASCII));
        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
