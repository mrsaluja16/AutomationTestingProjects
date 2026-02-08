package java.String.Examples;

public class ReverseWords {

	public static void main(String[] args) {
		new ReverseWords().reverse("This is Ranjeet");
	}
	
	public void reverse(String s) {
		String[] c = s.split(" ");
		String result = "";
		for(int i=c.length-1; i>=0; i--) {
			if(i==0)
				result = result + c[i];
			else
				result = result + c[i]+ " ";		
		}
		System.out.println("Reverse of the STRING --" +s+" -- is:: "+result);
	}

}
