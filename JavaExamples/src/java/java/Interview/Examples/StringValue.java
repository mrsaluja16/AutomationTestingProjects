package java.Interview.Examples;

public class StringValue {

	public static void main(String[] args) {
		new StringValue().subStringValue("PROGRAMMING");

	}
	public void subStringValue(String s) {
		System.out.println("First four word from String is: "+s.substring(0,4));
		System.out.println("Last four word from String is: "+s.substring(s.length()-4,s.length()));
		System.out.println("Middle word from String is: "+s.substring(4,s.length()-4));
	}
}
