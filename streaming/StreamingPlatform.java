package streaming;

import java.io.*;
import java.util.ArrayList;

/*
StreamingPlatform
	Fields:
		ArrayList<Viewer> viewers , ArrayList<Creator> creators
	Validation in all add/remove methods
	File I/O:
		logStream(String) → "streaming_log.txt"
		readLogs() — prints all
 */

public class StreamingPlatform {
	private ArrayList<Viewer> viewers = new ArrayList<>();
	private ArrayList<Creator>  creators = new ArrayList<>();

	public ArrayList<Creator> getCreators() {
		return creators;
	}

	public void setCreators(ArrayList<Creator> creators) {
		this.creators = creators;
	}

	public ArrayList<Viewer> getViewers() {
		return viewers;
	}

	public void setViewers(ArrayList<Viewer> viewers) {
		this.viewers = viewers;
	}

	public void addViewer(Viewer viewer) {
		if(!viewers.contains(viewer)) {
			viewers.add(viewer);
			return;
		}
		System.out.println("Viewer already exists");
	}

	public void addCreator(Creator creator) {
		if(!creators.contains(creator)) {
			creators.add(creator);
			return;
		}
		System.out.println("creator already exists");
	}

	public void removeViewer(Viewer viewer) {
		if(viewers.contains(viewer)) {
			viewers.remove(viewer);
			return;
		}
		System.out.println("viewer does not exist");
	}


	public void removeCreator(Creator creator) {
		if(creators.contains(creator)) {
			creators.remove(creator);
			return;
		}
		System.out.println("creator does not exist");
	}

	public void logStream(String log) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("streaming_log.txt", true));
		){
			bw.write(log);
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}


	public void readLogs() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("streaming_log.txt"));){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}
