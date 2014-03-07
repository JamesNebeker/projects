import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class ReadFile {
	
	String fInPath; // Create a variable to store our file in path
	String fOutPath; // Create a variable to store our file out path
	
	
	
	
		/* Create a method to get the file in path from the user 
			 */
	public void setInPath(String s)
	{
		fInPath = s;
	}
		/* Create a method to get the file out path from the user */
	public void setOutPath(String s)
	{
		fOutPath = s;
	}
		// Check extension of given file path
	public boolean chckExt()
	{
		if (fInPath.matches("C:'\'Users'\'James'\'Desktop'\'testin.txt")) 
		{
			System.out.println(fInPath);
			return false;
			
		}
		return true;
	}
		// Declare and initiliaze IO objects on specified file path, checking for IO and FNF Exceptions
	public void setIO()
	{
		
		if (fInPath.isEmpty() == false) // Check to make sure fPath has been set
		{
		  if (fOutPath.isEmpty() == false) // Check to make sure that fOutPath has been set
		  {
			  initCopy();
		  } else {
			  
			  System.out.println("File Out Path must be set");
		  }
		} else 
		{
	         System.out.println("File In Path must be set");
		}
			
	}
	
	public void initCopy() 
	{
		try (BufferedReader in = new BufferedReader(new FileReader(fInPath)))
		{
			
			
			String temp;
			String copyVal[]= new String[100000];  
			int secNum = 0;
			int tbCounter = 0;
			int quoteCounter = 0;
			double feet = 0.00;
			double inches = 0.00;
			int separate;
			int indx = 0;
			int eIndx = 0;
			int lCounter = 0;
			int counter = 0;
			int indX = 0;
			double deltX=0;
			double deltY=0;
			char prvChar = ' ';
			String separateInt;
			DecimalFormat three = new DecimalFormat("0.000");
		
			
				try (PrintWriter out = new PrintWriter(new FileWriter(fOutPath)))
				{
					while ((temp = in.readLine()) != null) {
						lCounter = temp.length()  - 1;
						for (int i = 0; i < temp.length(); i++)
						{
							
								if (temp.charAt(i) == '\"')
								{
									 
									
									if (prvChar == ' ' || prvChar == '\t')
									{
										
										
									for (int j = i + 1; j < temp.length() - 1; j++)
									{
										
									  if (temp.charAt(j) == '\"')
									  {
										  
										  quoteCounter++;
										  if (quoteCounter == 2)
										  {
											  
											  eIndx = j;
											  copyVal[indX] = temp.substring(i, eIndx);
											  copyVal[indX] = copyVal[indX].replaceAll("\"", "");
											  if (temp.charAt(i + 1) != '-')
											  {
												  copyVal[indX] = copyVal[indX].replaceAll("-", "");
												  separate = copyVal[indX].indexOf("\'");
												  separateInt = copyVal[indX].substring(0, separate);
												  feet = Double.parseDouble(separateInt);
												  
												  separateInt = copyVal[indX].substring(separate + 1, copyVal[indX].length() - 1);
												  inches = Double.parseDouble(separateInt);
												  inches = inches / 12;
												  
												  feet += inches;
												  
												  copyVal[indX] = three.format(feet);
											  } else 
											  {
												  separate = copyVal[indX].indexOf("\'");
												  separateInt = copyVal[indX].substring(0, separate);
												  feet = Double.parseDouble(separateInt); 
												  copyVal[indX] = copyVal[indX].replaceAll("-", "");
												  separateInt = copyVal[indX].substring(separate + 1, copyVal[indX].length() - 1);
												  inches = Double.parseDouble(separateInt);
												  inches = inches / 12;
												  
												  feet += inches;
												 
												  copyVal[indX] = three.format(feet);
												  
											  }
											  
											  
											 
											  indX++;
										  }
									  }
									}
									quoteCounter=0;
									
								}
								}
								prvChar = temp.charAt(i);
								
							
						}
						
						if (copyVal[2] != null)
						{
							if (copyVal[0] != null)
								deltX = Double.parseDouble(copyVal[0]);
							if (copyVal[1]!=null)
								deltY = Double.parseDouble(copyVal[1]);
							if (deltX + deltY > 1)
							{
								
							
						out.println("CONVSECTION name " + " sec" + secNum + " type DefaultSection piece begx " +  copyVal[5] + " begy " + copyVal[6] + " begz " + copyVal[7] + " endx " + copyVal[2] + " endy " + copyVal[3] + " endz " + copyVal[4] + " upz " + "0");
						
						
							}
						}
						secNum++;
						indX = 0;
					}
				
				
				
				
		     
		} catch (IOException e) {
			e.printStackTrace();
		} 
	

} catch (IOException e) {
	e.printStackTrace();
} 

}

}
