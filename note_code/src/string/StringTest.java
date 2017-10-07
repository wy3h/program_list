package string;

public class StringTest
{
	public static void main(String[] args)
	{
		String s1 = "Hello";
		String s2 = ",";
		String s3 = "world";
		System.out.println("s1 == " + s1);
		System.out.println("s2 == " + s2);
		System.out.println("s3 == " + s3);
		
		// str.length()
		System.out.println("s1.length() == " + s1.length());
		System.out.println("s2.length() == " + s2.length());
		
		// str1.concat(str2) and `+` 
		System.out.println("s1.concat(s2) + s3 == " + s1.concat(s2) + s3);
		
		// str1.equals(str2)
		System.out.println("s1.equals(s2) == " + s1.equals(s2));
		
		// String.format()
		String s4 = String.format("%s,%s", "Hello", "world");
		System.out.println(s4);
		
		// str.charAt()
		System.out.println("s1.charAt(1) == " + s1.charAt(1));
	}
}
