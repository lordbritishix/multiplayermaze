package com.quitevis.multiplayermaze.server.infra.network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.logging.LoggingHandler;

import com.quitevis.mazeserver.api.generated.MazeServerProtocol;
import com.quitevis.multiplayermaze.server.infra.network.handlers.MazeMessageHandler;
import com.quitevis.multiplayermaze.server.infra.network.handlers.SessionIdMessageHandler;

public class MazeServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        
        //Upstream handlers
        //Logger
        p.addLast(new LoggingHandler());
        
        //Decoder
        p.addLast(new ProtobufVarint32FrameDecoder());
        
        //Decoders for messages
        p.addLast(new ProtobufDecoder(MazeServerProtocol.SessionId.getDefaultInstance()));
        p.addLast(new ProtobufDecoder(MazeServerProtocol.Maze.getDefaultInstance()));

        //Handlers for messages
        p.addLast(new SessionIdMessageHandler());
        p.addLast(new MazeMessageHandler());
        
        //Downstream handlers
//      p.addLast(new ProtobufVarint32LengthFieldPrepender());
//      p.addLast(new ProtobufEncoder());
    }
}
