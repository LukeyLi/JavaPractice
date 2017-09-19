package org.lzy.gc;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


public class ReferenceTest {
    public static final Map<Integer, Reference> map = new HashMap<Integer, Reference>();
    
    public static void main(String[] args) {
        for (int i = 0; i < 1000 ; i++) {
            //Weak Reference ：即使在root算法中 其引用的对象root可达到，但是如
            //果jvm堆内存 不够的时候，还是会被回收。
            map.put(i, new WeakReference(new ReferenceObject(i)) );
            map.put(i, new Strong);
        }
        int i = 0;
        for (Reference r : map.values()) {
            if(r.get() == null) {
                i++;
            }
        }
        System.out.println("被回收的对象数" + i);
    }
     static class ReferenceObject{
         private int i;
         private byte[] b;
         
         public ReferenceObject(int i) {
             this.i = i;
             b = new byte[1024*10];
         }
     }            
   
}