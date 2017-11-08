package mm.model;

public class AcademicInstitute {
	private int id;
	private String name;
	private String area;
	private int areaId;
	private String city;
	private int cityId;
	
	
	public AcademicInstitute(int id, String name, String area, String city, int areaId, int cityId) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.city = city;
		this.setAreaId(areaId);
		this.setCityId(cityId);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	@Override
	public String toString() {
		return "AcademicInstitute [id=" + id + ", name=" + name + ", area=" + area + ", city=" + city + "]";
	}


	public int getAreaId() {
		return areaId;
	}


	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}
