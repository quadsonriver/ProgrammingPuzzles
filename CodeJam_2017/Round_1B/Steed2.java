import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Steed2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));
		PrintWriter output = new PrintWriter(new File("Steed2.txt"));
		double answer = 0;

		int testCases = input.nextInt();
		
		
		for(int i = 0; i<testCases; i++)
		{
			answer = 0;
			int D,N;
			D = input.nextInt();
			N = input.nextInt();
			
			double cur = 0,slowest = 0;
			int curDist,curSpeed;
			for(int x = 0; x<N; x++)
			{
				curDist = input.nextInt();
				curSpeed = input.nextInt();
				
				cur = (double) (D - curDist) / curSpeed;
				if(slowest < cur)
				{
					slowest = cur;
				}
			}
			
			answer = (double)D / slowest;
			
			output.write("Case #" + (i+1) + ": " + answer + "\n");
			
		}
		output.close();
	}

}