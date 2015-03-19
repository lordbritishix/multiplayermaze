package com.quitevis.multiplayermaze.server.infra.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles incoming messages from the client
 * 
 * @author jim.quitevis
 *
 */
@Slf4j
public class ClientMesageHandler extends ChannelInboundHandlerAdapter {
    public ClientMesageHandler() {
    }
    
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("Client connected: {}", ctx.channel().remoteAddress().toString());
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;

        //Read message from client
        log.info("Message from client ({}): {}",
            ctx.channel().remoteAddress().toString(), 
            in.toString(CharsetUtil.US_ASCII));
        
        //Respond back to client
        //ctx.writeAndFlush(200);
        
        //Release message
        in.release();
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) 
            throws Exception {
        log.error("An error has occured ({})", 
                ctx.channel().remoteAddress().toString(), cause);
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("Client disconnected: {}", 
                ctx.channel().remoteAddress().toString());
    }
}
