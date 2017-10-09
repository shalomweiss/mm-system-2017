package mm.model;

public class WorkPlace {

	private int id;
	private String company;
	private String area;
	private String city;
	private String address;

	
	public WorkPlace(int id, String company, String area, String city, String address) {
		super();
		this.id = id;
		this.company = company;
		this.area = area;
		this.city = city;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "WorkPlace [id=" + id + ", company=" + company + ", area=" + area + ", city=" + city + ", address="
				+ address + "]";
	}

	
}
