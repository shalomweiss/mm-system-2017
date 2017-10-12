package mm.jsonModel;


import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import mm.model.Meeting;
import mm.model.Meeting.meetingStatus;
import mm.model.Meeting.meetingType;

/**
 * a model with only json object types. (replaced Time with String)
 * @author USER
 *
 */
public class MeetingModel 
{ 
 private int meetingId; 
 private int pairId;
 private int mentorId;
 private int menteeId;
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
 private String startingDate;
 private String endingDate;
 private boolean mentorComplete;
 private boolean menteeComplete;
 
 
 
 
public MeetingModel(int meetingId, int pairId, int mentorId, int menteeId, String note, meetingStatus status,
		String menteeReport, String mentorReport, String menteePrivateReport, String mentorPrivateReport,
		meetingType meetingType, String subject, String location, Long date, String startingDate,
		String endingDate, boolean mentorComplete, boolean menteeComplete) {
	super();
	this.meetingId = meetingId;
	this.pairId = pairId;
	this.mentorId = mentorId;
	this.menteeId = menteeId;
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


public Meeting toMeeting() {
	
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	java.util.Date startingDate = null;
    java.util.Date endingDate = null;
    try {
    	startingDate = sdf.parse(this.startingDate);
    	endingDate = sdf.parse(this.endingDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    Time timeStart = new Time(startingDate.getTime());
    Time timeEnd = new Time(endingDate.getTime());
	
	return new Meeting( meetingId,  pairId,  mentorId,  menteeId,  note,  status,
					 menteeReport,  mentorReport,  menteePrivateReport,  mentorPrivateReport,
			 meetingType,  subject,  location,  date,  timeStart,
			 timeEnd,  mentorComplete,  menteeComplete);
}

public MeetingModel() {}


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


public String getStartingDate() {
	return startingDate;
}


public void setStartingDate(String startingDate) {
	this.startingDate = startingDate;
}


public String getEndingDate() {
	return endingDate;
}


public void setEndingDate(String endingDate) {
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


@Override
public String toString() {
	return "Meeting [meetingId=" + meetingId + ", pairId=" + pairId
			+ ", mentorId=" + mentorId + ", menteeId=" + menteeId + ", note="
			+ note + ", status=" + status + ", menteeReport=" + menteeReport
			+ ", mentorReport=" + mentorReport + ", menteePrivateReport="
			+ menteePrivateReport + ", mentorPrivateReport="
			+ mentorPrivateReport + ", meetingType=" + meetingType
			+ ", subject=" + subject + ", location=" + location + ", date="
			+ date + ", startingDate=" + startingDate + ", endingDate="
			+ endingDate + ", mentorComplete=" + mentorComplete
			+ ", menteeComplete=" + menteeComplete + "]";
}
	
 
 
}
