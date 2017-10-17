package tests;

import java.sql.SQLException;

import mm.da.DataAccess;

public class EditMeetingNoteTest {
	
	static DataAccess da = new DataAccess();
	
	public EditMeetingNoteTest(){
		super();
	}
	public static void main(String[] args){
		try {
			da.editMeetingNote(1, "Hello World!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
