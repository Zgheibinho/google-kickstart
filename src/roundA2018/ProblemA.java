package roundA2018;

import java.util.*;
import java.io.*;

public class ProblemA {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("A-large-practice.in");
		Scanner scan = new Scanner(file);
	    PrintStream fileStream = new PrintStream("output.txt");
	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    for (int i = 1; i <= t; ++i) 
	    {
	      long n = scan.nextLong();
	      String str=""+n;
	      long temp=n;
	      boolean flag=true;
	      while(flag)
	      {
	    	  str=temp+"";
	    	  for(int j=0;j<=str.length();j++)
	    	  {
	    		  if(j==str.length())
	    		  {
	    			  flag=false;
	    			  break;
	    		  }
	    		  if((Character.getNumericValue(str.charAt(j))%2)!=0)
	    		  {
	    			  if(j==str.length()-1)
	    			  {
	    				  temp-=1;
	    			  }
	    			  else 
	    			  {
		    			  temp-= Long.parseLong(str.substring(j+1))+1;
	    			  }
	    			  break;
	    		  }
	    	  }
	      }
	      
	      long neg= n-temp;
	      
	      temp=n;
	      
	      flag=true;
	      
	      while(flag)
	      {
	    	  str=temp+"";
	    	  for(int j=0;j<=str.length();j++)
	    	  {
	    		  if(j==str.length())
	    		  {
	    			  flag=false;
	    			  break;
	    		  }
	    		  if((Character.getNumericValue(str.charAt(j))%2)!=0)
	    		  {
	    			  if(j==str.length()-1)
	    			  {
	    				  temp+=1;
	    			  }
	    			  else 
	    			  {
		    			  temp+= Math.pow(10,(str.length()-j-1)) - Long.parseLong(str.substring(j+1));
	    			  }
	    			  break;
	    		  }
	    	  }
	      }
	      
	      long pos=temp-n;
	      long result=Math.min(pos, neg);
	      
	      System.out.println("Case #" + i + ": " + result);
//	      System.out.println("pos:"+pos+"\t neg:"+neg);
	    }
	    scan.close();
	}
}
