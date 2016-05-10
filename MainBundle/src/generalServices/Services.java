package generalServices;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import types.Employee;

public class Services implements IServices{

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
	
	public Employee GET_EMPLOYEE(String USERNAME,String PASSWORD) {
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
				result = new Employee((
						(rs.getObject(1) == null) ? null: rs.getInt(1)),
						rs.getInt(2), 
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getString(14),
						rs.getString(15));
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
	
	
	
	
	
}