package org.lzy.NIO;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class ChatRoomServer {

    public static void main(String[] args) {
        // 创建serverSokectChanel
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();){
           serverSocketChannel.configureBlocking(true);//声明非阻塞IO
           //声明一个选择器
           Selector selector = Selector.open();
           serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//注册选择器，在客户端接入的事件上
           while(true) {
               int readyChannels = selector.select();//等待注册的事件发生    
               if(readyChannels == 0) {
                   continue;
               }
               //处理事件
               Set<SelectionKey> keys = selector.selectedKeys();
               Iterator<SelectionKey> iterator =  keys.iterator();
               while(iterator.hasNext()) {
                   SelectionKey selectionKey = iterator.next();
                   if(selectionKey.isAcceptable()) {
                       //客户端接入事件
                       SocketChannel channel = serverSocketChannel.accept();
                       channel.configureBlocking(false);
                       channel.register(selector, selectionKey.OP_READ);
                       //写入信息
                       channel.write(Charset.forName("GBK").encode("你好"));
                   }else if (selectionKey.isReadable()) {
                       //获取客户端channel
                       SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                       //获取channel内容
                       ByteBuffer buffer = ByteBuffer.allocate(128);
                       int flag = socketChannel.read(buffer);
                       StringBuffer stringBuffer = new StringBuffer();
                       while(flag != -1) {
                           buffer.flip();
                           stringBuffer.append(Charset.forName("GBK").decode(buffer));
                           buffer.clear();
                           flag = socketChannel.read(buffer);
                       
                       }
                   }
               }
           }
        }
        catch (Exception e) {
            // TODO: handle exception
        }
         
    }

}
