package java.Interview.Examples;

public class InstanceOfKeyword {
	
	public static void main(String areg[]) {
		
		Child c = new Child();
		c.checkInstanceOf();
		System.out.println("Variable is Object of String class: "+c.checkInstanceOfString(new String("str")));
		
	}

}

class Parent{
	
}

class Child extends Parent{
	
	public void checkInstanceOf(){
	
		Child cobj = new Child();
		
		Parent pobj = new Child();
		
		System.out.println("Child obj is instance of Child Class: "+(cobj instanceof Child));
		
		System.out.println("Child obj is instance of Parent Class: "+(pobj instanceof Parent));
		
		System.out.println("Child obj is instance of Object Class: "+(cobj instanceof Object));
		
		System.out.println("Parent obj is instance of Object Class: "+(pobj instanceof Object));
	
	
	}
	
	public boolean checkInstanceOfString(Object o) {
		return (o instanceof String);
	}
	
	
}
