import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Gets input int for total number of problems
		Scanner scan = new Scanner(System.in);
		int len = Integer.parseInt(scan.nextLine());
		//Iterates through every problem
		for (int i = 0; i < len; i++) {
			//Reads the input string for the problem
			String input = scan.nextLine();
			//Replaces all [?,?] brackets in the initial string
			input = input.replace("[?,?]", "2?");
			//Sets up an infinite loop
			boolean bal = true;
			while (bal == true) {
				//Searches the string for integers, and creates a reverse ordered set of them
				Matcher m1 = Pattern.compile("[0-9]+").matcher(input);
				Set<Integer> num = new HashSet<Integer>(); 
				while (m1.find()) {
				    int n = Integer.parseInt(m1.group());
				    num.add(n);
				}
				List<Integer> nums = new ArrayList<Integer>(num);
				Collections.sort(nums);
				Collections.reverse(nums);
				//For each integer found, does a replace on certain bracket patterns in the string
				//For [n,?] or [n,n] brackets, replaces with 2n
				//For [n?,?] or [n?,m?], n>=m brackets, replaces with 2n?
				for (int j : nums) {
					input = input.replaceAll("\\["+j+",\\?\\]|\\[\\?,"+j+"\\]|\\["+j+","+j+"\\]", ""+j*2);
					input = input.replaceAll("\\[\\?,"+j+"\\?\\]|\\["+j+"\\?,\\?\\]|\\["+j+"\\?,[0-9]+\\?\\]|\\[[0-9]+\\?,"+j+"\\?\\]", j*2+"?");
				}
				//Clears the integers from memory
				num.clear();
				nums.clear();
				//Searches for brackets [n,m]
				Matcher m2 = Pattern.compile("\\[[0-9]+,[0-9]+\\]").matcher(input);
				while (m2.find()) {
					String[] x = m2.group().split(",");
					//If a bracket with two different integers is found, returns a NO
					if ( Integer.parseInt(x[0].substring(1, x[0].length())) / Integer.parseInt(x[1].substring(0, x[1].length()-1)) != 1 ) {
						System.out.println("NO");
						bal = false;
					}
				}
				//Searches for brackets [n,m?]
				Matcher m3 = Pattern.compile("\\[[0-9]+\\?,[0-9]+\\]|\\[[0-9]+,[0-9]+\\?\\]").matcher(input);
				while (m3.find()) {
					String[] x = m3.group().split(",");
					int y;
					int z;
					if(x[0].contains("?")) {
						 y = Integer.parseInt(x[0].substring(1, x[0].length()-1));
						 z = Integer.parseInt(x[1].substring(0, x[1].length()-1));
					}
					else {
						 z = Integer.parseInt(x[0].substring(1, x[0].length()  ));
						 y = Integer.parseInt(x[1].substring(0, x[1].length()-2));						
					}
					// If n/m is not an integer, return NO
					if (z % y != 0 ) {
						System.out.println("NO");
						bal = false;
					}
					//Otherwise replace with 2n
					else {
						input = input.replace(m3.group(), (2*z)+"");
					}
				}
				
				// If the string now consists only of either n, or n?, return YES
				if (input.matches("\\d+")||input.matches("\\d+\\?")) {
					System.out.println("YES");
					bal = false;
				}
			}
		}
		scan.close();
	}
}
