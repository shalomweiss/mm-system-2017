package mm.model;

import java.sql.Time;

public class Meeting 
{
 private int mentorId;
 private int menteeId;
 private int meetingId;
 private int pairId;
 private String note;
 private meetingStatus status;
 private String menteeReport;
 private String mentorReport;
 private String menteePrivateReport;
 private String mentorPrivateReport;
 private meetingType meetingType;
 private String subject;
 private String location;
 private Long date;
 private Time startingDate;
 private Time endingDate;
 private Boolean mentorComplete;
 private Boolean menteeComplete;
 
 
 
 public enum meetingType{
	 PHONE(0),FACE_TO_FACE(1),MESSAGE(2);	 
	 
		private final int value;
	    private meetingType(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
 }

 public enum meetingStatus{
	 PENDING,APPROVED,COMPLETE
 }

public Meeting(int mentorId, int menteeId, int meetingId, int pairId, String note, meetingStatus status, String menteeReport,
		String mentorReport, String menteePrivateReport, String mentorPrivateReport,
		mm.model.Meeting.meetingType meetingType, String subject, String location, Long date, Time startingDate,
		Time endingDate, Boolean mentorComplete, Boolean menteeComplete) {
	super();
	this.mentorId = mentorId;
	this.menteeId = menteeId;
	this.meetingId = meetingId;
	this.pairId = pairId;
	this.note = note;
	this.status = status;
	this.menteeReport = menteeReport;
	this.mentorReport = mentorReport;
	this.menteePrivateReport = menteePrivateReport;
	this.mentorPrivateReport = mentorPrivateReport;
	this.meetingType = meetingType;
	this.subject = subject;
	this.location = location;
	this.date = date;
	this.startingDate = startingDate;
	this.endingDate = endingDate;
	this.mentorComplete = mentorComplete;
	this.menteeComplete = menteeComplete;
}


public int getMentorId() {
	return mentorId;
}


public void setMentorId(int mentorId) {
	this.mentorId = mentorId;
}


public int getMenteeId() {
	return menteeId;
}


public void setMenteeId(int menteeId) {
	this.menteeId = menteeId;
}


public int getMeetingId() {
	return meetingId;
}


public void setMeetingId(int meetingId) {
	this.meetingId = meetingId;
}


public String getNote() {
	return note;
}


public void setNote(String note) {
	this.note = note;
}


public meetingStatus getStatus() {
	return status;
}


public void setStatus(meetingStatus status) {
	this.status = status;
}


public String getMenteeReport() {
	return menteeReport;
}


public void setMenteeReport(String menteeReport) {
	this.menteeReport = menteeReport;
}


public String getMentorReport() {
	return mentorReport;
}


public void setMentorReport(String mentorReport) {
	this.mentorReport = mentorReport;
}


public String getMenteePrivateReport() {
	return menteePrivateReport;
}


public void setMenteePrivateReport(String menteePrivateReport) {
	this.menteePrivateReport = menteePrivateReport;
}


public String getMentorPrivateReport() {
	return mentorPrivateReport;
}


public void setMentorPrivateReport(String mentorPrivateReport) {
	this.mentorPrivateReport = mentorPrivateReport;
}


public meetingType getMeetingType() {
	return meetingType;
}


public void setMeetingType(meetingType meetingType) {
	this.meetingType = meetingType;
}


public String getSubject() {
	return subject;
}


public void setSubject(String subject) {
	this.subject = subject;
}


public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}


public Long getDate() {
	return date;
}


public void setDate(Long date) {
	this.date = date;
}


public Time getStartingDate() {
	return startingDate;
}


public void setStartingDate(Time startingDate) {
	this.startingDate = startingDate;
}


public Time getEndingDate() {
	return endingDate;
}


public void setEndingDate(Time endingDate) {
	this.endingDate = endingDate;
}


public Boolean getMentorComplete() {
	return mentorComplete;
}


public void setMentorComplete(Boolean mentorComplete) {
	this.mentorComplete = mentorComplete;
}


public Boolean getMenteeComplete() {
	return menteeComplete;
}


public void setMenteeComplete(Boolean menteeComplete) {
	this.menteeComplete = menteeComplete;
}


public int getPairId() {
	return pairId;
}


public void setPairId(int pairId) {
	this.pairId = pairId;
}
	
 
 
}
