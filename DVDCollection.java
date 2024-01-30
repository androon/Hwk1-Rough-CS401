import java.io.*;
import java.util.Scanner;

public class DVDCollection {

	// Data fields
	
	/** The current number of DVDs in the array */
	private int numdvds;
	
	/** The array to contain the DVDs */
	private DVD[] dvdArray;
	
	/** The name of the data file that contains dvd data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the DVD collection was
	    modified since it was last saved. */
	private boolean modified = false;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 7. When we try to
	 *  insert into a full array, we will double the size of
	 *  the array first.
	 */
	public DVDCollection() {
		numdvds = 0;
		dvdArray = new DVD[7];
	}
	
	public String toString() {
		// Return a string containing all the DVDs in the
		// order they are stored in the array along with
		// the values for numdvds and the length of the array.
		// See homework instructions for proper format.
		String returnString = "";
		returnString = "numdvds = " + numdvds + '\n';
		returnString += "\ndvdArray.length = " + dvdArray.length + '\n';
		for(int i = 0; i < dvdArray.length; i++){
			if(dvdArray[i] != null) {
			returnString += "\ndvdArray [" + i + "] = " + dvdArray[i].toString();
			}
			else {
				//returnString += "\ndvdArray [" + i + "] = null";
			}
		}


		return returnString;

	}

	public void addOrModifyDVD(String title, String rating, String runningTime) {
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.
		if(numdvds == dvdArray.length) {
			//Doubling array size for future DVD's
			DVD[] newArray = new DVD[dvdArray.length * 2];
			//Copy elements over to new array
			for(int i = 0; i < dvdArray.length; i++) {
				newArray[i] = dvdArray[i];
			}
			//Set dvdArray to newArray
			dvdArray = newArray;
		}
		//Converting runningTime passed as string to integer
		int runTime = Integer.valueOf(runningTime);
		//Create a new DVD with passed title,rating, and runningtime values
		DVD newDVD = new DVD(title, rating, runTime);
		
		//Add newDVD to dvdArray at index numdvds to store after our most recent dvd addition
		dvdArray[numdvds] = newDVD;

		//Bookkeeping
		numdvds++;
	}
	
	public void removeDVD(String title) {
		int count = 0;
		for(int i = 0; i < dvdArray.length; i++) {
			//If index dvdArray at index i is not null and title equals the title at the index make the index null
			if(dvdArray[i] != null && title.equals(dvdArray[i].getTitle())) {
				dvdArray[i] = null;
				break;
			}
			count++;
		}
		//Book Keeping
		numdvds--;
		this.modified = true;
		//Shifting elements left
		System.out.println(count);
		for(int i = count; i < dvdArray.length-1;i++){
			dvdArray[i] = dvdArray[i+1];
		}
		
	}
	
	public String getDVDsByRating(String rating) {
		String sameRating = "";
		for(int i = 0; i < dvdArray.length; i++) {
			if(dvdArray[i]!= null && rating.equals(dvdArray[i].getRating())) {
				sameRating += dvdArray[i].getTitle() + "\n";
			}
		}
		return sameRating;	// STUB: Remove this line.
	}

	public int getTotalRunningTime() {
		int totalRunTime = 0;
		for(int i = 0; i < dvdArray.length; i++) {
			if(dvdArray[i] != null) {
			totalRunTime += dvdArray[i].getRunningTime();
			}
		}
		return totalRunTime;	// STUB: Remove this line.

	}

	
	public void loadData(String filename) {
		this.sourceName = filename;
		try {
			File myFile = new File(filename);
			if(myFile.length() != 0) {
			System.out.println("Current working directory: " + System.getProperty("user.dir"));
			Scanner myScanner = new Scanner(myFile);
			
				while(myScanner.hasNextLine()) {
					String wholeLine = myScanner.nextLine();
					System.out.println(wholeLine);
				
				}			
			}
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}
	
	public void save() {
		if(this.modified == true) {
			try {
				FileWriter myFile = new FileWriter(getSourceName());
				myFile.write(toString());
				myFile.close();
			}catch (IOException e) {
				System.out.println(e);
			}
		}

	}

	// Additional private helper methods go here:
	private String getSourceName() {
		return sourceName;
	}

}
