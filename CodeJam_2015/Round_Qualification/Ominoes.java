import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Ominoes {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));
		PrintWriter output = new PrintWriter(new File("Ominoes.txt"));
		int count = input.nextInt();

		boolean win;
		int X, R, C;
		for(int i = 0; i<count; i++)
		{
			X = input.nextInt();
			R = input.nextInt();
			C = input.nextInt();
			win = false;
			
			if(X == 1)
				win = true;
			else if(X == 2 && (R*C)%2 == 0)
				win = true;
			else if(X == 3 && (X-1) <= R && (X-1) <= C && (R*C) % 3 == 0)
				win = true;
			else if(X == 4 && (X-1) <= R && (X-1) <= C && (R*C) != 8 && (R*C) % 4 == 0)
				win = true;
			
			if(win)
				output.write("Case #" +(i+1) + ": GABRIEL\n");
			else
				output.write("Case #" +(i+1) + ": RICHARD\n");
		}
		output.close();

	}

}
