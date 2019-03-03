package practice2018;

import java.util.*;
import java.io.*;

public class ProblemD {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("D-small-practice.in");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    for (int i = 1; i <= t; ++i) 
	    {
	      int n = scan.nextInt();
	      int q = scan.nextInt();
	      
	      long[] initarray= new long[n];
	      
	      long[] sumarray= new long[n*(n+1)/2 +1];
	      
	      for (int j = 0; j < n; ++j)
	      {
	    	  initarray[j]=scan.nextLong();
	      }
	      
	      long[][] matrix = new long[n+1][n+1];
			 for(int k=0; k<n+1;k++)
				 for(int j=0; j<n+1;j++)
				 {
					 if(k>=j)
						 matrix[k][j]=0;// starting index bigger than ending index
					 else
					 {
						 matrix[k][j]= matrix[k][j-1]+initarray[j-1];
					 }
				 }
			 
			 int current=1;
			 for(int k=0; k<n+1;k++)
				 for(int j=0; j<n+1;j++)
				 {
					 if(j>k)
					 {
						 sumarray[current]=matrix[k][j];
						 current++;
					 }
				 }
			 Arrays.sort(sumarray);
//	      System.out.println(Arrays.toString(sumarray));
//	      for(int k=1; k<n+1;k++)
//				 for(int j=1; j<n+1;j++)
//				 {
//					 if(k>j)
//						 matrix[k][j]=0;// starting index bigger than ending index
//					 else
//					 {
//						 matrix[k][j]= matrix[k][j-1]+sumarray[j];
//					 }
//				 }
	      
	      
	      System.out.println("Case #" + i + ":");
	      
	      int li=0;
	      int ri=0;
	      int currentsum=0;
	      
	      for(int k=1;k<=q;k++)
	      {
	    	  li=scan.nextInt();
	    	  ri=scan.nextInt(); 
	    	  currentsum=0;
	    	  for(int l=li;l<=ri;l++)
	    	  {
	    		  currentsum+=sumarray[l];
	    	  }
	    	  System.out.println(currentsum);
	      }
	    }
	    scan.close();
	}

}
