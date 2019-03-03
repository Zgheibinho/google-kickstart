package practice2018;

import java.util.*;
import java.io.*;

public class ProblemB {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
	    PrintStream fileStream = new PrintStream("output.txt");
	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    for (int i = 1; i <= t; ++i) 
	    {
	      int n = scan.nextInt();
	      HashMap<String, String> starttoend = new HashMap<>(n+1);
	      HashMap<String, String> endtostart = new HashMap<>(n+1);
	      
	      String currentback="";
	      String currentfront="";
	      for (int j=1;j<=n;j++)
	      {
	    	currentback = scan.next();
		    currentfront= scan.next();
		      
		    starttoend.put(currentback, currentfront);
		    endtostart.put(currentfront, currentback);  
	      }
	      
	      String result=currentback+"-"+currentfront;
	      
	      while(endtostart.containsKey(currentback))
	      {
	    	  result= endtostart.get(currentback)+"-"+currentback+" "+result;
	    	  currentback=endtostart.get(currentback);
	      }
	      while(starttoend.containsKey(currentfront))
	      {
	    	  result+= " "+currentfront+"-"+starttoend.get(currentfront);
	    	  currentfront=starttoend.get(currentfront);
	      }
	      System.out.println("Case #" + i + ": " + result);
	    }
	    scan.close();
	}
}