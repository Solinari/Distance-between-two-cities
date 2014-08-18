import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Justin Tyme Dejesus
CSC 301 - HW 2
05/07/2014*/

public class DistanceCalc {
	
	public static Scanner openInput(String fname)
	{	
		// slightly modifying the MYIO method here to catch for blank lines before the exception
		Scanner infile = null;
		
		
		try {
			// dropping the delimiter here for when we parse over it downstairs, commas are messing up the input
			infile = new Scanner(new File(fname));
			
		} catch(FileNotFoundException e) {
			
			System.out.printf("Cannot open file '%s' for input\n", fname);
			System.exit(0);
		}
		return infile;
	}
	
	public static void greeting() {

		// put some stuff here down there
		String msg = "Welcome to homework 2.\n"
				   + "Enter a file name you want to use for this\n"
				   + "Then, enter a city name. and then another.\n"
				   + "We will then calculate the distance between them.\n"
				   + "Type enter or space then enter if you want to quit.\n";

		System.out.println(msg);
		System.out.println();
	}

	public static void main(String[] args) {
		
		greeting();
		
		// grab & open file
		System.out.println("Enter the file name:\n");
		Scanner fileinput = new Scanner(System.in);
		String thefile = fileinput.next();
		Scanner myfile = openInput(thefile);
		myfile.useDelimiter(",");
		
		
		
		//we're going to pass in CityCoord.. to the MyST!
		SequentialSearchST<String, CityCoord> MyST = new SequentialSearchST<String, CityCoord>();
		
		// drop everything from file 1 into my ST using .put()
		while (myfile.hasNextLine()) {

			if (myfile.hasNext() != false) {
				
				String[] myline = myfile.nextLine().split(",");
				
				// tests that this works
				/*System.out.println("myline's length is: " + myline.length);
				for (int i = 0; i < myline.length; i++) {
					
					System.out.println("boop " + myline[i]);
				}*/
				
				if (myline.length < 4) {
					break;
				}
				
				CityCoord mycitycoordvalue = new CityCoord(myline[1],
														   myline[0],
														   Double.parseDouble(myline[2]),
														   Double.parseDouble(myline[3]));
	
				
				String mycitycoordkey = mycitycoordvalue.City();

				MyST.put(mycitycoordkey, mycitycoordvalue);

			} else if (myfile.hasNext() == false) {
				break;
			}
		}
		
		//fileinput.close();
		//myfile.close();
		
		while (true) {
			// we do this loop forever untill user hits space or enter with nothing else
			
			// get city 1
			
			Scanner cities = new Scanner(System.in);
			System.out.println("\nPlease enter the name of city #1.");
			String mycityone = cities.nextLine();
			String check1 = mycityone; 
			
			System.out.println("Please enter the name of city #2.");
			String mycitytwo = cities.nextLine();
			String check2 = mycitytwo;
			
			if (check1.length() == 0 || check2.length() == 0) {
				System.out.println("Bye!");
				System.exit(0);
			}
			

			// find them in the symbol table
			CityCoord gettingcityone = MyST.get(mycityone);
			
			if (gettingcityone == null) {
				System.out.println(mycityone + " not found!!");
				continue;
			}
			
			CityCoord gettingcitytwo = MyST.get(mycitytwo);
			
			if (gettingcitytwo == null) {
				System.out.println(mycitytwo + " not found!!");
				continue;
			}
			
			System.out.println(gettingcityone);
			System.out.println(gettingcitytwo);
			
			
			
			if (gettingcityone != null && gettingcitytwo != null) {
				
				// calc distance
				double mydistance = GreatCircle.distance(gettingcityone.Latitude(),
						                                 gettingcityone.Longitude(),
						                                 gettingcitytwo.Latitude(),
						                                 gettingcitytwo.Longitude());

				// print distance
				System.out.printf("The distance between %s and %s is %f .\n", mycityone, mycitytwo, mydistance);
			}
			
		}
		
		
	}

}
