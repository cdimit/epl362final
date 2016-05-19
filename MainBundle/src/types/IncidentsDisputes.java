package types;

public class IncidentsDisputes {

	private Integer IncidentDisputeID;
	private String Details;
	private Integer isIncident;

	public IncidentsDisputes() {

	}

	public IncidentsDisputes(Integer IncidentDisputeID, String Details, Integer isIncident) {

		this.IncidentDisputeID=IncidentDisputeID;
		this.Details=Details;
		this.isIncident=isIncident;
		
	}

	public Integer getIncidentDisputeID() {
		return IncidentDisputeID;
	}

	public void setIncidentDisputeID(Integer incidentDisputeID) {
		IncidentDisputeID = incidentDisputeID;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public Integer getIsIncident() {
		return isIncident;
	}

	public void setIsIncident(Integer isIncident) {
		this.isIncident = isIncident;
	}

}
