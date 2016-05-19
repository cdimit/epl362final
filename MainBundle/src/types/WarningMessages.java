package types;

public class WarningMessages {

	private Integer WarningMessageID;
	private Integer EmployeeID;
	private String Message;

	public WarningMessages() {

	}

	public WarningMessages(Integer WarningMessageID, Integer EmployeeID, String Message) {
		this.WarningMessageID=WarningMessageID;
		this.EmployeeID=EmployeeID;
		this.Message=Message;
	}

	public Integer getWarningMessageID() {
		return WarningMessageID;
	}

	public void setWarningMessageID(Integer warningMessageID) {
		WarningMessageID = warningMessageID;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
