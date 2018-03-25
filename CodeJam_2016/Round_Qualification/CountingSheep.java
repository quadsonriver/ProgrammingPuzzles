import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountingSheep {

	static Scanner input;
	static PrintWriter output;
	static int testCases;
	static final String inFileName = "in.txt";
	static final String outFileName = "CountingSheep.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		initializeVariables();
		
		doLogic();
		
		closeVariables();
	}


	private static void doLogic() {
		int answer = 0, startNum;
		StringBuilder foundNums;
		
		input.nextLine();
		
		
		for(int i = 0 ; i < testCases; i++)
		{
			String s;
			foundNums = new StringBuilder();
			startNum = input.nextInt();
			int cur = startNum;
			
			if(startNum == 0)
				output.write("Case #" + (i+1) + ": INSOMNIA\n");
			else
			{
				while(foundNums.length() <10)
				{
					s = String.valueOf(cur);
					for(int x = 0; x<s.length(); x++)
					{
						if(foundNums.indexOf(String.valueOf(s.charAt(x))) < 0)
						{
							foundNums.append(String.valueOf(s.charAt(x)));
						}
					}
					if(foundNums.length() == 10)
					{
						output.write("Case #" + (i+1) + ": " + cur + "\n");
						break;
					}
					cur += startNum;
				}
			}
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
