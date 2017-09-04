package cn.octa.fz.data;

import basicClass.AbstractData;

public class ChangePasswordData extends AbstractData{
	
	private String newPassword;
	private String confirmNewPwd;
	private String invalidCurrentPwd = "!qwedsas";
	private String newPwdLess6 = "1234";
	private String newPwdMore18 = "12345678901234567890";
	private String invalidNewPwd = "123￥%#";
	
	private String popUpMsg = "当前密码不正确";
	private String invalidPwdMsg = "长度6~18的字符、数字和下划线";
	private String differnetPwdMsg = "两次输入密码不一致";
	
	public String getInvalidNewPwd() {
		return invalidNewPwd;
	}
	public void setInvalidNewPwd(String invalidNewPwd) {
		this.invalidNewPwd = invalidNewPwd;
	}
	public void setNewPwdLess6(String newPwdLess6) {
		this.newPwdLess6 = newPwdLess6;
	}
	public void setNewPwdMore18(String newPwdMore18) {
		this.newPwdMore18 = newPwdMore18;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPwd() {
		return confirmNewPwd;
	}
	public void setConfirmNewPwd(String confirmNewPwd) {
		this.confirmNewPwd = confirmNewPwd;
	}
	public String getInvalidCurrentPwd() {
		return invalidCurrentPwd;
	}
	public void setInvalidCurrentPwd(String invalidCurrentPwd) {
		this.invalidCurrentPwd = invalidCurrentPwd;
	}
	public String getNewPwdLess6() {
		return newPwdLess6;
	}
	public String getNewPwdMore18() {
		return newPwdMore18;
	}
	public String getPopUpMsg() {
		return popUpMsg;
	}
	public String getInvalidPwdMsg() {
		return invalidPwdMsg;
	}
	public String getDiffernetPwdMsg() {
		return differnetPwdMsg;
	}
	
}
