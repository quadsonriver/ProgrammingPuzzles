import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class MagicTrick {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(new File("A-small-attempt1.in"));
		int testCases = keyboard.nextInt();
		
		PrintWriter out = new PrintWriter("MagicTrick.txt");
		
		for(int i = 0; i<testCases; i++)
		{
			int firstRowPicked = keyboard.nextInt(); //grab first row picked
			
			for(int x = 1; x<=firstRowPicked; x++) //skip ahead to the first row picked
				keyboard.nextLine();
			
			int[] cardsPossibleFirst = new int[4];
			for(int y = 0; y<4; y++) //fill first row picked into array
				cardsPossibleFirst[y] = keyboard.nextInt();
			for(int a = firstRowPicked; a<=4; a++) //skip ahead to second row picked
				keyboard.nextLine();
			
			int secondRowPicked = keyboard.nextInt(); //grab second row picked
			int[] cardsPossibleSecond = new int[4];
			for(int b = 1; b<=secondRowPicked; b++) //skip ahead to the second row picked
				keyboard.nextLine();
			for(int z = 0; z<4; z++) //fill second row picked into array
				cardsPossibleSecond[z] = keyboard.nextInt();
			for(int c = secondRowPicked; c<=4; c++) //skip ahead to second row picked
				keyboard.nextLine();
			
			String result = compare(cardsPossibleFirst, cardsPossibleSecond);
			out.println("Case #" + (i+1) + ": " + result);
			
		}
		out.close();
	}

	private static String compare(int[] cardsPossibleFirst,
			int[] cardsPossibleSecond) {
		
		int solutionsFound = 0;
		
		for(int i = 0; i<4; i++)
			for(int j = 0; j<4; j++)
			{
				if(cardsPossibleFirst[i] == cardsPossibleSecond[j])
					if(solutionsFound == 0)
						solutionsFound = cardsPossibleFirst[i];
					else
						solutionsFound = -1;
			}
		
		if(solutionsFound == -1)
			return("Bad magician!");
		else if(solutionsFound == 0)
			return("Volunteer cheated!");
		else
			return(solutionsFound + "");
	}

}
