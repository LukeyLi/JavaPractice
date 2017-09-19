package org.lanqiao.JavaPractice.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionShow {
	public static void main(String[] args) throws ClassNotFoundException {
		show();
	}
	public static void show() throws ClassNotFoundException {
		//加载类
		Class claz = Class.forName("org.lanqiao.JavaPractice.Student");
        //获取属性
		Field[] po = claz.getDeclaredFields();
		System.out.println(claz.getName()+"类的属性如下:");
		for (int i = 0; i < po.length; i++) {
			System.out.println("========================");
		    Field field = po[i];
		    System.out.println("属性："+i+1+"名称为"+field.getName());
		    System.out.println("该属性类型为"+field.getType());
		    //以整数形式返回由此Field对象表示属性的JAVA访问权限修饰符
		    int m = field.getModifiers();
		    System.out.println("该属性的修饰符为"+Modifier.toString(m));   
		}
		//获取构造器
		Constructor clist[] = claz.getDeclaredConstructors();
		int i = 0;
		for (Constructor con : clist) {
			System.out.println("构造方法为"+(i+1)+"名称为"+con.getName());
			System.out.println("该构造器所在的类或接口为"+con.getDeclaringClass());
			Class[] ptl = con.getParameterTypes();
			for (int j = 0; j < ptl.length; j++) {
				System.out.println("形参"+(j+1)+"类型为"+ptl[j]);
			}
		}
	}
}
