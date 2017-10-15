package mm.model;

import java.util.ArrayList;

public class PairDetails {
	Pair pair;
	ArrayList<Meeting> meetings;
	
	public PairDetails(){}

	public Pair getPair() {
		return pair;
	}

	public void setPair(Pair pair) {
		this.pair = pair;
	}

	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
	}
	
}
