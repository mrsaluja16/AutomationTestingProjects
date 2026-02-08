package java.Interview.Examples;

public class ReverseString {

	public static void main(String[] args) {
		new ReverseString().reverse("Java");
		new ReverseString().reverse("Programming");
	}
	
	public void reverse(String s) {
		s = s.toLowerCase();
		String reversed  = "";
		for(int i=s.length()-1; i>=0 ; i--) {
			reversed = reversed + s.charAt(i);
		}
		System.out.println("Reverse value of "+s+" is: "+reversed);
	}

}
