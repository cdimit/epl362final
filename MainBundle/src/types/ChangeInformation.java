package types;

import java.util.Date;

public class ChangeInformation {

	private Integer ChangeID;
	private Integer EmployeeID;
	private Integer ClientID;
	private Date ChangeDate;
	private Integer didChanged;
	private Integer isClientRequest;

	public ChangeInformation() {

	}

	public ChangeInformation(Integer ChangeID, Integer EmployeeID, Integer ClientID, Date ChangeDate,
			Integer didChanged, Integer isClientRequest) {
		
		this.ChangeID=ChangeID;
		this.EmployeeID=EmployeeID;
		this.ClientID=ClientID;
		this.ChangeDate=ChangeDate;
		this.didChanged=didChanged;
		this.isClientRequest=isClientRequest;
		

	}

	public Integer getChangeID() {
		return ChangeID;
	}

	public void setChangeID(Integer changeID) {
		ChangeID = changeID;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public Integer getClientID() {
		return ClientID;
	}

	public void setClientID(Integer clientID) {
		ClientID = clientID;
	}

	public Date getChangeDate() {
		return ChangeDate;
	}

	public void setChangeDate(Date changeDate) {
		ChangeDate = changeDate;
	}

	public Integer getDidChanged() {
		return didChanged;
	}

	public void setDidChanged(Integer didChanged) {
		this.didChanged = didChanged;
	}

	public Integer getIsClientRequest() {
		return isClientRequest;
	}

	public void setIsClientRequest(Integer isClientRequest) {
		this.isClientRequest = isClientRequest;
	}

}
