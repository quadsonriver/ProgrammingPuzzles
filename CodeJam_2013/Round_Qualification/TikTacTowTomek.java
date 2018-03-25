import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Scanner;


public class TikTacTowTomek {

	static boolean xWin = false;
	static boolean oWin = false;
	static boolean gameDone = true;
	
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(new File("A-large.in"));
		PrintWriter output = new PrintWriter(new FileWriter("out.txt"));
		int games = input.nextInt();
		for(int i = 0; i<games; i++)
		{
			input.nextLine();
			char[][] board = new char[4][4];
			//empty board created
			
			for(int j = 0; j<4; j++)
			{
				String line = input.nextLine();
				board[j][0] = line.charAt(0);
				board[j][1] = line.charAt(1);
				board[j][2] = line.charAt(2);
				board[j][3] = line.charAt(3);
				if(line.charAt(0) == '.' || line.charAt(1) == '.' || line.charAt(2) == '.' || line.charAt(3) == '.')
					gameDone = false;
			}
			//board filled
			checkBoardStatus(board);
			output.write("Case #" + (i+1) + ": ");
			if(xWin == true && oWin == true)
				output.write("Draw");
			else if(xWin == true)
				output.write("X won");
			else if(oWin == true)
				output.write("O won");
			else if(gameDone == true)
				output.write("Draw");
			else
				output.write("Game has not completed");
			
			if(i!= games-1)
				output.write("\n");
			xWin = false;
			oWin = false;
			gameDone = true;
		}
		output.close();
	}
	public static void checkBoardStatus(char[][] board)
	{
		//check if xWins
		if(board[0][0] == 'X' || board[0][0] == 'T')
		{
			//check horizontal
			if(board[0][1] == 'X' || board[0][1] == 'T')
				if(board[0][2] == 'X' || board[0][2] == 'T')
					if(board[0][3] == 'X' || board[0][3] == 'T')
						xWin = true;
			//check vertical
			if(board[1][0] == 'X' || board[1][0] == 'T')
				if(board[2][0] == 'X' || board[2][0] == 'T')
					if(board[3][0] == 'X' || board[3][0] == 'T')
						xWin = true;
			//check diagonal
			if(board[1][1] == 'X' || board[1][1] == 'T')
				if(board[2][2] == 'X' || board[2][2] == 'T')
					if(board[3][3] == 'X' || board[3][3] == 'T')
						xWin = true;
		}
		if(board[1][0] == 'X' || board[1][0] == 'T')
			if(board[1][1] == 'X' || board[1][1] == 'T')
				if(board[1][2] == 'X' || board[1][2] == 'T')
					if(board[1][3] == 'X' || board[1][3] == 'T')
						xWin = true;
		if(board[2][0] == 'X' || board[2][0] == 'T')
			if(board[2][1] == 'X' || board[2][1] == 'T')
				if(board[2][2] == 'X' || board[2][2] == 'T')
					if(board[2][3] == 'X' || board[2][3] == 'T')
						xWin = true;
		if(board[3][0] == 'X' || board[3][0] == 'T')
			if(board[3][1] == 'X' || board[3][1] == 'T')
				if(board[3][2] == 'X' || board[3][2] == 'T')
					if(board[3][3] == 'X' || board[3][3] == 'T')
						xWin = true;
		if(board[0][1] == 'X' || board[0][1] == 'T')
			if(board[1][1] == 'X' || board[1][1] == 'T')
				if(board[2][1] == 'X' || board[2][1] == 'T')
					if(board[3][1] == 'X' || board[3][1] == 'T')
						xWin = true;
		if(board[0][2] == 'X' || board[0][2] == 'T')
			if(board[1][2] == 'X' || board[1][2] == 'T')
				if(board[2][2] == 'X' || board[2][2] == 'T')
					if(board[3][2] == 'X' || board[3][2] == 'T')
						xWin = true;
		if(board[0][3] == 'X' || board[0][3] == 'T')
			if(board[1][3] == 'X' || board[1][3] == 'T')
				if(board[2][3] == 'X' || board[2][3] == 'T')
					if(board[3][3] == 'X' || board[3][3] == 'T')
						xWin = true;
		if(board[0][3] == 'X' || board[0][3] == 'T')
			if(board[1][2] == 'X' || board[1][2] == 'T')
				if(board[2][1] == 'X' || board[2][1] == 'T')
					if(board[3][0] == 'X' || board[3][0] == 'T')
						xWin = true;
		//check if oWins
		if(board[0][0] == 'O' || board[0][0] == 'T')
		{
			//check horizontal
			if(board[0][1] == 'O' || board[0][1] == 'T')
				if(board[0][2] == 'O' || board[0][2] == 'T')
					if(board[0][3] == 'O' || board[0][3] == 'T')
						oWin = true;
			//check vertical
			if(board[1][0] == 'O' || board[1][0] == 'T')
				if(board[2][0] == 'O' || board[2][0] == 'T')
					if(board[3][0] == 'O' || board[3][0] == 'T')
						oWin = true;
			//check diagonal
			if(board[1][1] == 'O' || board[1][1] == 'T')
				if(board[2][2] == 'O' || board[2][2] == 'T')
					if(board[3][3] == 'O' || board[3][3] == 'T')
						oWin = true;
		}
		if(board[1][0] == 'O' || board[1][0] == 'T')
			if(board[1][1] == 'O' || board[1][1] == 'T')
				if(board[1][2] == 'O' || board[1][2] == 'T')
					if(board[1][3] == 'O' || board[1][3] == 'T')
						oWin = true;
		if(board[2][0] == 'O' || board[2][0] == 'T')
			if(board[2][1] == 'O' || board[2][1] == 'T')
				if(board[2][2] == 'O' || board[2][2] == 'T')
					if(board[2][3] == 'O' || board[2][3] == 'T')
						oWin = true;
		if(board[3][0] == 'O' || board[3][0] == 'T')
			if(board[3][1] == 'O' || board[3][1] == 'T')
				if(board[3][2] == 'O' || board[3][2] == 'T')
					if(board[3][3] == 'O' || board[3][3] == 'T')
						oWin = true;
		if(board[0][1] == 'O' || board[0][1] == 'T')
			if(board[1][1] == 'O' || board[1][1] == 'T')
				if(board[2][1] == 'O' || board[2][1] == 'T')
					if(board[3][1] == 'O' || board[3][1] == 'T')
						oWin = true;
		if(board[0][2] == 'O' || board[0][2] == 'T')
			if(board[1][2] == 'O' || board[1][2] == 'T')
				if(board[2][2] == 'O' || board[2][2] == 'T')
					if(board[3][2] == 'O' || board[3][2] == 'T')
						oWin = true;
		if(board[0][3] == 'O' || board[0][3] == 'T')
			if(board[1][3] == 'O' || board[1][3] == 'T')
				if(board[2][3] == 'O' || board[2][3] == 'T')
					if(board[3][3] == 'O' || board[3][3] == 'T')
						oWin = true;
		if(board[0][3] == 'O' || board[0][3] == 'T')
			if(board[1][2] == 'O' || board[1][2] == 'T')
				if(board[2][1] == 'O' || board[2][1] == 'T')
					if(board[3][0] == 'O' || board[3][0] == 'T')
						oWin = true;
	}
}
