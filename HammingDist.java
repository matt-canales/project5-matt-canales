import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist
{
	//holds the input locations
	String location1, location2;
	
	//ArrayList containing all locations, shortened to be only 4 characters
	protected ArrayList<String> locationList = new ArrayList<String>();
	protected ArrayList<String> dist1Loc = new ArrayList<String>();
	protected ArrayList<String> dist2Loc = new ArrayList<String>();
	protected ArrayList<String> dist3Loc = new ArrayList<String>();
	protected ArrayList<String> dist4Loc = new ArrayList<String>();
	
	//Hamming Distance from two input values
	int distance;
	
	//these counters hold the number of locations that are exactly that distant from each input location
	int counterLoc1Dist0, counterLoc1Dist1, counterLoc1Dist2, counterLoc1Dist3, counterLoc1Dist4;
	
	//constructor that accepts two string values as our selected locations
	public HammingDist(String loc1)
	{	
		location1 = loc1;		
		try
    	{
    		read();
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error reading from file!\n");
    		e.printStackTrace();
    	}
		
		//calcAllLocationDist();
		
		
	}
	
	public void read() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
						
		//read the next 120 lines into our locationList String array, and shorten them to the 4 character location
		for(int i = 0; i < 120; i++) 
		{
			locationList.add(i, br.readLine());
		}
		
		br.close();		
	}
	
	//calculates the Hamming distance between the two input locations
	public int calcHammingDist(String loc1, String loc2)
	{
		int numberDifferent = 0;
		for (int i = 0; i < loc1.length(); i++)
	       {
	           if (loc1.charAt(i) != loc2.charAt(i)) 
	           {
	        	   numberDifferent++;
	           }
	       }
	    return numberDifferent;
	}
	
	//calculates the Hamming distance to all locations from each location, stores them in local variables
	public void calcAllLocationDist() 
	{
		dist1Loc = new ArrayList<String>();
		dist2Loc = new ArrayList<String>();
		dist3Loc = new ArrayList<String>();
		dist4Loc = new ArrayList<String>();
		counterLoc1Dist0 = 0;
		counterLoc1Dist1 = 0;
		counterLoc1Dist2 = 0;
		counterLoc1Dist3 = 0;
		counterLoc1Dist4 = 0;
		
		int distance;
		
		//location1
		for(int i=0; i < locationList.size(); i++)
		{
			distance = calcHammingDist(location1, locationList.get(i));
			if (distance == 0)
			{
				counterLoc1Dist0++;
			}
			else if (distance == 1)
			{
				dist1Loc.add(locationList.get(i));
				counterLoc1Dist1++;
			}
			else if (distance == 2)
			{
				dist2Loc.add(locationList.get(i));
				counterLoc1Dist2++;
			}
			else if (distance == 3)
			{
				dist3Loc.add(locationList.get(i));
				counterLoc1Dist3++;
			}
			else if (distance == 4)
			{
				dist4Loc.add(locationList.get(i));
				counterLoc1Dist4++;
			}
		}
		
			
	}	
	
	public void addLocation(String location)
	{
		if(location.length() == 4)
		{
			locationList.add(location);
			calcAllLocationDist();
		}			
		else
			System.out.println("Location must be 4 characters.");
	}
	
}