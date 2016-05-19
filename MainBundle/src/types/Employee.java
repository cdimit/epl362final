package types;

public class Employee {

	private Integer EmployeeID;
	private Integer NationalID;
	private String FirstName;
	private String LastName;
	private String Birthday;
	private String Sex;
	private String Tel;
	private String Nationality;
	private String Country;
	private String City;
	private String PostCode;
	private String Street;
	private String Role;
	private String Username;
	private String Password;

	public Employee() {

	}

	public Employee(Integer EmployeeID, Integer NationalID, String FirstName, String LastName, String Birthday,
			String Sex, String Tel, String Nationality, String Country, String City, String PostCode, String Street,
			String Role, String Username, String Password) {
		
		  this.EmployeeID=EmployeeID;
		  this.NationalID=NationalID;
		  this.FirstName=FirstName;
		  this.LastName=LastName;
		  this.Birthday=Birthday;
		  this.Sex=Sex;
		  this.Tel=Tel;
		  this.Nationality=Nationality;
		  this.Country=Country;
		  this.City=City;
		  this.PostCode=PostCode;
		  this.Street=Street;
		  this.Role=Role;
		  this.Username=Username;
		  this.Password=Password;
		
		

	}

	
	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public Integer getNationalID() {
		return NationalID;
	}

	public void setNationalID(Integer nationalID) {
		NationalID = nationalID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
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

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
