package com.quitevis.multiplayermaze.server.infra.network.handlers;

import com.quitevis.mazeserver.api.generated.MazeServerProtocol.SessionId;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionIdMessageHandler extends SimpleChannelInboundHandler<SessionId> {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("An error has occured when handling SessionId message ({})",
                ctx.channel().remoteAddress().toString(), cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SessionId msg) throws Exception {
        log.trace("SessionId message received: {}", msg.toString());
    }
}
