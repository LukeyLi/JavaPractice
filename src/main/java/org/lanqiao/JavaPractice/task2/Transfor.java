package org.lanqiao.JavaPractice.task2;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lanqiao.JavaPractice.Student;
  /**
   * 将制定的map转换为指定的claz代表的类型的一个实例（下称bean）
   *具体来说：map中k为bean的property，map中v为bean的property value
   */
public class Transfor {
	
	private static final Logger LOGGER = Logger.getLogger(Transfor.class);
	
	public static <T> T map2Bean(Map map,Class<T> claz) {
		Object obj = null;
		try {
			 obj = claz.newInstance();
		//获取实体属性
	   
		Field[] fileds = obj.getClass().getDeclaredFields();
		//遍历所有属性，将属性赋值给Class类型
	
		for (Field field : fileds) {
			//设置访问权限
			field.setAccessible(true);
			//获取属性名
			String fieldName = field.getName();
			//获取属性值
			Object item = map.get(fieldName);
			if(field.getType() == int.class) {
				field.set(obj, Integer.parseInt((String)item));
			}
			if(field.getType() == String.class) {
			field.set(obj, item);}
			field.setAccessible(false);
			}
		return  (T)obj;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
		return (T)obj;
	}
    public static void main(String[] args)  {
    	
		Map<String,String> map = new HashMap<String, String>();
		map.put("name","hh" );
		map.put("age", "10");
   
		Student stu = (Student) map2Bean(map,Student.class);
			System.out.println(stu.getName());
			System.out.println(stu.getAge());	
		}	    	
	}

