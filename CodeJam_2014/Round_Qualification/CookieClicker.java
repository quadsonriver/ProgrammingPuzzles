import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;


public class CookieClicker {

	static double farmCost;
	static double perSecondCookies;
	static double farmCookieUpgrade;
	static double winAmount;
	static double totalTime;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(new File("B-large.in"));
		int testCases = keyboard.nextInt();
		
		PrintWriter out = new PrintWriter("CookieClicker.txt");
		
		for(int i = 0; i<testCases; i++)
		{
			perSecondCookies = 2.0;
			totalTime = 0;
			farmCost = keyboard.nextDouble();
			farmCookieUpgrade = keyboard.nextDouble();
			winAmount = keyboard.nextDouble();
			
			boolean win = false;
			while(!win)
			{
				if(zeroCookiesToWinTime() > zeroCookiesToWinTimeAfterNextFarm())
				{
					totalTime += timeToBuildFarm();
					perSecondCookies += farmCookieUpgrade;
				}
				else
				{
					totalTime+= zeroCookiesToWinTime();
					win = true;
				}
			}
			DecimalFormat df = new DecimalFormat("#.0000000");
			out.println("Case #" + (i+1) + ": " + df.format(totalTime));
		}
		out.close();

	}

	public static double zeroCookiesToWinTime() //return time to win from 0 cookies
	{
		return winAmount / perSecondCookies;
	}
	
	public static double zeroCookiesToWinTimeAfterNextFarm()
	{
		return (timeToBuildFarm() + winAmount / (perSecondCookies + farmCookieUpgrade));
	}
	
	public static double timeToBuildFarm()
	{
		return farmCost / perSecondCookies;
	}
}
