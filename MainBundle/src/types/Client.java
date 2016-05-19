package types;

import java.util.Date;

public class Client {

	private Integer ClientID;
	private Integer NationalID;
	private String FirstName;
	private String LastName;
	private Date BirthDate;
	private Integer Sex;
	private String Tel;
	private String Nationality;
	private String Country;
	private String City;
	private String PostCode;
	private String Street;
	private String Comments;
	private Integer hasIllegal;
	private Integer isDeleted;

	public Client() {

	}

	public Client(Integer ClientID, Integer NationalID, String FirstName, String LastName, Date BirthDate, Integer Sex,
			String Tel, String Nationality, String Country, String City, String PostCode, String Street,
			String Comments, Integer hasIllegal, Integer isDeleted) {

		this.ClientID = ClientID;
		this.NationalID = NationalID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.BirthDate = BirthDate;
		this.Sex = Sex;
		this.Tel = Tel;
		this.Nationality = Nationality;
		this.Country = Country;
		this.City = City;
		this.PostCode = PostCode;
		this.Street = Street;
		this.Comments = Comments;
		this.hasIllegal = hasIllegal;
		this.isDeleted = isDeleted;

	}

	public Integer getClientID() {
		return ClientID;
	}

	public void setClientID(Integer clientID) {
		ClientID = clientID;
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

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public Integer getSex() {
		return Sex;
	}

	public void setSex(Integer sex) {
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

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public Integer getHasIllegal() {
		return hasIllegal;
	}

	public void setHasIllegal(Integer hasIllegal) {
		this.hasIllegal = hasIllegal;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

}
