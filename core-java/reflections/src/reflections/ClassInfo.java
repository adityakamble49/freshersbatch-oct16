package reflections;

import java.lang.reflect.*;

public class ClassInfo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class c = Class.forName(args[0]);
		Constructor[] con = c.getConstructors();
		Method[] methods = c.getDeclaredMethods();
		Field[] fields = c.getDeclaredFields();
		
		for(int i=0; i<con.length; i++){
			System.out.println(con[i]);
		}

		for(int i=0; i<methods.length; i++){
			System.out.println(methods[i]);
		}

		for(int i=0; i<fields.length; i++){
			System.out.println(fields[i]);
		}
	}

}
