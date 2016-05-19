package types;

import java.util.Date;

public class Appointment {

	private Integer AppointmentID;
	private Date Date;
	private Integer isDropIn;
	private Integer isAttented;
	private Integer ClientID;
	private Integer EmployeeID;

	public Appointment() {

	}

	public Appointment(Integer AppointmentID, Date Date, Integer isDropIn, Integer isAttented, Integer ClientID,
			Integer EmployeeID) {

		this.AppointmentID = AppointmentID;
		this.Date = Date;
		this.isDropIn = isDropIn;
		this.isAttented = isAttented;
		this.ClientID = ClientID;
		this.EmployeeID = EmployeeID;

	}

	public Integer getAppointmentID() {
		return AppointmentID;
	}

	public void setAppointmentID(Integer appointmentID) {
		AppointmentID = appointmentID;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Integer getIsDropIn() {
		return isDropIn;
	}

	public void setIsDropIn(Integer isDropIn) {
		this.isDropIn = isDropIn;
	}

	public Integer getIsAttented() {
		return isAttented;
	}

	public void setIsAttented(Integer isAttented) {
		this.isAttented = isAttented;
	}

	public Integer getClientID() {
		return ClientID;
	}

	public void setClientID(Integer clientID) {
		ClientID = clientID;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

}
