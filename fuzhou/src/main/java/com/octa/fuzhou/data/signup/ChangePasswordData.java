package com.octa.fuzhou.data.signup;

import basicClass.AbstractData;

public class ChangePasswordData extends AbstractData{
	
	private String newPassword;
	private String confirmNewPwd;
	
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
	
}
