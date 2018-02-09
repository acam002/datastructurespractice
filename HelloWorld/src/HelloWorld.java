
public class HelloWorld {
	
	
	public static void main(String[] args) {
		HelloWorld h = new HelloWorld();
		System.out.println(h.palindrome("aa"));
		
		
	}
	
	public boolean palindrome(String str) {
		
		if (str.length() == 0 || str.length() == 1) {
			return true;
		}
		
		if (str.charAt(0) == str.charAt(str.length() - 1)) {
			return palindrome(str.substring(1, str.length() - 1));
		}
		
		return false;
	}
}
