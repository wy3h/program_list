package character;

public class CharacterTest
{
	public static void main(String[] args)
	{
		Character c1 = new Character('a');
		Character c2 = 'A';
		Character c3 = '1';
		
		System.out.printf("c1 = %c%nc2 = %c%nc3 = %c%n", c1, c2, c3);
		System.out.println("Character.isDigit(c3) == " + Character.isDigit(c3));
		System.out.println("Character.isLetter(c1) == " + Character.isLetter(c1));
		System.out.println("Character.isLowerCase(c1) == " + Character.isLowerCase(c1));
		System.out.println("Character.isUpperCase(c2) == " + Character.isUpperCase(c2));
		System.out.println("Character.isWhiterSpace(' ') == " + Character.isWhitespace(' '));
		System.out.println("Character.toLowerCase(c2) == " + Character.toLowerCase(c2));
		System.out.println("Character.toUpperCase(c1) == " + Character.toUpperCase(c1));
	}
}
