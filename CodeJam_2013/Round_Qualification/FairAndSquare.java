import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


public class FairAndSquare {

	static BigInteger[] PalList;
	static BigInteger[] allPal;
	static int count = 0;
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(new File("C-large-1.in"));
		PrintWriter output = new PrintWriter(new FileWriter("out2.txt"));
		int length = input.nextInt();

		
		createAllPalList();
		createPalList();
		
		for(int i = 0; i<length; i++)
		{
			input.nextLine();
			String numb1 = input.next();
			String numb2 = input.next();

			BigInteger num1 = new BigInteger(numb1);
			BigInteger num2 = new BigInteger(numb2);
			for(int j = 0; j<PalList.length; j++)
				if(num1.compareTo(PalList[j]) <=0 && num2.compareTo(PalList[j]) >= 0)
					count++;
			
			output.print("Case #" + (i+1) + ": " + count + "\n");
			count = 0;
		}
		output.close();
		
	}

	private static void createPalList() {
		PalList = new BigInteger[39];
		PalList[0] = BigInteger.valueOf(1);
		PalList[1] = BigInteger.valueOf(4);
		PalList[2] = BigInteger.valueOf(9);
		int x = 3;
		for(int i = 3; i<allPal.length; i++)
		{
			if(isPalendrome(allPal[i].multiply(allPal[i])))
			{
				PalList[x] = allPal[i].multiply(allPal[i]);
				x++;
				
			}
		}
		
	}

	private static void createAllPalList() {
		allPal = new BigInteger[10992];
		allPal[0] = BigInteger.valueOf(1);
		allPal[1] = BigInteger.valueOf(4);
		allPal[2] = BigInteger.valueOf(9);
		int x = 3;
		for(int i = 10; i<10000000; i++)
		{
			if(isPalendrome(BigInteger.valueOf(i)))
			{
				allPal[x] = BigInteger.valueOf(i);
				x++;
			}
		}
	}

	private static boolean isPalendrome(BigInteger i) {
		String num = i.toString();
		boolean pass = true;
		for(int m = 0; m<num.length()/2; m++)
			if(num.charAt(m) != num.charAt((num.length()-m)-1))
				pass = false;
		return pass;
	}
	
	BigInteger sqrt(BigInteger n)
	{
		Double d=Math.sqrt(n.doubleValue());
		n=BigInteger.valueOf(d.longValue());
		return n;
	}
}
