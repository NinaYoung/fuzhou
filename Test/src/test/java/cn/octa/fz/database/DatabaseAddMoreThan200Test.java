package cn.octa.fz.database;

import basicTool.DataBaseHelper;

public class DatabaseAddMoreThan200Test {
	
	public static final String URL = "jdbc:mysql://192.168.1.210:3306/octastack_fuzhou";
	public static String sql = null;
	public static DataBaseHelper dbHelper = null;
	
	public static void main(String[] args){
		
		dbHelper = new DataBaseHelper(URL);
		
		
		for(int i=0; i<200; i++){
//		sql = "CREATE DATABASE IF NOT EXISTS "+"test_"+i;
		int db_id = 3000 + i;
	    String db_name = "MySQL_" + i;
//	    
//	    sql = "insert into client_info(db_id,db_name,db_type,db_ip,db_port,sql_uname,sql_passwd,db_size,db_volume) values('" 
//	           +db_id +"','" +db_name +"','MySQL','192.168.1.246','3306','8lab','8lab','0','0.78')";
		sql = "delete from client_info where db_id='" + db_id +"'";
	    System.out.println(sql);
	    int resultSet = dbHelper.executeSQL(sql);
	    System.out.println(resultSet);
	    
		}
		
		dbHelper.close();
	}
	
}
