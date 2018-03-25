import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RevengeOfThePancakes {

	static Scanner input;
	static PrintWriter output;
	static int testCases;
	static final String inFileName = "in.txt";
	static final String outFileName = "RevengeOfThePancakes.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		initializeVariables();
		
		doLogic();
		
		closeVariables();
	}


	private static void doLogic() {
		int answer;
		String pancakes;
		
		input.nextLine();
		
		for(int i = 0 ; i < testCases; i++)
		{
			answer = 0;
			pancakes = input.nextLine();
			char lastSeen = '!';
			for(int x= 0; x < pancakes.length() ; x++)
			{
				if(pancakes.charAt(x) != lastSeen)
				{
					lastSeen = pancakes.charAt(x);
					answer++;
				}
			}
			if(pancakes.charAt(pancakes.length()-1) == '+' && answer > 0)
				answer --;
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
