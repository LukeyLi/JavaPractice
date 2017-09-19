package org.lzy.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



/**
 * @author 帅帅的李志颖
 *利用channel和buffer读取文件内容
 */
public class NIOFileRead {
public static void main(String[] args) {
    //创建Channel对象
  
    try ( FileChannel channel = FileChannel.open(Paths.get("d:/text.txt"), StandardOpenOption.READ);){
        //读取Channel内容
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int flag = channel.read(buffer);
        System.out.println(flag);
        //处理Buffer
        while(flag != -1) {
            buffer.flip();//切换写模式到读操作
         //   CharBuffer charBuffer = buffer.asCharBuffer();
            Charset charset = Charset.forName("GBK");
            CharBuffer charBuffer = charset.decode(buffer);
            while(charBuffer.hasRemaining()) {
                System.out.print(charBuffer.get());
            }
            buffer.clear();
            flag = channel.read(buffer);
        }
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 

  
    
    //异常处理
}
}
