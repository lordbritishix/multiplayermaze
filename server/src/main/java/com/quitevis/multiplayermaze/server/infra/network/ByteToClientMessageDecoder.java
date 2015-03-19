package com.quitevis.multiplayermaze.server.infra.network;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * Ensures the messages that the client sends us are complete before we hand
 * it over to the next channel
 * 
 * This handler has internally-maintained cummulative buffer
 *  
 * @author jim.quitevis
 *
 */
public class ByteToClientMessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) 
            throws Exception {
        
    }
}
