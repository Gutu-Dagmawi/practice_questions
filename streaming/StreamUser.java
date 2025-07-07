package streaming;


/*
 Abstract Class StreamUser :
	Fields:
		String userId ,
		String planType ,
		boolean isSubscribed
	Constructor:
		Initializes all fields
	Abstract Method:
		void displayInfo()
	Concrete Method:
		void checkCondition()
		Throws an InvalidUserInfoException if userId == null or planType == null
		 Else prints "Streaming access granted." if isSubscribed == true
 */
public abstract class StreamUser {
	protected String userId;
	protected String planType;
	protected boolean isSubscribed;

	StreamUser(String userId, String planType, boolean isSubscribed) {
		this.userId = userId;
		this.planType = planType;
		this.isSubscribed = isSubscribed;
	}

	abstract void displayInfo();

	public void checkCondition() throws InvalidUserInfoException{
		if (this.userId == null || this.planType == null) throw new InvalidUserInfoException("user id or plan type is null");
		if(isSubscribed) {
			System.out.println("User " + userId + " subscription is granted");
		}

	}
}
