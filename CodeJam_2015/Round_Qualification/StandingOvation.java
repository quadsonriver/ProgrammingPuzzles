import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class StandingOvation {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));
		int max, friends, count = input.nextInt();
		String people;
		int[] parsedPeople;
		PrintWriter output = new PrintWriter(new File("StandingOvation.txt"));
		
		
		for(int x = 0; x< count; x++)
		{
			max = input.nextInt();
			people = input.next();
			parsedPeople = parseString(people);
			friends = countRequiredFriends(parsedPeople);
			
			output.write("Case #" + (x+1) + ": " + friends + "\n");
		}
		
		output.close();

	}



	private static int countRequiredFriends(int[] parsedPeople) {
		int friends = 0;
		int totalPeople = parsedPeople[0];
		for(int i = 1; i<parsedPeople.length; i++)
		{
			if(i > totalPeople)
			{
				friends++;
				totalPeople+=1;
			}
			totalPeople += parsedPeople[i];
		}
		return friends;
	}
	
	







	public static int[] parseString(String s)
	{
		int[] parsed = new int[s.length()];
		for(int i = 0; i< s.length(); i++)
		{
			parsed[i] = Character.getNumericValue(s.charAt(i));
		}
		return parsed;
	}
}
