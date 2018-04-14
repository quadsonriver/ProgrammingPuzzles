import java.util.*;
import java.io.*;

public class SavingTheUniverseAgain 
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int health, answer;
    String robot;
    
    for (int i = 1; i <= t; ++i) 
    {
    	health = in.nextInt();
    	robot = in.next();
    	answer = 0;
    	
    	if(robot.indexOf('S') < 0) //all charging... no moves needed
        	System.out.println("Case #" + (i) + ": " + answer + "\n");
    	else if(robot.chars().filter(x -> x == 'S').count() > health) //more shots fired than our shield
        	System.out.println("Case #" + (i) + ": " + "IMPOSSIBLE" + "\n");
    	else 
    	{
    		int curDamageLevel = 1;
    		int damageDealt = 0;
    		int[] hits = new int[robot.length()];
    		for(int x = 0; x<robot.length(); x++)
    		{
    			if(robot.charAt(x) == 'C')
    				curDamageLevel *= 2;
    			else
    			{
    				damageDealt += curDamageLevel;
    				hits[x] = curDamageLevel;
    			}
    		}
    		
    		while(damageDealt > health)
    		{
        		Arrays.sort(hits);
        		damageDealt -= hits[hits.length-1]/2;
        		hits[hits.length-1] = hits[hits.length-1]/2;
    			answer++;
    		}

        	System.out.println("Case #" + (i) + ": " + answer + "\n");
    	}
    		
    }

  }
}