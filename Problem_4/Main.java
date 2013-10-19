import java.util.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Gets input int for total number of carrots
		Scanner scan = new Scanner(System.in);
		int len = Integer.parseInt(scan.nextLine());
		List<Float> carrots = new ArrayList<Float>();
		List<Float> bag = new ArrayList<Float>();
		
		//Adds all carrots to a list, and sorts by largest first
		for (int i = 0; i < len; i++) {
			Float input = scan.nextFloat();
			carrots.add(input);
		}
		scan.close();
		Collections.sort(carrots);
		Collections.reverse(carrots);
		float total = 0;
		int noc = 0;
		
		// Starting with the largest carrot, adds carrots to a 5kg bag
		for (int j = 0; j < len; j++) {
			//Stops if the next carrot would overfill the bag
			if (total + carrots.get(0) < 5000.00) {
				bag.add(carrots.get(0));
				total += carrots.get(0);
				carrots.remove(carrots.get(0));
				noc += 1;
			}
			//Then adds carrots starting with the smallest until the bag is full
			else {
				bag.add(carrots.get(carrots.size()-1));
				total += carrots.get(carrots.size()-1);
				carrots.remove(carrots.get(carrots.size()-1));
				noc += 1;
				
			}
			//Once the bag is full, prints out the contents, and resets everything
			if (total >= 5000.00) {
				String print = "5kg";
				for (int i=0; i < noc; i++ ) {
					print = print + " " + String.format("%.2f", bag.get(i));
				}
				System.out.println(print);
				total = 0;
				noc = 0;
				bag.clear();
			}
		
		}
		//Once all carrots have been used, there will probably be some left over
		//The same method is used to pack these into 500g bags instead
		for (float o : bag) {
			carrots.add(o);
		}
		len = carrots.size();
		total = 0;
		noc = 0;
		bag.clear();
		for (int j = 0; j < len; j++) {
			if (total + carrots.get(0) < 500.00) {
				bag.add(carrots.get(0));
				total += carrots.get(0);
				carrots.remove(carrots.get(0));
				noc += 1;
			}
			else {
				bag.add(carrots.get(carrots.size()-1));
				total += carrots.get(carrots.size()-1);
				carrots.remove(carrots.get(carrots.size()-1));
				noc += 1;
				
			}
			if (total >= 500.00) {
				String print = "500g";
				for (int i=0; i < noc; i++ ) {
					print = print + " " + String.format("%.2f", bag.get(i));
				}
				System.out.println(print);
				total = 0;
				noc = 0;
				bag.clear();
			}
		}		

	}
}
