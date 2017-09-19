package org.lanqiao.JavaPractice;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.util.Random;  
  
public class RandomFile {  
    public static void main(String[] args) throws IOException {  
          
        File file = new File("d:/test.txt");  
        if (!file.exists()) {  
            file.createNewFile();  
        }  
        FileOutputStream fos = new FileOutputStream(file);  
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");  
        BufferedWriter out = new BufferedWriter(osw);  
        Random r = new Random();   
          
        long i = 0L;  
        while(i<3000000000L){  
            i++;  
            out.write(Integer.toString(r.nextInt(1000)));  
            out.write(",");  
            out.write(Integer.toString(r.nextInt(1000)));  
            out.write(",");  
            out.write(Integer.toString(r.nextInt(1000)));  
            out.newLine();  
            if(i%100000 ==0){  
                out.flush();  
            }             
        }         
        out.close();  
        System.out.println("数据生成到"+file);  
    }  
}  