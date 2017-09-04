package basicTool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseHelper {

	public static final String DRIVER_CLASS  = "com.mysql.jdbc.Driver";
	public static final String USER = "8lab";
	public static final String PASSWORD = "8lab";
	
	public Connection connection = null;
	public PreparedStatement pst = null;
	public ResultSet resultSet = null;
	
	public DataBaseHelper(String url){
		try {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(url, USER, PASSWORD);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int executeSQL(String sql){
		int result = 0;
		try {
			pst = connection.prepareStatement(sql);
			result = pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void close(){
		try {
			this.pst.close();
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
