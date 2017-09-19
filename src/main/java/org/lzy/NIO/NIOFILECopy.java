package org.lzy.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;





public class NIOFILECopy {
    //创建读取文件通道
    public static void main(String[] args) {
        //创建写入文件通道
    
//     try(FileChannel srcChannel = FileChannel.open(Paths.get("d:/text.txt"), StandardOpenOption.READ);
//         FileChannel targetChannel = FileChannel.open(Paths.get("d:/text1.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE)){
////     FileChannel channel = Files.newBtyeChanel(Paths,options)
//  //Channels.newChannel(in);     
//         //读取到buffer
//     ByteBuffer buffer = ByteBuffer.allocate(1024);
//     int flag = srcChannel.read(buffer);
//     while(flag != - 1) {
//         buffer.flip();//切换写模式到读模式
//        //写入到目标通道
//        int result =  targetChannel.write(buffer);
//         System.out.println(result);
//          buffer.clear();
//          flag = srcChannel.read(buffer);
//     }
//}catch (Exception e) {
//    // TODO: handle exception
//}
    
        try {
            Files.copy(Paths.get("d:/text.txt"),Paths.get("d:/text1.txt"));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
}}