package generalServices;

import java.util.Date;

import javax.swing.DefaultListModel;

import types.Appointment;
import types.Branch;
import types.ChangeInformation;
import types.Client;
import types.ClientCase;
import types.Consultation;
import types.Employee;
import types.IncidentsDisputes;
import types.OfficeCase;
import types.Opinion;
import types.Recommendation;
import types.WarningMessages;

/**
 * This is the Interface which contains all the methods that can be called from the consumer.
 * If a method is not here then the consumer can't call it.
 */

public interface IServices {

	public Employee GET_EMPLOYEE(String USERNAME, String PASSWORD);

	public DefaultListModel<Client> GET_ALL_CLIENTS();

	public boolean DELETE_CLIENT(Integer client_id);

	public boolean INSERT_CLIENT(Integer NationalID, String FirstName, String LastName, String BirthDate, boolean Sex,
			String Tel, String Nationality, String Country, String City, String PostCode, String Street,
			String Comments, boolean hasIllegal , Integer isDeleted);

	public boolean INSERT_BRANCH(String NAME, String COUNTRY, String CITY,String POSTCODE,
			String STREET, String TEL);
	
	public boolean INSERT_CHANGE_INFORMATION(Integer EMPLOYEE_ID,Integer CLIENT_ID ,
			String CHANGE_DATE,Integer DIDCHANGED,Integer ISCLIENTREQUEST);
	
	public boolean INSERT_CLIENT_CASE(Integer CLIENT_ID,Integer CASE_ID, Integer EMPLOYEE_ID);
	
	public boolean INSERT_CONSULTATION(Integer CLIENT_ID,Integer CASE_ID,String DETAILS,
			String CONSULTATION_DATE,Integer WENT,Integer ISDROPIN, Integer CLIENT_CASE_ID);
	
	public boolean INSERT_INCIDENT_DISPUTES(String DETAILS,Integer IS_INCIDENT);
	
	public boolean INSERT_OFFICE_CASE(Integer CLIENT_ID,String NAME,String DETAILS,boolean IS_INCIDENT,
			String LAST_UPDATED,Integer EMPLOYEE_ID );
	
	public boolean INSERT_OPINION(Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID );
	
	public boolean INSERT_RECOMMENDATION(Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID );
	
	public boolean INSERT_WARNING_MESSAGES(Integer EMPLOYEE_ID,	String MESSAGE );
	
	public boolean INSERT_APPOINTMENT(String DATE, 
			Integer IS_DROP_IN, Integer IS_ATTENTED,Integer CLIENT_ID,
			Integer EMPLOYEE_ID);
	
	
	
	
	public boolean UPDATE_CLIENT(Integer ClientID,Integer NationalID, String FirstName, String LastName, String BirthDate, boolean Sex,
			String Tel, String Nationality, String Country, String City, String PostCode, String Street,
			String Comments, boolean hasIllegal , Integer isDeleted);
	
	public boolean UPDATE_BRANCH(Integer BRANCH_ID,String NAME, String COUNTRY, String CITY,String POSTCODE,
			String STREET, String TEL);
	
	public boolean UPDATE_CHANGE_INFORMATION(Integer CHANGE_ID,Integer EMPLOYEE_ID,Integer CLIENT_ID ,
			String CHANGE_DATE,Integer DIDCHANGED,Integer ISCLIENTREQUEST);
	
	public boolean UPDATE_CLIENT_CASE(Integer CLIENT_CASE_ID,Integer CLIENT_ID,Integer CASE_ID, Integer EMPLOYEE_ID);
	
	public boolean UPDATE_CONSULTATION(Integer CONSULTATION_ID,Integer CLIENT_ID,Integer CASE_ID,String DETAILS,
			String CONSULTATION_DATE,Integer WENT,Integer ISDROPIN, Integer CLIENT_CASE_ID);
	
