package generalServices;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.DocFlavor.STRING;
import javax.swing.DefaultListModel;

import types.*;

/**
 * This is the Services class which contains all the services that correspond to a specific
 * SP in the DB. Each method is used in a viewpoint. The services extend an Interface which
 * contains the prototypes of the methods that can be called from the consumer.
 */


public class Services implements IServices {

	private Connection con;

	public Services() {
		DBConnector dbc = new DBConnector();
		this.con = dbc.getNewConnection();
	}

	public Connection getConnection() {
		try {
			System.out.println(con.getMetaData().getURL().toString());
			System.out.println(con.getMetaData().getUserName().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.con;
	}
	//INSERT METHODS
	public boolean INSERT_CLIENT(Integer NationalID, String FirstName, String LastName, String BirthDate, boolean Sex,
			String Tel, String Nationality, String Country, String City, String PostCode, String Street,
			String Comments, boolean hasIllegal , Integer isDeleted) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_CLIENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			int sexi=0;
			int hasIllegali=0;
			if(Sex){
				sexi=1;
			}
			if(hasIllegal){
				hasIllegali=1;
			}
			
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(BirthDate);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, NationalID);
			cstmt.setString(2, FirstName);
			cstmt.setString(3, LastName);
			cstmt.setDate(4,  sqlDate);
			cstmt.setInt(5, sexi);
			cstmt.setString(6, Tel);
			cstmt.setString(7, Nationality);
			cstmt.setString(8, Country);
			cstmt.setString(9, City);
			cstmt.setString(10, PostCode);
			cstmt.setString(11, Street);
			cstmt.setString(12, Comments);
			cstmt.setInt(13, hasIllegali);
			cstmt.setInt(14, isDeleted);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_BRANCH(String NAME, String COUNTRY, String CITY,String POSTCODE,
			String STREET, String TEL) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_BRANCH(?,?,?,?,?,?)}");
					
