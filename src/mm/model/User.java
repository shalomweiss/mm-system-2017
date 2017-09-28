package mm.model;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber ;
	transient private String password ;
	private int gender;
	private String address;
	private String note;
	private String profilePicture;
	private boolean active;
	private userType type;
	
	public enum userType{
		ADMIN(0),TSOFEN(1),MENTOR(2),MENTEE(3);
		
		private final int value;
	    private userType(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	public User(){}
	public User(String firstName, String lastName, String email,
			String phoneNumber,String pass, int gender, String address, String note,
			String profilePicture, boolean active, userType type) {

		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password=pass;
		this.gender = gender;
		this.address = address;
		this.note = note;
		this.profilePicture = profilePicture;
		this.active = active;
		this.type = type;
	}


	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public User(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			int gender, String address, String note, String profilePicture, boolean active, userType type) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.note = note;
		this.active = active;
		this.profilePicture = profilePicture;
		this.type = type;
	}




	public userType getType() {
		return type;
	}




	public void setType(userType type) {
		this.type = type;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", gender=" + gender + ", address="
				+ address + ", note=" + note + ", active=" + active + ", type=" + type + "]";
	}



	
	
	
	

}
