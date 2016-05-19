package types;

public class Recommendation {

	private Integer RecommendationID;
	private Integer EmployeeID;
	private Integer CaseID;
	private String Details;
	private Integer ClientCaseID;

	public Recommendation() {

	}

	public Recommendation(
			Integer RecommendationID,
			Integer EmployeeID,
			Integer CaseID, 
			String Details,
			Integer ClientCaseID) {

		this.RecommendationID=RecommendationID;
		this.EmployeeID=EmployeeID;
		this.CaseID=CaseID;
		this.Details=Details;
		this.ClientCaseID=ClientCaseID;
		
	}

	public Integer getRecommendationID() {
		return RecommendationID;
	}

	public void setRecommendationID(Integer recommendationID) {
		RecommendationID = recommendationID;
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
