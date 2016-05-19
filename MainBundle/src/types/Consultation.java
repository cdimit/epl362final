package types;

import java.util.Date;

public class Consultation {

	private Integer ConsultationID;
	private Integer EmployeeID;
	private Integer CaseID;
	private String Details;
	private Date ConsultationDate;
	private Integer Went;
	private Integer isDropin;
	private Integer ClientCaseID;

	public Consultation() {

	}

	public Consultation(Integer ConsultationID, Integer EmployeeID, Integer CaseID, String Details,
			Date ConsultationDate, Integer Went, Integer isDropin, Integer ClientCaseID) {

		this.ConsultationID=ConsultationID;
		this.EmployeeID=EmployeeID;
		this.CaseID=CaseID;
		this.Details=Details;
		this.ConsultationDate=ConsultationDate;
		this.Went=Went;
		this.isDropin=isDropin;
		this.ClientCaseID=ClientCaseID;
		
		
	}

	public Integer getConsultationID() {
		return ConsultationID;
	}

	public void setConsultationID(Integer consultationID) {
		ConsultationID = consultationID;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public Integer getCaseID() {
		return CaseID;
	}

	public void setCaseID(Integer caseID) {
		CaseID = caseID;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public Date getConsultationDate() {
		return ConsultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		ConsultationDate = consultationDate;
	}

	public Integer getWent() {
		return Went;
	}

	public void setWent(Integer went) {
		Went = went;
	}

	public Integer getIsDropin() {
		return isDropin;
	}

	public void setIsDropin(Integer isDropin) {
		this.isDropin = isDropin;
	}

	public Integer getClientCaseID() {
		return ClientCaseID;
	}

	public void setClientCaseID(Integer clientCaseID) {
		ClientCaseID = clientCaseID;
	}

}
