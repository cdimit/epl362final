package types;

public class ClientCase {

	private Integer ClientCaseID;
	private Integer ClientID;
	private Integer CaseID;
	private Integer EmployeeID;

	public ClientCase() {

	}

	public ClientCase(Integer ClientCaseID, Integer ClientID, Integer CaseID, Integer EmployeeID) {

		this.ClientCaseID=ClientCaseID;
		this.ClientID=ClientID;
		this.CaseID=CaseID;
		this.EmployeeID=EmployeeID;
		
	}

	public Integer getClientCaseID() {
		return ClientCaseID;
	}

	public void setClientCaseID(Integer clientCaseID) {
		ClientCaseID = clientCaseID;
	}

	public Integer getClientID() {
		return ClientID;
	}

	public void setClientID(Integer clientID) {
		ClientID = clientID;
	}

	public Integer getCaseID() {
		return CaseID;
	}

	public void setCaseID(Integer caseID) {
		CaseID = caseID;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

}
