import java.util.*;
import java.io.*;

public class TroubleSort 
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int numbers;
    String answer;
    
    int[] listOne;
    int[] listTwo;
    
    for (int i = 1; i <= t; ++i) 
    {
    	answer = "";
    	numbers = in.nextInt();
    	if(numbers % 2 == 1)
    	{
    		listOne = new int[numbers/2 + 1];
    		listTwo = new int[numbers/2 + 1];
    	}
    	else
    	{
    		listOne = new int[numbers/2];
    		listTwo = new int[numbers/2];    		
    	}
    	
    	listTwo[listTwo.length-1] = Integer.MAX_VALUE; //set the last value to max to cover odd number count
    	
    	for(int x = 0; x< numbers; x++)
    	{
    		if(x%2 == 0)
    			listOne[x/2] = in.nextInt();
    		else
    			listTwo[x/2] = in.nextInt();
    	}
    	
    	Arrays.sort(listOne);
    	Arrays.sort(listTwo);
    	
    	int position = 1;
    	int left = listOne[0];
    	int right = listTwo[0];
    	
    	while(position < numbers)
    	{
    		if(left > right)
    		{
    			answer = String.valueOf(position-1);
    			break;
    		}

    		position ++;
    		if(position == numbers)
    			break;
    		
    		left = right;
    		if(position % 2 == 0)
    			right = listOne[position/2];
    		else
    			right = listTwo[position/2];
    	}
    	
    	if(answer == "")
    		answer = "OK";

		System.out.println("Case #" + (i) + ": " + answer + "\n");
    }
  }
}