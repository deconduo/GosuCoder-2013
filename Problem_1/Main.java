import java.util.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Gets input int for total number of problems
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		//Iterates through all the problems
		for (int i = 0; i < s; i++) {
			int x = in.nextInt();
			int y = 0;
			//Checks if input is a palindrome, if not, reverses it and adds it to itself
			while (reverse(x) != x) {
				x = x + reverse(x);
				//Counts the number of steps taken
				y += 1;			
			}
			//Once  
			System.out.println(x + " " + y);
		}
		in.close();
	}
	// Function to reverse an integer
	public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
        	//Divides the number by 10, and records the remainder
            int remainder = x % 10;
            //Adds the remained to a new number and multiplies by 10
            reversed = reversed * 10 + remainder;
            x = x / 10;
        }
        return reversed;
    }

}
