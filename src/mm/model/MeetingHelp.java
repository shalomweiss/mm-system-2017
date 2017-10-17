package mm.model;


import java.sql.Time;
import java.util.Date;

public class MeetingHelp extends Meeting{
	private Date dateMeeting;

	public MeetingHelp(int meetingId, int pairId, int mentorId, int menteeId,
			String note, meetingStatus status, String menteeReport,
			String mentorReport, String menteePrivateReport,
			String mentorPrivateReport,
			mm.model.Meeting.meetingType meetingType, String subject,
			String location, Long date, Time startingDate, Time endingDate,
			boolean mentorComplete, boolean menteeComplete, Date dateMeeting) {
		super(meetingId, pairId, mentorId, menteeId, note, status,
				menteeReport, mentorReport, menteePrivateReport,
				mentorPrivateReport, meetingType, subject, location, date,
				startingDate, endingDate, mentorComplete, menteeComplete);
		this.dateMeeting = dateMeeting;
	}


	public Date getDateMeeting() {
		return dateMeeting;
	}

	public void setDateMeeting(Date dateMeeting) {
		this.dateMeeting = dateMeeting;
	}

	@Override
	public String toString() {
		return "MeetingHelp [dateMeeting=" + dateMeeting
				+ ", getDateMeeting()=" + getDateMeeting() + ", getMentorId()="
				+ getMentorId() + ", getMenteeId()=" + getMenteeId()
				+ ", getMeetingId()=" + getMeetingId() + ", getNote()="
				+ getNote() + ", getStatus()=" + getStatus()
				+ ", getMenteeReport()=" + getMenteeReport()
				+ ", getMentorReport()=" + getMentorReport()
				+ ", getMenteePrivateReport()=" + getMenteePrivateReport()
				+ ", getMentorPrivateReport()=" + getMentorPrivateReport()
				+ ", getMeetingType()=" + getMeetingType() + ", getSubject()="
				+ getSubject() + ", getLocation()=" + getLocation()
				+ ", getDate()=" + getDate() + ", getStartingDate()="
				+ getStartingDate() + ", getEndingDate()=" + getEndingDate()
				+ ", getMentorComplete()=" + getMentorComplete()
				+ ", getMenteeComplete()=" + getMenteeComplete()
				+ ", getPairId()=" + getPairId() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
    
	
	

	
	

}