	public boolean UPDATE_INCIDENT_DISPUTES(Integer INCIDENT_DISPUTE_ID,String DETAILS,Integer IS_INCIDENT);
	
	public boolean UPDATE_OFFICE_CASE(Integer CASE_ID,Integer CLIENT_ID,String NAME,String DETAILS,
			Boolean IS_INCIDENT,String LAST_UPDATED,Integer EMPLOYEE_ID ) ;
	
	public boolean UPDATE_OPINION(Integer OPINION_ID,Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID );
	
	public boolean UPDATE_RECOMMENDATION(Integer RECOMMENDATION_ID,Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID );
	
	public boolean UPDATE_WARNING_MESSAGES(Integer WARNING_MESSAGE_ID,Integer EMPLOYEE_ID,	String MESSAGE );
	
	public boolean UPDATE_APPOINTMENT(Integer APPOINTMENT_ID,String DATE, 
			Integer IS_DROP_IN, Integer IS_ATTENTED,Integer CLIENT_ID,
			Integer EMPLOYEE_ID);
	
	
	
	
	public Branch GET_BRANCH(Integer BRANCH_ID);
	
	public ChangeInformation GET_CHANGE_INFORMATION(Integer CHANGE_ID);
	
	public Client GET_CLIENT(Integer CLIENT_ID);
	
	public ClientCase GET_CLIENT_CASE(Integer CLIENT_CASE_ID);
	
	public Consultation GET_CONSULTATION(Integer CONSULTATION_ID);
	
	public IncidentsDisputes GET_INCIDENTS_DISPUTES(Integer INCIDENT_DISPUTE_ID);
	
	public OfficeCase GET_OFFICE_CASE(Integer CASE_ID);
	
	public Opinion GET_OPINION(Integer OPINION_ID);
	
	public Recommendation GET_RECOMMENDATION(Integer RECOMMENDATION_ID);
	
	public WarningMessages GET_WARNING_MESSAGES(Integer WARNING_MESSAGE_ID);
	
	
	public Appointment GET_APPOINTMENT(Integer APPOINTMENT_ID);

	
	
	
	
	
	public DefaultListModel<Branch> LIST_BRANCH();
	
	public DefaultListModel<ChangeInformation> LIST_CHANGE_INFORMATION();
	
	public DefaultListModel<ClientCase> LIST_CLIENT_CASE();
	
	public DefaultListModel<Consultation> LIST_CONSULTATION();
	
	public DefaultListModel<IncidentsDisputes> LIST_INCIDENTS_DISPUTES();
	
	public DefaultListModel<OfficeCase> LIST_OFFICE_CASE();
	
	public DefaultListModel<Opinion> LIST_OPINION();
	
	public DefaultListModel<Recommendation> LIST_RECOMMENDATION();
	
	public DefaultListModel<WarningMessages> LIST_WARNING_MESSAGES();
	
	public DefaultListModel<Appointment> LIST_APPOINTMENT();

	
	
	
	
	public boolean DELETE_BRANCH(Integer BRANCH_ID);
	
	public boolean DELETE_CHANGE_INFORAMTION(Integer CHANGE_ID);
	
	public boolean DELETE_CLIENT_CASE(Integer CLIENT_CASE_ID);
	
	public boolean DELETE_CONSULTATION(Integer CONSULTATION_ID);
	
	public boolean DELETE_EMPLOYEE(Integer EMPLOYEE_ID);
	
	public boolean DELETE_INCIDENTS_DISPUTES(Integer INCIDENT_DISPUTE_ID);
	
	public boolean DELETE_OFFICE_CASE(Integer CASE_ID);
	
	public boolean DELETE_OPINION(Integer OPINION_ID);
	
	public boolean DELETE_RECOMMENDATION(Integer RECOMMENDATION_ID);
	
	public boolean DELETE_WARNING_MESSAGES(Integer WARNING_MESSAGE_ID);
	
	public boolean DELETE_APPOINTMENT(Integer APPOINTMENT_ID);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
