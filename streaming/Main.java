package streaming;


import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

/*
	 MainApp:
		- Interface-based polymorphism
		- Downcasting for extra methods
		- overriding + overloading
		"streaming_log.txt" file operations
		Exception handling
 */
public class Main {
	public static void main(String[] args) {
//		ArrayList<String> streamList = new ArrayList<String>();
//		streamList.add("Breaking Bad");
//		streamList.add("Game of Thrones");
		StreamUser user1 = new Viewer("VW-001", "Monthly",
				true, new ArrayList<>()
		);

		StreamUser user2 = new Creator("CR-001", "Pro", true, 4);

		try {
			user1.checkCondition();
		} catch (InvalidUserInfoException e) {
			System.out.println(e.getMessage());
		}
		try {
			user2.checkCondition();
		} catch (InvalidUserInfoException e) {
			System.out.println(e.getMessage());
		}

		Viewer viewer = (Viewer) user1;
		Creator creator = (Creator) user2;

		viewer.stream();
		viewer.stream("Romance");

		creator.stream();
		creator.stream("Friends");

		StreamingPlatform netflix = new StreamingPlatform();
		netflix.addCreator(creator);
		netflix.addViewer(viewer);

		try {
			netflix.logStream("Some log here...");
			netflix.logStream("Second log here...");
			netflix.readLogs();

		} catch (IOException e) {
			System.out.println(e.getMessage());;
		}

	}
}