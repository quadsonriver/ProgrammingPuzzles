import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TidyNumbers {

	static Scanner input;
	static PrintWriter output;
	static int testCases;
	static final String inFileName = "in.txt";
	static final String outFileName = "TidyNumbers.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		initializeVariables();
		
		doLogic();
		
		closeVariables();
	}


	private static void doLogic() {
		String answer = "", num;
		char[] c;
		boolean failTidy;

		input.nextLine();
		
		for(int i = 0 ; i < testCases; i++)
		{
			failTidy = true;
			answer = "";
			num = input.nextLine();
			c = num.toCharArray();
			
			if(c.length == 1)
				answer = num;
			else
			{
				for(int x = c.length-1; x>0; x--)
				{
					if(c[x] < c[x-1])
					{
						c[x-1] = (char) ((int)c[x-1]-1);
						for(int y = x; y<=c.length-1;y++)
							c[y] = '9';
					}
				}
				
				boolean leadingZeroes = true;
				for(int a = 0; a<c.length; a++)
				{
					if(c[a] == '0' && leadingZeroes)
					{}
					else
					{
						leadingZeroes = false;
						answer+=c[a];
					}
				}
			}
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
