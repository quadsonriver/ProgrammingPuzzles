import java.util.*;
import java.io.*;

public class GoGopher 
{
  static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static void main(String[] args) 
  {
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
 
    int A;
    
    for (int i = 1; i <= t; ++i) 
    {
    	A = in.nextInt();
    	
    	if(A == 20)
    		solve(3, false);
    	else
    		solve(24, true);
    }
  }
	
	private static void solve(int fullSquares, boolean large)
	{
		int column = 0,row = 0,counter = 1;
		boolean a,b,c,d,e,f,g,h,i;
		while(counter < fullSquares)
		{
			a=false;
			b=false;
			c=false;
			d=false;
			e=false;
			f=false;
			g=false;
			h=false;
			i=false;
			
			//initial squares
			while(!a || !b || !c || !d || !e || !f || !g || !h || !i)
			{
				System.out.println((3*counter)-1 + " 2");
				column = Integer.valueOf(in.next());
				row = Integer.valueOf(in.next());
				
				if(column == 0 || column == -1)
					break;
				
				if(column%3+1 == 1)
				{
					if(row == 1)
						a = true;
					else if(row == 2)
						b = true;
					else if (row == 3)
						c = true;
				}
				if(column%3+1 == 2)
				{
					if(row == 1)
						d = true;
					else if(row == 2)
						e = true;
					else if (row == 3)
						f = true;
				}
				if(column%3+1 == 3)
				{
					if(row == 1)
						g = true;
					else if(row == 2)
						h = true;
					else if (row == 3)
						i = true;
				}
			}
			counter++;
			if(column == 0 || column == -1)
				break;
		}
		
		//trailing end
		while(column != 0 && column != -1)
		{
			if(!large)
				System.out.println("6 2");
			else
				System.out.println("69 2");
			
			column = Integer.valueOf(in.next());
			row = Integer.valueOf(in.next());
		}
	}
}