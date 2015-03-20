package com.quitevis.multiplayermaze.tests.smoke;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import org.junit.Rule;
import org.junit.Test;

import com.quitevis.mazeserver.api.generated.MazeServerProtocol.SessionId;
import com.quitevis.mazeserver.api.generated.MazeServerProtocol.Maze;
import com.quitevis.mazeserver.api.generated.MazeServerProtocol.MazeServerService;
import com.quitevis.multiplayermaze.tests.ClientTestResource;
import com.quitevis.multiplayermaze.tests.TestBase;

public class SmokeIT extends TestBase {
    @Rule
    public ClientTestResource client = getClient(new ChannelHandler() {
        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        }
        
        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        }
        
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        }
    });
    
    @Test
    public void clientCanSendMessageToTheServer() throws InterruptedException {
        SessionId id = SessionId.newBuilder().setSessionId("heya").build();
        Maze maze = Maze.newBuilder().setMazeId("maze id").build();
        
        client.sendMessage(id);
        client.sendMessage(maze);
    }
}
