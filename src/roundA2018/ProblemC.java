package roundA2018;
import java.util.*;
import java.io.*;

public class ProblemC {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("C-large-practice.in");
		Scanner scan = new Scanner(file);
	    PrintStream fileStream = new PrintStream("output.txt");
	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    for (int i = 1; i <= t; ++i) 
	    {
	      int l = scan.nextInt();
	      
	      String[] dict= new String[l+1];
	      
	      for(int j=1;j<=l;j++)
	      {
	    	  dict[j]= scan.next();
	      }
	      
	      char s1= scan.next().charAt(0);
	      char s2= scan.next().charAt(0);
	      int n=scan.nextInt();
	      long a=scan.nextLong();
	      long b=scan.nextLong();
	      long c=scan.nextLong();
	      long d=scan.nextLong();
	      String str=""+s1+s2;
	      
	      
	      long[] x = new long[n];
	      x[0]=(int)s1;
	      x[1]=(int)s2;
	      for(int j=2;j<n;j++)
	      {
	    	  x[j] = ( a*x[j-1] + b*x[j-2] + c ) %d;
	    	  str += (char)(97 + ( x[j] % 26 ));
	      }
	      
	      int result=0;
//	      System.out.println(str);
	      
	      for(int j=1;j<=l;j++)
	      {
	    	  String currentstr=dict[j];
	    	  char firstchar=currentstr.charAt(0);
	    	  char lastchar=currentstr.charAt(currentstr.length()-1);
	    	  int start=0;
	    	  int end = currentstr.length()-1;
	    	  boolean flag=true;
	    	  for(int k=end;k<str.length()&&flag;k++)
	    	  {
//	    		  System.out.println("current:"+currentstr);
//	    		  System.out.println("sub:"+str.substring(start, end+1));
	    		  if((str.charAt(start)==firstchar)&&(str.charAt(end)==lastchar))
	    		  {
	    			  if (areAnagram(currentstr,str.substring(start, end+1)))
	    			  {
	    				  result++;
//	    				  System.out.println("yes!!");
	    				  flag=false;
	    				  continue;
	    			  }
	    		  }
	    		  end++;
	    		  start++;
	    	  }
	      }
	      
	      System.out.println("Case #" + i + ": " + result);
//	      System.out.println(""+areAnagram("abbd","babb"));
	    }
	    scan.close();
	}
	static boolean areAnagram(String str1, String str2) 
    { 
      
		char[] arrs1 = str1.toCharArray();  
		char[] arrs2 = str2.toCharArray();  
        // Sort both strings 
        Arrays.sort(arrs1); 
        Arrays.sort(arrs2); 
  
        // Compare sorted strings 
        for (int i = 0; i < arrs1.length; i++) 
            if (arrs1[i] != arrs2[i]) 
                return false; 
  
        return true; 
    } 
	
}