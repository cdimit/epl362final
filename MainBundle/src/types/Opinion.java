package types;

public class Opinion {

	private Integer OpinionID;
	private Integer EmployeeID;
	private Integer CaseID;
	private String Details;
	private Integer ClientCaseID;

	public Opinion() {

	}

	public Opinion(
			Integer OpinionID,
			Integer EmployeeID,
			Integer CaseID, 
			String Details,
			Integer ClientCaseID) {
		this.OpinionID=OpinionID;
		this.EmployeeID=EmployeeID;
		this.CaseID=CaseID;
		this.Details=Details;
		this.ClientCaseID=ClientCaseID;
		
		
	}

	public Integer getOpinionID() {
		return OpinionID;
	}

	public void setOpinionID(Integer opinionID) {
		OpinionID = opinionID;
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

	public Integer getClientCaseID() {
		return ClientCaseID;
	}

	public void setClientCaseID(Integer clientCaseID) {
		ClientCaseID = clientCaseID;
	}

}
