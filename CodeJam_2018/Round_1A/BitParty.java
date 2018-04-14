import java.util.*;
import java.io.*;

public class BitParty 
{
  static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static void main(String[] args) throws InterruptedException 
  {
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int answer;

    int R,B,C;
    List<Cashier> cashiers;
    
    for (int i = 1; i <= t; ++i) 
    {
    	answer = 0;
    	
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