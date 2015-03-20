package com.quitevis.multiplayermaze.tests.smoke;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import org.junit.Rule;
import org.junit.Test;

import com.quitevis.mazeserver.api.generated.MazeServerApi;
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
        MazeServerApi.SessionId id = MazeServerApi.SessionId.newBuilder().setSessionId("heya").build();
        MazeServerApi.Maze maze = MazeServerApi.Maze.newBuilder().setMazeId("maze id").build();
        
        client.sendMessage(id);
        client.sendMessage(maze);
    }
}
