import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class LawnMower {

	static int[][] lawn;
	static boolean isPossible;
	public static void main(String[] args) throws IOException
	{
		
		Scanner input = new Scanner(new File("B-large.in"));
		PrintWriter output = new PrintWriter(new FileWriter("out.txt"));
		int length = input.nextInt();
		input.nextLine();
		for(int i = 0; i<length; i++)
		{
			int h = input.nextInt();
			int w = input.nextInt();
			lawn = new int[h][w];
			
			for(int j = 0; j<h; j++)
				for(int k = 0; k<w; k++)
					lawn[j][k] = input.nextInt();
			
			isPossible = true;
			for(int l = 0; l<h; l++)
			{
				for(int m = 0; m<w; m++)
				{
					int check = lawn[l][m];
					boolean horCheck = true;
					boolean verCheck = true;
					for(int n = 0; n<w; n++) //check vertical
					{
						if(check < lawn[l][n])
							verCheck = false;
					}
					for(int o = 0; o<h; o++) //check vertical
					{
						if(check < lawn[o][m])
							horCheck = false;
					}
					if(verCheck == false && horCheck == false)
						isPossible = false;
				}
			}
			output.print("Case #" + (i+1) + ": ");
			if(isPossible == true)
				output.print("YES\n");
			else
				output.print("NO\n");
		}
		output.close();
	}
}
