import java.util.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Gets input int for total length of input string
		Scanner scan = new Scanner(System.in);
		int length = Integer.parseInt(scan.nextLine());
		//Gets input string
		String input = scan.nextLine();
		//Sets a total equal to the length of the string
		int total = length;
		//Checks for patterns of NE, WS, EN, SW, and subtracts one from the total for each found.
		//These correspond to corners which do not count as having an etched line through them
		//Starts with the first and last characters
		if ((input.charAt(length-1) == 'N') && (input.charAt(0) == 'E')  || (input.charAt(length-1) == 'W') && (input.charAt(0) == 'S') || (input.charAt(length-1) == 'E') && (input.charAt(0) == 'N') || (input.charAt(length-1) == 'S') && (input.charAt(0) == 'W')) {
			total -= 1;
		}
		//Iterates across the rest of the string
		for (int i = 1; i < length; i++) {
			if ((input.charAt(i-1) == 'N') && (input.charAt(i) == 'E')  || (input.charAt(i-1) == 'W') && (input.charAt(i) == 'S') || (input.charAt(i-1) == 'E') && (input.charAt(i) == 'N') || (input.charAt(i-1) == 'S') && (input.charAt(i) == 'W')) {
				total -= 1;
			}
		}
		scan.close();
		//Prints half the total as the number of etched lines.
		System.out.println(total/2);
	}
}
