package com.quitevis.multiplayermaze.server.infra.network.handlers;

import com.quitevis.mazeserver.api.generated.MazeServerProtocol;
import com.quitevis.mazeserver.api.generated.MazeServerProtocol.Maze;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MazeMessageHandler extends SimpleChannelInboundHandler<MazeServerProtocol.Maze> {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("An error has occurred when handling Maze message ({})",
                ctx.channel().remoteAddress().toString(), cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Maze msg) throws Exception {
        log.trace("Maze message received: {}", msg.toString());
    }
}
