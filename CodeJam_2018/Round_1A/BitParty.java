import java.util.*;
import java.io.*;

/*
 * To determine the fastest path for completed robot transactions. Logic:
 * 		1) Determine a given time
 * 		2) Calculate what we can accomplish at the given time
 * 		3) If we can complete the requested transaction at the given time in any fashion, try again with smaller time (binary search)
 * 
 *  Input Variables:
 *  	R = number of robots
 *  	B = number of bits
 *  	C = number of cashiers
 *  		M = max number of items for given cashier
 *  		S = time in seconds to process a single item (occurs each Bit)
 *  		P = time in seconds to complete transaction (occurs 1 time)
 */
public class BitParty 
{
  static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static void main(String[] args) throws InterruptedException 
  {
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    int R,B,C;
    List<Cashier> cashiers;
    
    for (int i = 1; i <= t; ++i) 
    {    	
    	//initialize variables
    	
    	R = in.nextInt();
    	B = in.nextInt();
    	C = in.nextInt();
    	cashiers = new ArrayList<Cashier>();
    	
    	for(int x = 0; x<C; x++)
    		cashiers.add(new Cashier(in.nextInt(), in.nextInt(), in.nextInt()));
    	
    	int min = 1;
    	int max = Integer.MAX_VALUE-1;
    	int cur = (max+min)/2;
    	Integer[] maxAtGivenTimeForCashier = new Integer[cashiers.size()];
    	int position;
    	int bitsAtSecond;

    	//initialize done
    	
    	/*
    	 * Logic:
    	 * 		1) Binary search between max and min for current time
    	 * 		2) Find the max transactions that each cashier can accomplish at the given time
    	 * 		3) Sort the max transactions in non-increasing order
    	 * 		4) Grab the first R cashiers and determine if we can successfully process at least B items
    	 * 		5) Return the last known time where successful
    	 */
    	while(cur != min)
    	{
    		position = 0;
    		bitsAtSecond = 0;
    		for(Cashier c : cashiers)
    		{
    			if(cur >= c.minTime)
    			{
	    			int atSecond = ((cur - c.minTime) / c.itemTime) + 1;
	    			if(atSecond > c.maxItems)
	    				atSecond = c.maxItems;
	    			maxAtGivenTimeForCashier[position] = atSecond;
    			}
    			else
    				maxAtGivenTimeForCashier[position] = 0;
    			
    			position++;
    		}
    		Arrays.sort(maxAtGivenTimeForCashier, Collections.reverseOrder());
    		
    		for(int d = 0; d<R; d++)
    		{
    			bitsAtSecond += maxAtGivenTimeForCashier[d];
    		}
    		if(bitsAtSecond >= B)
    		{
    			max = cur;
    			cur = (max+min)/2;
    		}
    		else if(bitsAtSecond < B)
    		{
    			min = cur;
    			cur = (max+min)/2;
    		}
    	}
    	
		System.out.println("Case #" + (i) + ": " + max);
    }
  }
  
  public static class Cashier
  {
	  int minTime;
	  int itemTime;
	  int maxItems;
	  public Cashier(int maxItems, int s, int min)
	  {
		  minTime = min + s;
		  itemTime = s;
		  this.maxItems = maxItems;
	  }
  }
}