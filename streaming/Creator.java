package streaming;


import java.util.Arrays;

/*
Creator
	Field:
		int videoCount
	Constructor:
		Sets video count, calls super(...)
	Implements
		Streamable , Subscribable
	Overrides stream() — prints "Creator is publishing content."
	Overloads stream(String title) — prints: "Uploaded video: [title]"
	Overrides subscribe() — returns "Creator subscription tier: PRO"
	Method: getVideoStats() — prints number of uploaded videos
	Overrides checkCondition() :
	Calls super.checkCondition()
		Adds "Creator verified."
 */
public class Creator extends StreamUser implements Subscribable, Streamable {
	private int videoCount;

	Creator(String userId, String planType, boolean isSubscribed, int videoCount) {
		super(userId, planType, isSubscribed);
		this.videoCount = videoCount;
	}

	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}

	public int getVideoCount() {
		return videoCount;
	}

	@Override
	public void stream() {
		System.out.println("Creator is publishing content...");
	}

	@Override
	public String subscribe() {
		return "Creator subscription tier: PRO";
	}

	public void stream(String title) {
		System.out.println("Uploaded video: " + title);
	}

	public void getVideoStats() {
		System.out.println("Video count: " + videoCount);
	}

	@Override
	public void checkCondition() throws InvalidUserInfoException {
		super.checkCondition();
		System.out.println("Creator Verified");
	}

	@Override
	void displayInfo() {
		System.out.println("Creator Id" + userId + " with video count" + "\n" +
				videoCount);
	}
}
