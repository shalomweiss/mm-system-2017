package mm.jsonModel;


import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

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
 private Long startingDate;
 private Long endingDate;
 private boolean mentorComplete;
 private boolean menteeComplete;
 
 
 
 
public MeetingModel(int meetingId, int pairId, int mentorId, int menteeId, String note, meetingStatus status,
		String menteeReport, String mentorReport, String menteePrivateReport, String mentorPrivateReport,
		meetingType meetingType, String subject, String location, Long date, Long startingDate,
		Long endingDate, boolean mentorComplete, boolean menteeComplete) {
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


public static MeetingModel fromMeeting(Meeting meeting) {

	return new MeetingModel(meeting.getMeetingId(),meeting.getPairId(),meeting.getMentorId(),meeting.getMenteeId(),meeting.getNote(),meeting.getStatus(),meeting.getMenteeReport(),meeting.getMentorReport(),meeting.getMenteePrivateReport(),meeting.getMentorPrivateReport(),meeting.getMeetingType(),meeting.getSubject(),meeting.getLocation(),meeting.getStartingDate().getTime(),meeting.getStartingDate().getTime(),meeting.getEndingDate().getTime(),meeting.getMentorComplete(),meeting.getMentorComplete());
	
}

public Meeting toMeeting(int mentorIdToSend,int pairIdToSend) {
	

	java.util.Date startingDate = null;
    java.util.Date endingDate = null;

    	startingDate = new Date(this.startingDate);
    	endingDate = new Date(this.endingDate);
 
    Time timeStart = new Time(startingDate.getTime());
    Time timeEnd = new Time(endingDate.getTime());
    
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timeStart.getTime());


    /**
     * optional parameters
     */
//    -mentorComplete - boolean
//    -menteeComplete - boolean
//    -menteeReport
//    -mentorReport
//    -menteePrivateReport
//    -mentorPrivateReport
//    -location
//    -note
    //date
    
    
    meetingStatus statusToSend = meetingStatus.PENDING;
    String menteeReportToSend = "";
    String mentorReportToSend = "";
    String menteePrivateReportToSend = "";
    String mentorPrivateReportToSend = "";
    String locationToSend = "";
    String noteToSend = "";

    
    
    if(this.status==null) {
    	this.status=statusToSend;
    }
    if(this.getMenteeReport()!=null){
    	menteeReportToSend=this.getMenteeReport();
    }
    if(this.getMentorReport()!=null){
    	mentorReportToSend=this.getMenteeReport();
    }
    if(this.getMenteeReport()!=null){
    	menteePrivateReportToSend=this.getMenteePrivateReport();
    }
    if(this.getMenteeReport()!=null){
    	mentorPrivateReportToSend=this.getMenteePrivateReport();
    }
    if(this.getLocation()!=null){
    	locationToSend=this.getLocation();
    }
    if(this.getNote()!=null){
    	noteToSend=this.getNote();
    }
	return new Meeting( meetingId,  pairIdToSend,  mentorIdToSend,  menteeId,  noteToSend,  status,
			menteeReportToSend,  mentorReportToSend,  menteePrivateReportToSend,  mentorPrivateReportToSend,
			 meetingType,  subject,  locationToSend,  timeStart.getTime(),  timeStart,
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


public Long getStartingDate() {
	return startingDate;
}


public void setStartingDate(Long startingDate) {
	this.startingDate = startingDate;
}


public Long getEndingDate() {
	return endingDate;
}


public void setEndingDate(Long endingDate) {
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