			cstmt.setString(1, NAME);
			cstmt.setString(2, COUNTRY);
			cstmt.setString(3, CITY);
			cstmt.setString(4,  POSTCODE);
			cstmt.setString(5, STREET);
			cstmt.setString(6, TEL);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_CHANGE_INFORMATION(Integer EMPLOYEE_ID,Integer CLIENT_ID ,
			String CHANGE_DATE,Integer DIDCHANGED,Integer ISCLIENTREQUEST) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_CHANGE_INFORMATION(?,?,?,?,?)}");
				
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(CHANGE_DATE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, EMPLOYEE_ID);
			cstmt.setInt(2, CLIENT_ID);
			cstmt.setDate(3, sqlDate);
			cstmt.setInt(4,  DIDCHANGED);
			cstmt.setInt(5, ISCLIENTREQUEST);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	public boolean INSERT_CLIENT_CASE(Integer CLIENT_ID,Integer CASE_ID, Integer EMPLOYEE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_CLIENT_CASE(?,?,?)}");
					
			cstmt.setInt(1, CLIENT_ID);
			cstmt.setInt(2, CASE_ID);
			cstmt.setInt(3, EMPLOYEE_ID);
			
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_CONSULTATION(Integer CLIENT_ID,Integer CASE_ID,String DETAILS,
			String CONSULTATION_DATE,Integer WENT,Integer ISDROPIN, Integer CLIENT_CASE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_CONSULTATION(?,?,?,?,?,?,?)}");
					
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(CONSULTATION_DATE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, CLIENT_ID);
			cstmt.setInt(2, CASE_ID);
			cstmt.setString(3, DETAILS);
			cstmt.setDate(4, sqlDate);
			cstmt.setInt(5, WENT);
			cstmt.setInt(6, ISDROPIN);
			cstmt.setInt(7, CLIENT_CASE_ID);
			
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_INCIDENT_DISPUTES(String DETAILS,Integer IS_INCIDENT) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_INCIDENTS_DISPUTES(?,?)}");
					
			
			cstmt.setString(1, DETAILS);
			cstmt.setInt(2, IS_INCIDENT);
			
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_OFFICE_CASE(Integer CLIENT_ID,String NAME,String DETAILS,boolean IS_INCIDENT,
			String LAST_UPDATED,Integer EMPLOYEE_ID ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_OFFICE_CASE(?,?,?,?,?,?)}");
			
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(LAST_UPDATED);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, CLIENT_ID);
			cstmt.setString(2, NAME);
			cstmt.setString(3, DETAILS);
			if(IS_INCIDENT){
				cstmt.setInt(4, 1);
			}
			else{
				cstmt.setInt(4, 0);
			}
			
			cstmt.setDate(5, sqlDate);
			cstmt.setInt(6, EMPLOYEE_ID);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_OPINION(Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_OPINION(?,?,?,?)}");
			
			cstmt.setInt(1, EMPLOYEE_ID);
			cstmt.setInt(2, CASE_ID);
			cstmt.setString(3, DETAILS);
			cstmt.setInt(4, CLIENT_CASE_ID);
		

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_RECOMMENDATION(Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_RECOMMENDATION(?,?,?,?)}");
			
			cstmt.setInt(1, EMPLOYEE_ID);
			cstmt.setInt(2, CASE_ID);
			cstmt.setString(3, DETAILS);
			cstmt.setInt(4, CLIENT_CASE_ID);
		

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_WARNING_MESSAGES(Integer EMPLOYEE_ID,	String MESSAGE ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_WARNING_MESSAGES(?,?)}");
			
			cstmt.setInt(1, EMPLOYEE_ID);
			cstmt.setString(2, MESSAGE);
		

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean INSERT_APPOINTMENT(String DATE, 
			Integer IS_DROP_IN, Integer IS_ATTENTED,Integer CLIENT_ID,
			Integer EMPLOYEE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_APPOINTMENT(?,?,?,?,?)}");

			
			
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(DATE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setDate(1,  sqlDate);
			cstmt.setInt(2, IS_DROP_IN);
			cstmt.setInt(3, IS_ATTENTED);
			cstmt.setInt(4, CLIENT_ID);
			cstmt.setInt(5, EMPLOYEE_ID);
		
			

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	//UPDATE METHODS
	public boolean UPDATE_CLIENT(Integer ClientID,Integer NationalID, String FirstName, String LastName, String BirthDate, boolean Sex,
				String Tel, String Nationality, String Country, String City, String PostCode, String Street,
				String Comments, boolean hasIllegal , Integer isDeleted) {
			CallableStatement cstmt = null;
			boolean result = true;
			try {
				con = DBConnector.getDBConnection();
				cstmt = con.prepareCall("{call SP_UPDATE_CLIENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				int sexi=0;
				int hasIllegali=0;
				if(Sex){
					sexi=1;
				}
				if(hasIllegal){
					hasIllegali=1;
				}
				
				java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(BirthDate);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				cstmt.setInt(1, ClientID);
				cstmt.setInt(2, NationalID);
				cstmt.setString(3, FirstName);
				cstmt.setString(4, LastName);
				cstmt.setDate(5,  sqlDate);
				cstmt.setInt(6, sexi);
				cstmt.setString(7, Tel);
				cstmt.setString(8, Nationality);
				cstmt.setString(9, Country);
				cstmt.setString(10, City);
				cstmt.setString(11, PostCode);
				cstmt.setString(12, Street);
				cstmt.setString(13, Comments);
				cstmt.setInt(14, hasIllegali);
				cstmt.setInt(15, isDeleted);

				cstmt.execute();
			} catch (Exception ex) {
				result = false;
			} finally {
				try {
					cstmt.close();
				} catch (SQLException e) {
				}
			}
			return result;
		}
		
	public boolean UPDATE_BRANCH(Integer BRANCH_ID,String NAME, String COUNTRY, String CITY,String POSTCODE,
			String STREET, String TEL) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_BRANCH(?,?,?,?,?,?,?)}");
					
			cstmt.setInt(1, BRANCH_ID);
			cstmt.setString(2, NAME);
			cstmt.setString(3, COUNTRY);
			cstmt.setString(4, CITY);
			cstmt.setString(5,  POSTCODE);
			cstmt.setString(6, STREET);
			cstmt.setString(7, TEL);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_CHANGE_INFORMATION(Integer CHANGE_ID,Integer EMPLOYEE_ID,Integer CLIENT_ID ,
			String CHANGE_DATE,Integer DIDCHANGED,Integer ISCLIENTREQUEST) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_CHANGE_INFORMATION(?,?,?,?,?,?)}");
				
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(CHANGE_DATE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, CHANGE_ID);
			cstmt.setInt(2, EMPLOYEE_ID);
			cstmt.setInt(3, CLIENT_ID);
			cstmt.setDate(4, sqlDate);
			cstmt.setInt(5,  DIDCHANGED);
			cstmt.setInt(6, ISCLIENTREQUEST);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_CLIENT_CASE(Integer CLIENT_CASE_ID,Integer CLIENT_ID,Integer CASE_ID, Integer EMPLOYEE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_CLIENT_CASE(?,?,?,?)}");
					
			cstmt.setInt(1, CLIENT_CASE_ID);
			cstmt.setInt(2, CLIENT_ID);
			cstmt.setInt(3, CASE_ID);
			cstmt.setInt(4, EMPLOYEE_ID);
			
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_CONSULTATION(Integer CONSULTATION_ID,Integer CLIENT_ID,Integer CASE_ID,String DETAILS,
			String CONSULTATION_DATE,Integer WENT,Integer ISDROPIN, Integer CLIENT_CASE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_CONSULTATION(?,?,?,?,?,?,?,?)}");
					
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(CONSULTATION_DATE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, CONSULTATION_ID);
			cstmt.setInt(2, CLIENT_ID);
			cstmt.setInt(3, CASE_ID);
			cstmt.setString(4, DETAILS);
			cstmt.setDate(5, sqlDate);
			cstmt.setInt(6, WENT);
			cstmt.setInt(7, ISDROPIN);
			cstmt.setInt(8, CLIENT_CASE_ID);
			
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_INCIDENT_DISPUTES(Integer INCIDENT_DISPUTE_ID,String DETAILS,Integer IS_INCIDENT) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_INCIDENT_DISPUTES(?,?,?)}");
					
			cstmt.setInt(1, INCIDENT_DISPUTE_ID);
			cstmt.setString(2, DETAILS);
			cstmt.setInt(3, IS_INCIDENT);
			
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_OFFICE_CASE(Integer CASE_ID,Integer CLIENT_ID,String NAME,String DETAILS,
			Boolean IS_INCIDENT,String LAST_UPDATED,Integer EMPLOYEE_ID ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_OFFICE_CASE(?,?,?,?,?,?,?)}");
			
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(LAST_UPDATED);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, CASE_ID);
			cstmt.setInt(2, CLIENT_ID);
			cstmt.setString(3, NAME);
			cstmt.setString(4, DETAILS);
			if(IS_INCIDENT){
				cstmt.setInt(5, 1);
			}
			else{
				cstmt.setInt(5,0 );

			}
			cstmt.setDate(6, sqlDate);
			cstmt.setInt(7, EMPLOYEE_ID);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_OPINION(Integer OPINION_ID,Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_OPINION(?,?,?,?,?)}");
			
			cstmt.setInt(1, OPINION_ID);
			cstmt.setInt(2, EMPLOYEE_ID);
			cstmt.setInt(3, CASE_ID);
			cstmt.setString(4, DETAILS);
			cstmt.setInt(5, CLIENT_CASE_ID);
		

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_RECOMMENDATION(Integer RECOMMENDATION_ID,Integer EMPLOYEE_ID,Integer CASE_ID,
			String DETAILS,Integer CLIENT_CASE_ID ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_RECOMMENDATION(?,?,?,?,?)}");
			
			cstmt.setInt(1, RECOMMENDATION_ID);
			cstmt.setInt(2, EMPLOYEE_ID);
			cstmt.setInt(3, CASE_ID);
			cstmt.setString(4, DETAILS);
			cstmt.setInt(5, CLIENT_CASE_ID);
		

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_WARNING_MESSAGES(Integer WARNING_MESSAGE_ID,Integer EMPLOYEE_ID,	String MESSAGE ) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_INSERT_WARNING_MESSAGES(?,?,?)}");
			
			cstmt.setInt(1, WARNING_MESSAGE_ID);
			cstmt.setInt(2, EMPLOYEE_ID);
			cstmt.setString(3, MESSAGE);
		

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean UPDATE_APPOINTMENT(Integer APPOINTMENT_ID,String DATE, 
			Integer IS_DROP_IN, Integer IS_ATTENTED,Integer CLIENT_ID,
			Integer EMPLOYEE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_UPDATE_APPOINTMENT(?,?,?,?,?)}");
			
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(DATE);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			cstmt.setInt(1, APPOINTMENT_ID);
			cstmt.setDate(2,  sqlDate);
			cstmt.setInt(3, IS_DROP_IN);
			cstmt.setInt(4, IS_ATTENTED);
			cstmt.setInt(5, CLIENT_ID);
			cstmt.setInt(6, EMPLOYEE_ID);

			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	//GET METHODS
	public Employee GET_EMPLOYEE(String USERNAME, String PASSWORD) {
		CallableStatement cstmt = null;
		Employee result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_EMPLOYEE(?,?)}");

			cstmt.setString(1, USERNAME);
			cstmt.setString(2, PASSWORD);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Employee(((rs.getObject(1) == null) ? null : rs.getInt(1)), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Branch GET_BRANCH(Integer BRANCH_ID) {
		CallableStatement cstmt = null;
		Branch result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_BRANCH(?)}");

			cstmt.setInt(1, BRANCH_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Branch(((rs.getObject(1) == null) ? null : rs.getInt(1)),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)	);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ChangeInformation GET_CHANGE_INFORMATION(Integer CHANGE_ID) {
		CallableStatement cstmt = null;
		ChangeInformation result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_CHANGE_INFORMATION(?)}");

			cstmt.setInt(1, CHANGE_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new ChangeInformation(((rs.getObject(1) == null) ? null : rs.getInt(1)),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4),
						rs.getInt(5),
						rs.getInt(6));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Client GET_CLIENT(Integer CLIENT_ID) {
		CallableStatement cstmt = null;
		Client result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_CLIENT(?)}");

			cstmt.setInt(1, CLIENT_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Client(((rs.getObject(1) == null) ? null : rs.getInt(1)), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14),
						rs.getInt(15));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ClientCase GET_CLIENT_CASE(Integer CLIENT_CASE_ID) {
		CallableStatement cstmt = null;
		ClientCase result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_CLIENT_CASE(?)}");

			cstmt.setInt(1, CLIENT_CASE_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new ClientCase(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Consultation GET_CONSULTATION(Integer CONSULTATION_ID) {
		CallableStatement cstmt = null;
		Consultation result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_CONSULTATION(?)}");

			cstmt.setInt(1, CONSULTATION_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Consultation(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getDate(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public IncidentsDisputes GET_INCIDENTS_DISPUTES(Integer INCIDENT_DISPUTE_ID) {
		CallableStatement cstmt = null;
		IncidentsDisputes result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_INCIDENTS_DISPUTES(?)}");

			cstmt.setInt(1, INCIDENT_DISPUTE_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new IncidentsDisputes(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getString(2),
						rs.getInt(3));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public OfficeCase GET_OFFICE_CASE(Integer CASE_ID) {
		CallableStatement cstmt = null;
		OfficeCase result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_OFFICE_CASE(?)}");

			cstmt.setInt(1, CASE_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new OfficeCase(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getInt(7));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Opinion GET_OPINION(Integer OPINION_ID) {
		CallableStatement cstmt = null;
		Opinion result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_OPINION(?)}");

			cstmt.setInt(1, OPINION_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Opinion(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Recommendation GET_RECOMMENDATION(Integer RECOMMENDATION_ID) {
		CallableStatement cstmt = null;
		Recommendation result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_OPINION(?)}");

			cstmt.setInt(1, RECOMMENDATION_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Recommendation(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public WarningMessages GET_WARNING_MESSAGES(Integer WARNING_MESSAGE_ID) {
		CallableStatement cstmt = null;
		WarningMessages result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_WARNING_MESSAGES(?)}");

			cstmt.setInt(1, WARNING_MESSAGE_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new WarningMessages(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getString(3));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Appointment GET_APPOINTMENT(Integer APPOINTMENT_ID) {
		CallableStatement cstmt = null;
		Appointment result = null;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_APPOINTMENT(?)}");

			cstmt.setInt(1, APPOINTMENT_ID);
			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			if (rs.next()) {
				result = new Appointment(((rs.getObject(1) == null) ? null : rs.getInt(1)),
						rs.getDate(2), 
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6));
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	
	//LIST METHODS
	public DefaultListModel<Client> GET_ALL_CLIENTS() {
		CallableStatement cstmt = null;
		Client result = null;
		DefaultListModel<Client> list = new DefaultListModel<Client>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_GET_ALL_CLIENT()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new Client(((rs.getObject(1) == null) ? null : rs.getInt(1)), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14),
						rs.getInt(15));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public DefaultListModel<Branch> LIST_BRANCH() {
		CallableStatement cstmt = null;
		Branch result = null;
		DefaultListModel<Branch> list = new DefaultListModel<Branch>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_BRANCH()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new Branch(((rs.getObject(1) == null) ? null : rs.getInt(1)),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<ChangeInformation> LIST_CHANGE_INFORMATION() {
		CallableStatement cstmt = null;
		ChangeInformation result = null;
		DefaultListModel<ChangeInformation> list = new DefaultListModel<ChangeInformation>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_CHANGE_INFORMATION()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new ChangeInformation(((rs.getObject(1) == null) ? null : rs.getInt(1)),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4),
						rs.getInt(5),
						rs.getInt(6));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<ClientCase> LIST_CLIENT_CASE() {
		CallableStatement cstmt = null;
		ClientCase result = null;
		DefaultListModel<ClientCase> list = new DefaultListModel<ClientCase>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_CLIENT_CASE()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new ClientCase(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<Consultation> LIST_CONSULTATION() {
		CallableStatement cstmt = null;
		Consultation result = null;
		DefaultListModel<Consultation> list = new DefaultListModel<Consultation>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_CONSULTATION()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new Consultation(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getDate(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<IncidentsDisputes> LIST_INCIDENTS_DISPUTES() {
		CallableStatement cstmt = null;
		IncidentsDisputes result = null;
		DefaultListModel<IncidentsDisputes> list = new DefaultListModel<IncidentsDisputes>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_INCIDENTS_DISPUTES()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new IncidentsDisputes(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getString(2),
						rs.getInt(3));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<OfficeCase> LIST_OFFICE_CASE() {
		CallableStatement cstmt = null;
		OfficeCase result = null;
		DefaultListModel<OfficeCase> list = new DefaultListModel<OfficeCase>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_OFFICE_CASE()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new OfficeCase(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getInt(7));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<Opinion> LIST_OPINION() {
		CallableStatement cstmt = null;
		Opinion result = null;
		DefaultListModel<Opinion> list = new DefaultListModel<Opinion>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_OPINION()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new Opinion(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<Recommendation> LIST_RECOMMENDATION() {
		CallableStatement cstmt = null;
		Recommendation result = null;
		DefaultListModel<Recommendation> list = new DefaultListModel<Recommendation>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_RECOMMENDATION()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new Recommendation(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<WarningMessages> LIST_WARNING_MESSAGES() {
		CallableStatement cstmt = null;
		WarningMessages result = null;
		DefaultListModel<WarningMessages> list = new DefaultListModel<WarningMessages>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_WARNING_MESSAGES()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new WarningMessages(((rs.getObject(1) == null) ? null : rs.getInt(1)), 
						rs.getInt(2),
						rs.getString(3));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public DefaultListModel<Appointment> LIST_APPOINTMENT() {
		CallableStatement cstmt = null;
		Appointment result = null;
		DefaultListModel<Appointment> list = new DefaultListModel<Appointment>();

		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_LIST_APPOINTMENT()}");

			cstmt.execute();

			ResultSet rs;
			rs = (ResultSet) cstmt.getResultSet();
			while (rs.next()) {
				result = new Appointment(((rs.getObject(1) == null) ? null : rs.getInt(1)),
						rs.getDate(2), 
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6));
				list.addElement(result);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			result = null;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//DELETE METHODS
	public boolean DELETE_CLIENT(Integer client_id) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_CLIENT(?)}");

			cstmt.setInt(1, client_id);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	public boolean DELETE_BRANCH(Integer BRANCH_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_BRANCH(?)}");

			cstmt.setInt(1, BRANCH_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	public boolean DELETE_CHANGE_INFORAMTION(Integer CHANGE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_CHANGE_INFORMATION(?)}");

			cstmt.setInt(1, CHANGE_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_CLIENT_CASE(Integer CLIENT_CASE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_CLIENT_CASE(?)}");

			cstmt.setInt(1, CLIENT_CASE_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	public boolean DELETE_CONSULTATION(Integer CONSULTATION_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_CONSULTATION(?)}");

			cstmt.setInt(1, CONSULTATION_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_EMPLOYEE(Integer EMPLOYEE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_EMPLOYEE(?)}");

			cstmt.setInt(1, EMPLOYEE_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_INCIDENTS_DISPUTES(Integer INCIDENT_DISPUTE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_INCIDENTS_DISPUTES(?)}");

			cstmt.setInt(1, INCIDENT_DISPUTE_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_OFFICE_CASE(Integer CASE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_OFFICE_CASE(?)}");

			cstmt.setInt(1, CASE_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_OPINION(Integer OPINION_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_OPINION(?)}");

			cstmt.setInt(1, OPINION_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_RECOMMENDATION(Integer RECOMMENDATION_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_RECOMMENDATION(?)}");

			cstmt.setInt(1, RECOMMENDATION_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public boolean DELETE_WARNING_MESSAGES(Integer WARNING_MESSAGE_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_WARNING_MESSAGES(?)}");

			cstmt.setInt(1, WARNING_MESSAGE_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	
	public boolean DELETE_APPOINTMENT(Integer APPOINTMENT_ID) {
		CallableStatement cstmt = null;
		boolean result = true;
		try {
			con = DBConnector.getDBConnection();
			cstmt = con.prepareCall("{call SP_DELETE_APPOINTMENT(?)}");

			cstmt.setInt(1, APPOINTMENT_ID);
			cstmt.execute();

		} catch (Exception ex) {
			result = false;
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
}
