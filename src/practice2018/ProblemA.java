package practice2018;

import java.util.*;
import java.io.*;

public class ProblemA {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
	    int t = scan.nextInt();
	    int current;
	    int n;
	    int p;
	    PrintStream fileStream = new PrintStream("output.txt");
	    System.setOut(fileStream);
	    for (int i = 1; i <= t; i++)
	    {
	      n = scan.nextInt();
	      HashMap<Integer, Integer> start = new HashMap<>(n+1);
	      HashMap<Integer, Integer> end = new HashMap<>(n+1);
	      for (int j = 1; j <= n; j++)
	      {
	    	//add start and end of each bus
	    	  current = scan.nextInt();
	    	  start.put(j,current);
	    	  current = scan.nextInt();
	    	  end.put(j,current);
	      }
	      System.out.print("Case #" + i + ":");
	      p = scan.nextInt();
	      int count;
	      for (int k=1 ; k <= p; k++)
	      {
	    	  // for p number of cities check how many buses pass through it
	    	  count=0;
	    	  int currentcity=scan.nextInt();
	    	  for(int l=1; l<=n;l++)
	    	  {
		    	  if((currentcity>=start.get(l))&&(currentcity<=end.get(l)))
		    	  {
		    		 count++; 
		    	  }
	    	  }
	    	  System.out.print(" "+count);
	      }
	      System.out.println("");
	    }
	    scan.close();
	}
}