package com.quitevis.multiplayermaze.server.infra.network.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import com.quitevis.mazeserver.api.generated.MazeServerApi;
import com.quitevis.mazeserver.api.generated.MazeServerApi.SessionId;

@Slf4j
public class SessionIdMessageHandler extends SimpleChannelInboundHandler<MazeServerApi.SessionId> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SessionId msg) throws Exception {
        log.info(msg.getSessionId());
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("An error has occured when handling SessionId message ({})", 
                ctx.channel().remoteAddress().toString(), cause);
    }
}
