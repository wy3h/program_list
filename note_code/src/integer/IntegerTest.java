package integer;

public class IntegerTest
{
	public static void main(String[] args)
	{
		Integer i = 10;
		System.out.println("i.doubleValue() = " + i.doubleValue());
		System.out.println("i.compareTo(new Integer(10)) == " + i.compareTo(new Integer(10)));
		System.out.println("i.equals(new Double(10.0)) == " + i.equals(new Double(10.0)));
		System.out.println("i.toString() == " + i);		// "" + i mean call i.toString()
		System.out.println("Integer.valueOf(\"10\") == " + Integer.valueOf("10"));
		System.out.println("Integer.parseInt(\"10\") == " + Integer.parseInt("10"));
	}

}
