import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class dijkstra {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("in.txt"));
		PrintWriter output = new PrintWriter(new File("dijkstra.txt"));
		int count = input.nextInt();

		String letters;
		for(int i = 0; i<count; i++)
		{
			int L = input.nextInt();
			int X = input.nextInt();
			String s = input.next();

			Boolean iCheck = false,jCheck = false, complete = false;
			String cur = "1";
			if(L > 1)
			{
				for(int m = 0; m<L*X; m++)
				{
					cur = getDijkstraValue(cur,s.substring((m%L), (m%L)+1));
					if(cur == "i" && !iCheck)
					{
						iCheck = true;
						cur = "1";
					}
					else if(cur=="j" && iCheck && !jCheck)
					{
						jCheck = true;
						cur = "1";
						
					}
					else if(cur == "k" && iCheck && jCheck && m == (L*X)-1)
					{
						complete = true;
					}
				}
			}
			if(complete)
				output.write("Case #" + (i+1) + ": YES\n");
			else
				output.write("Case #" + (i+1) + ": NO\n");
		}
		output.close();

	}


	public static String getDijkstraValue(String row, String column)
	{
		switch(row)
		{
		case "i": switch(column) {
			case "1": return "i";
			case "i":return "-1";
			case "j":return "k";
			case "k":return "-j";
			case "-1":return "-i";
			case "-i":return "1";
			case "-j":return "-k";
			case "-k":return "j";
					}
		case "-i":switch(column) {
		case "1": return "-i";
		case "i":return "1";
		case "j":return "-k";
		case "k":return "j";
		case "-1":return "i";
		case "-i":return "-1";
		case "-j":return "k";
		case "-k":return "-j";
				}
		case "j":switch(column) {
		case "1":return "j";
		case "i":return "-k";
		case "j":return "-1";
		case "k":return "i";
		case "-1":return "-j";
		case "-i":return "k";
		case "-j":return "1";
		case "-k":return "-i";
				}
		case "-j":switch(column) {
		case "1":return "-j";
		case "i":return "k";
		case "j":return "1";
		case "k":return "-i";
		case "-1":return "j";
		case "-i":return "-k";
		case "-j":return "-1";
		case "-k":return "i";
				}
		case "k":switch(column) {
		case "1":return "k";
		case "i":return "j";
		case "j":return "-i";
		case "k":return "-1";
		case "-1":return "-k";
		case "-i":return "-j";
		case "-j":return "i";
		case "-k":return "1";
				}
		case "-k":switch(column) {
		case "1":return "-k";
		case "i":return "-j";
		case "j":return "i";
		case "k":return "1";
		case "-1":return "k";
		case "-i":return "j";
		case "-j":return "-i";
		case "-k":return "-1";
				}
		case "1":switch(column) {
		case "1":return "1";
		case "i":return "i";
		case "j":return "j";
		case "k":return "k";
		case "-1":return "-1";
		case "-i":return "-i";
		case "-j":return "-j";
		case "-k":return "-k";
				}
		case "-1":switch(column) {
		case "1":return "-1";
		case "i":return "-i";
		case "j":return "-j";
		case "k":return "-k";
		case "-1":return "1";
		case "-i":return "i";
		case "-j":return "j";
		case "-k":return "k";
				}
		}
		return null;
			
		
	}
}
