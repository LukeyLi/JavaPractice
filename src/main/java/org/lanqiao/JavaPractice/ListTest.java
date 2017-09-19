package org.lanqiao.JavaPractice;


import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		String sql = "select * from employee";
		
		ResultSet rs =null ;
		try {
			List<StudentsT> list=BeanList(rs,StudentsT.class);
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i).getName()+" ");
				System.out.println(list.get(i).getAge());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<StudentsT> BeanList(ResultSet rs,Class<StudentsT> claz) throws Exception{
		List<StudentsT> list=new ArrayList<StudentsT>();
	   Class c=claz;
		Constructor< StudentsT> con=null;
		while(rs.next()){
			String name=rs.getString("name");
			String age=rs.getString("age");
			 con=claz.getDeclaredConstructor(String.class,String.class);
			list.add(con.newInstance(name,age));
		}
		return list;
		
	}
}
class StudentsT{
	String name;
	String age;
	
	public StudentsT(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
