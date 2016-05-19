package types;

import java.util.Date;

public class OfficeCase {

	private Integer CaseID;
	private String Name;
	private String Details;
	private Integer isClosed;
	private Date LastUpdated;
	private Integer EmployeeID;

	public OfficeCase() {

	}

	public OfficeCase(
			Integer CaseID, 
			String Name,
			String Details,
			Integer isClosed,
			Date LastUpdated,
			Integer EmployeeID) {

		this.CaseID=CaseID;
		this.Name=Name;
		this.Details=Details;
		this.isClosed=isClosed;
		this.LastUpdated=LastUpdated;
		this.EmployeeID=EmployeeID;
	}

	public Integer getCaseID() {
		return CaseID;
	}

	public void setCaseID(Integer caseID) {
		CaseID = caseID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public Integer getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Integer isClosed) {
		this.isClosed = isClosed;
	}

	public Date getLastUpdated() {
		return LastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		LastUpdated = lastUpdated;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

}
