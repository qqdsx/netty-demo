package com.example.netty.fundamental;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws InterruptedException {
        ctx.write(msg);
        Thread.sleep(1000);
        System.out.println("server 接收到消息啦");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws InterruptedException {
        ctx.flush();
        Thread.sleep(1000);
        System.out.println("server 发送到消息啦");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}