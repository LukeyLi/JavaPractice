package org.lzy.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class JavaSpider {
    public static void Save_Html(String url){
        try{
            String name="d:/1.html";
            File dest=new File(name);
            InputStream is;
            FileOutputStream fos=new FileOutputStream(dest);
            URL temp=new URL(url);
            URLConnection uc=temp.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) "
                    + "AppleWebKit/533.17.9 (KHTML, like Gecko) "
                    + "Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
            is=temp.openStream();
            
            BufferedInputStream bis=new BufferedInputStream(is);
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            
            int length;
            byte [] bytes=new byte[1024*20];
            while((length=bis.read(bytes,0,bytes.length))!=-1){
                fos.write(bytes, 0, length);
            }
            
            bos.close();
            fos.close();
            bis.close();
            is.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("openStream流错误，跳转get流");
            try{
                Document doc=Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)")
                        .timeout(3000)
                        .post();
                String name="1.html";
                File dest=new File(name);
                if(!dest.exists())
                    dest.createNewFile();
                FileOutputStream out=new FileOutputStream(dest,false);
                out.write(doc.toString().getBytes("utf-8"));
                out.close();
            }catch(IOException e1){
                e1.printStackTrace();
                System.out.print("get流错误，请检查网址是否正确");
            }
        }
    }
    
    public static void Get_Localhtml(String path,String stringpath){
        File file=new File(path);
        File[] array=file.listFiles();
        for(int i=0;i<array.length;i++){
            try{
                if(array[i].isFile()){
                    System.out.println("正在解析网址:"+array[i].getName());
                    
                    Document doc=Jsoup.parse(array[i],"UTF-8");
                    Element content=doc.getElementById("content");
                    /*Elements links=content.getElementsByTag("div");
                    Elements pngs=doc.select("img[src$=.png]");
                    Element masthead =doc.select("div.masthead").first();*/
                    ArrayList<String > arr=new ArrayList<String>();
                    Elements div=doc.select("div");
                    for(Element e:div){
                        String dd=e.text();
                        arr.add(dd);
                    }
                
                    /*for(Element link:links){
                        //String linkHref=link.attr("href");
                        String linkText=link.text();
                        arr.add(linkText);
                    }*/
                    TextToFile(arr,stringpath);
                }
            }catch(Exception e){
                System.out.println("网址:"+array[i].getName()+"解析错误");
                e.printStackTrace();
                continue;
            }
        }
    }
    private static void TextToFile(ArrayList<String> linkText,String path) {
        
        try {
             File fw = new File(path);
                //BufferedWriter bw = new BufferedWriter(fw);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(  
                        new FileOutputStream(fw), "utf-8")); 
                for(String str: linkText){
                    writer.append(str);
                }
                writer.close();
                
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    

    public static void main(String args[]){
        /*String url="http://theory.people.com.cn/n1/2017/0811/c40531-29464388.html";
        String path="src/temp_html/";
        Save_Html(url);
        Get_Localhtml(path,"E:\\3.txt");*/
        File f=new File("D:\\htmlLoad\\1.txt");
        System.out.println(f.length());
    }

}
