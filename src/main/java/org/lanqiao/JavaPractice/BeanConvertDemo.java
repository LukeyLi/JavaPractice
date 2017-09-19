package org.lanqiao.JavaPractice;


import java.lang.reflect.Field;  
import java.lang.reflect.Method;  
import java.util.HashMap;  
import java.util.Map;

import org.junit.Test; 

  
/** 
 * @ClassName: BeanConvertDemo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author no_relax 
 * @date 2016年5月27日 下午3:49:29 
 *  
 */  
public class BeanConvertDemo {  
  
    // 实体类转换器  
    public static <T> T beanConvert(Map obj, T bean){  
        if (obj == null) {  
            throw new RuntimeException("被转换的实体类不能为空！");  
        }  
        try {  
            // 获取实体的所有属性  
            Field[] fields =bean.getClass().getDeclaredFields();  
            // 遍历所有属性，将属性的值赋给T  
            for (Field field : fields) {  
                // 允许访问  
                field.setAccessible(true);  
                // 获取属性名  
                String fieldName = field.getName();  
                // 获取属性值  
                Object iteam = obj.get(fieldName);  
                if (field.getType() == String.class) {  
                    field.set(bean, iteam);  
                }  
                field.setAccessible(false);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
  
        }  
        return bean;  
    }  
      
    public static void main(String[] args) throws Exception {  
        Map<String, Object> a = new HashMap<String, Object>();  
        a.put("name","wusong");  
        a.put("password","123456");  
        B b = beanConvert(a,new B());  
        System.out.println(b.getName()+":"+b.getPassword());  
        /*Field[] fields = A.class.getDeclaredFields(); 
        for (Field field : fields) { 
            field.setAccessible(true); 
            String name = field.getName(); 
            Object object = field.get(a); 
            System.out.println(object); 
            //field.set(a, "1231"); 
        }*/  
    }  
      
    @Test  
    public void test() throws Exception{  
        /****************************执行main方法******************************/  
        System.out.println("------执行main方法--------------");  
        //通过反射机制，执行main方法  
        Class<?>  beanConvertDemo= Class.forName("com.norelax.www.BeanConvertDemo");  
        //获取类所有的方法  
        Method[] declaredMethods = beanConvertDemo.getDeclaredMethods();  
        //获取指定的类方法  
        Method main = beanConvertDemo.getDeclaredMethod("main", String[].class);  
        //main方法的执行  
        main.invoke(null, (Object)new String[]{});  
        //或者  
        main.invoke(null, new Object[]{new String[]{}});  
        /***************************执行beanConvert方法*******************************/  
        System.out.println("------执行beanConvert方法--------------");  
        Method beanConvert = beanConvertDemo.getDeclaredMethod("beanConvert", Map.class,Object.class);  
        //执行方法  
        Map<String, Object> a = new HashMap<String, Object>();  
        a.put("name","wusong");  
        a.put("password","123456");  
        B b = (B) beanConvert.invoke(beanConvertDemo.newInstance(),a,new B() );  
        System.out.println(b.getName()+":"+b.getPassword());  
    }  
      
    }  
class B{  
    private String name;  
    private String password;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
}  