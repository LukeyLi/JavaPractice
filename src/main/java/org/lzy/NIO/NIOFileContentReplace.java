package org.lzy.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 利用NIO替换大文件内容
 * @author 帅帅的李志颖
 *
 */
public class NIOFileContentReplace {
    public static void main(String[] args) {
    
    try ( FileChannel channel = FileChannel.open(Paths.get("d:/text.txt"),StandardOpenOption.READ,StandardOpenOption.WRITE)){
        //读取文件内容，读取buffer
        ByteBuffer buffer = ByteBuffer.allocate(4);
        int flag = channel.read(buffer);
        while(flag != -1) {
            buffer.flip();
            CharBuffer charBuffer = Charset.forName("GBK").decode(buffer);
            while(charBuffer.hasRemaining()) {
             if(charBuffer.get() == '你') {
            //替换内容
            String content = new String(buffer.array(),"GBK");
            String newContent = content.replace('你', '我');
            channel.position(channel.position()-buffer.limit());
            //写回文件
            channel.write(ByteBuffer.wrap(newContent.getBytes()));
        }
             buffer.clear();
             flag =channel.read(buffer);
             }
            }
    }catch(IOException e){
        
    }
        

}
}