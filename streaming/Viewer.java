package streaming;


import java.util.ArrayList;
import java.util.Arrays;

/*
Viewer
	Field:
		ArrayList<String> watchlist
	Constructor:
		Initializes list, calls super(...)
	Implements Streamable , Subscribable
	Overrides stream() — prints: "Viewer is streaming content."
	Overloads stream(String genre) — adds genre to watchlist, prints genre
	Overrides subscribe() — returns "Subscribed to: [planType]"
	Method: viewWatchlist() — prints all genres watched
	Overrides checkCondition() :
		Calls super.checkCondition()
		Adds "Viewer validated."
 */
public class Viewer extends StreamUser implements Streamable, Subscribable{
	private ArrayList<String> watchlist;

	Viewer(String userId, String planType, boolean isSubscribed ,ArrayList<String> watchlist) {
		super(userId, planType, isSubscribed);
		this.watchlist = watchlist;
	}



	public ArrayList<String> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(ArrayList<String> watchlist) {
		this.watchlist = watchlist;
	}

	@Override
	public void stream(){
		System.out.println("User " + userId + " is streaming content");
	}

	public void stream(String genre){
		watchlist.add(genre);
		System.out.println("User " + userId + " is streaming" + genre);
	}

	@Override
	public String subscribe() {
		return "Subscribed to: " + planType;
	}

	public void viewWatchlist(){
		if(watchlist.isEmpty()) {
			System.out.println("No watchlist available");
			return;
		}
		System.out.println("User " + userId + " is viewing watchlist: ");
		for(String watch : watchlist){
			System.out.println(watch);
		}
	}

	@Override
	public void checkCondition() throws InvalidUserInfoException{
		super.checkCondition();
		System.out.println("Viewer Id " + userId + " is validated");
	}

	@Override
	void displayInfo(){
		System.out.println("Viewer Id: " + userId + " with watchlist: " + "\n" +
				Arrays.toString(watchlist.toArray()));
	}

}
