package types;

public class Branch {

	private Integer BranchID;
	private String Name;
	private String Country;
	private String City;
	private String PostCode;
	private String Street;
	private String Tel;
	
	public Branch(){
		
	}
	
	public Branch(Integer branchid,String name,String country,String city,String postcode,
			String street,String tel){
		this.BranchID=branchid;
		this.Name=name;
		this.Country=country;
		this.City=city;
		this.PostCode=postcode;
		this.Street=street;
		this.Tel=tel;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPostCode() {
		return PostCode;
	}
	public void setPostCode(String postCode) {
		PostCode = postCode;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}

	public Integer getBranchID() {
		return BranchID;
	}

	public void setBranchID(Integer branchID) {
		BranchID = branchID;
	}
	
	
	
}
