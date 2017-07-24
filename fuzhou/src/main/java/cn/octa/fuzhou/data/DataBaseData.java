package cn.octa.fuzhou.data;

import basicClass.AbstractData;

public class DataBaseData extends AbstractData {
	
	private int dbIndex = 1;
	private String dbName;
	private String dbType = "MySQL";
	private String ip;
	private String dbUser;
	private String dbPassword;
	private String dbPort = "3306";  //后期选择类型之后 port会自动填入，所以先写到这里 后期再改
	private String editName = "test";
	private String invalidDbName = "!@#";
	
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	
	public String getInvalidDbName() {
		return invalidDbName;
	}
	public void setInvalidDbName(String invalidDbName) {
		this.invalidDbName = invalidDbName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public String getEditName() {
		return editName;
	}
	public void setEditName(String editName) {
		this.editName = editName;
	}
	
}
