import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OversizedPancakeFlipper {

	static Scanner input;
	static PrintWriter output;
	static int testCases;
	static final String inFileName = "in.txt";
	static final String outFileName = "OversizedPancakeFlipper.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		initializeVariables();
		
		doLogic();
		
		closeVariables();
	}


	private static void doLogic() {
		String pancakes;
		int k, answer;
		char[] p;

		input.nextLine();
		
		for(int i = 0 ; i < testCases; i++)
		{
			answer = 0;
			pancakes = input.next();
			p = pancakes.toCharArray();
			k = input.nextInt();
			
			for(int x = 0; x<=pancakes.length()-k; x++)
			{
				if(p[x] == '-')
				{
					answer++;
					for(int y = 0; y<k; y++)
					{
						if(p[x+y] == '-')
							p[x+y] = '+';
						else
							p[x+y] = '-';
					}
				}
			}
			
			for(int z = 0; z<p.length; z++)
			{
				if(p[z] == '-')
					answer = -1;
			}
			
			if(answer == -1)
				output.write("Case #" + (i+1) + ": IMPOSSIBLE\n");
			else
				output.write("Case #" + (i+1) + ": " + answer + "\n");
		}
		
	}

	private static void initializeVariables() throws FileNotFoundException
	{
		input = new Scanner(new File(inFileName));
		output = new PrintWriter(new File(outFileName));
		testCases = input.nextInt();
	}
	private static void closeVariables() {
		input.close();
		output.close();
	}

}
