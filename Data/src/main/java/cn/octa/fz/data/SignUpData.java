package cn.octa.fz.data;

import basicClass.AbstractData;

public class SignUpData extends AbstractData {
	
	// for nagetive case
	private String confirmpwd;
	private String userNameLess6 = "abcd";
	private String userNameMore18 = "1qaz2wsx3edc4rfv5tg"; 
	private String userNameInvalid = "12s@bé";
	private String passwordLess6 = "zaq12";
	private String passwordMore18 = "123456789qwertyuiop";
	private String passwordInvalid = "@wer3%";
	
	// error message
	private String checkMessage = "长度6~18的字符、数字和下划线";  
	private String checkUserWarning = "请检查您输入的用户名！";
	private String checkPwdWarning = "请检查您输入的密码！";
	private String checkPwdDifferent = "两次密码输入不相同！";
	private String checkDuplicatedUser = "用户已存在";
	private String enterUserName = "请输入用户名";
	private String enterPassword = "请输入密码";
	private String wrongMsg = "用户名或密码错误";
	
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public String getWrongMsg() {
		return wrongMsg;
	}
	public String getEnterUserName() {
		return enterUserName;
	}
	public String getEnterPassword() {
		return enterPassword;
	}
	public String getCheckDuplicatedUser() {
		return checkDuplicatedUser;
	}
	public String getCheckPwdDifferent() {
		return checkPwdDifferent;
	}
	public void setCheckPwdDifferent(String checkPwdDifferent) {
		this.checkPwdDifferent = checkPwdDifferent;
	}
	public String getCheckPwdWarning() {
		return checkPwdWarning;
	}
	public void setCheckPwdWarning(String checkPwdWarning) {
		this.checkPwdWarning = checkPwdWarning;
	}
	public String getCheckUserWarning() {
		return checkUserWarning;
	}
	public void setCheckUserWarning(String checkUserWarning) {
		this.checkUserWarning = checkUserWarning;
	}
	public String getCheckMessage() {
		return checkMessage;
	}
	public void setCheckMessage(String checkMessage) {
		this.checkMessage = checkMessage;
	}
	public String getUserNameLess6() {
		return userNameLess6;
	}
	public void setUserNameLess6(String userNameLess6) {
		this.userNameLess6 = userNameLess6;
	}
	public String getUserNameMore18() {
		return userNameMore18;
	}
	public void setUserNameMore18(String userNameMore18) {
		this.userNameMore18 = userNameMore18;
	}
	public String getUserNameInvalid() {
		return userNameInvalid;
	}
	public void setUserNameInvalid(String userNameInvalid) {
		this.userNameInvalid = userNameInvalid;
	}
	public String getPasswordLess6() {
		return passwordLess6;
	}
	public void setPasswordLess6(String passwordLess6) {
		this.passwordLess6 = passwordLess6;
	}
	public String getPasswordMore18() {
		return passwordMore18;
	}
	public void setPasswordMore18(String passwordMore18) {
		this.passwordMore18 = passwordMore18;
	}
	public String getPasswordInvalid() {
		return passwordInvalid;
	}
	public void setPasswordInvalid(String passwordInvalid) {
		this.passwordInvalid = passwordInvalid;
	}
	
	@Override
	public String toString(){
		return "ID: " + getId() + ", priority: " + getPriority() + ", description: " + getDescription();
	}
	
}
