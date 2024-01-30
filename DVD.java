public class DVD {

	// Fields:

	private String title;		// Title of this DVD
	private String rating;		// Rating of this DVD
	private int runningTime;	// Running time of this DVD in minutes

	public DVD(String dvdTitle, String dvdRating, int dvdRunningTime) 
	{
		this.title = dvdTitle;
		this.rating = dvdRating;
		this.runningTime = dvdRunningTime;
	}
	
	public String getTitle() 
	{

		return title;	// STUB: Remove this line.
	}
	
	public String getRating() 
	{

		return rating;	// STUB: Remove this line.
	}
	
	public int getRunningTime() 
	{
		return runningTime;	// STUB: Remove this line.
	}

	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	public void setRating(String newRating) {
		this.rating = newRating;
	}

	public void setRunningTime(int newRunningTime) {
		this.runningTime = newRunningTime;

	}

	public String toString() {
		return title + "/" + rating + "/" + runningTime + "min" + '\n';
		
	}
	
	
}
