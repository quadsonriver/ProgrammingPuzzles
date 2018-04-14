import java.util.*;
import java.io.*;

/*
 * To determine if we can cut the waffles as desired. Logic:
 * 		1) Cutting Vertically, each section of columns that are cut needs to be equal in chips.
 * 		2) Cutting Horizontally, each section of rows that are cut needs to be equal in chips.
 * 		3) We know the number of cuts, means we know the number of chips in each horizontal/vertical section.
 * 		4) Find intervals to make cuts, and determine chips per section.
 * 		4) The cuts we made need to have the same number of chips.
 * 
 * Input Variables:
 * 		R = number of rows
 * 		C = number of columns
 * 		H = number of horizontal cuts
 * 		V = number of vertical cuts
 * 		temp = single line of waffle
 */
public class WaffleChompers 
{
  static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static void main(String[] args) 
  {
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int R,C,H,V;

    char[][] waffles;
    int[] wafflesRow;
    int[] wafflesColumn;
    int totalChips;
    String answer;
    
    for (int i = 1; i <= t; ++i) 
    {
    	//initialize variables for each test case
    	R = in.nextInt();
    	C = in.nextInt();
    	H = in.nextInt();
    	V = in.nextInt();
    	
    	wafflesRow = new int[R];
    	wafflesColumn = new int[C];
    	totalChips = 0;
    	answer = "";
    	waffles = new char[C][R];
    	//end initialize
    	
    	/*loop each line and set up arrays for:
    	 *  wafflesRow	 	total chips in each row
    	 *  wafflesColumn	total chips in each column
    	 *  totalChips		total chips overall
    	 *  waffles			the actual waffle as one piece 
    	 */
    	String temp = in.nextLine();
    	
    	for(int x = 0; x<R; x++)
    	{
    		temp = in.nextLine();

    		for(int y = 0; y<temp.length(); y++)
    		{
    			if(temp.charAt(y) == '@')
    			{
    				wafflesRow[x]++;
    				wafflesColumn[y]++;
    				totalChips++;
    			}
    			waffles[y][x] = temp.charAt(y);
    		}
    	}
    	
    	
    	/*
    	 * Multi-step process
    	 * 		1) Determine the location(s) where we need to cut the waffle vertically
    	 * 		2) Determine the location(s) where we need to cut the waffle horizontally
    	 * 		3) Count the chips that are in each cut piece of the waffle
    	 * 		4) Determine if each piece has the same number of chips in them
    	 */
    	if(totalChips % ((H+1)*(V+1)) == 0)
    	{
			int cur = 0;
			List<Integer> verticalCuts = new ArrayList<Integer>();
			List<Integer> horizontalCuts = new ArrayList<Integer>();
			
			verticalCuts.add(0);
			horizontalCuts.add(0);
			
			//step 1: each piece needs to have the same count in each vertically cut section
			for(int a = 0; a<wafflesColumn.length; a++)
			{
				cur+= wafflesColumn[a];
				
				if(cur == totalChips/(V+1))
				{
					verticalCuts.add(a+1);
					cur = 0;
				}
				else if(cur > totalChips/(V+1))
				{
					answer = "IMPOSSIBLE";
					break;
				}
				
			}
			
			//step 2: each piece needs to have the same count in each horizontally cut section
			for(int b = 0; b<wafflesRow.length; b++)
			{
				if(answer != "")
					break;
	
				cur+= wafflesRow[b];
				
				if(cur == totalChips/(H+1))
				{
					horizontalCuts.add(b+1);
					cur = 0;
				}
				else if(cur > totalChips/(H+1))
				{
					answer = "IMPOSSIBLE";
					break;
				}
			}
			
			//step 3: count chips into appropriate section
			int[][] pieces = new int[V+1][H+1];
			for(int d = 0 ; d < verticalCuts.size()-1; d++)
			{
				for(int e = 0; e < horizontalCuts.size()-1; e++)
				{
					for(int f = verticalCuts.get(d); f<verticalCuts.get(d+1); f++)
					{
						for(int g = horizontalCuts.get(e); g<horizontalCuts.get(e+1); g++)
						{
							if(waffles[f][g] == '@')
								pieces[d][e]++;
						}
					}
				}
			}
			
			//step 4: determine if each piece has the same count, otherwise we fail
			HashSet<Integer> distinct = new HashSet<Integer>();
			for(int[] row : pieces)
			{
				for(int element : row)
				{
					distinct.add(element);
				}
			}
	    	if(distinct.size() == 1 && answer == "")
	    		answer = "POSSIBLE";
	    	else
	    		answer = "IMPOSSIBLE";
    	}
    	else
    		answer = "IMPOSSIBLE";
    	
		System.out.println("Case #" + (i) + ": " + answer);
    }
  }
}