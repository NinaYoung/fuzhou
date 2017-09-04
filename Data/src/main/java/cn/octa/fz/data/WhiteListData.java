package cn.octa.fz.data;

import basicClass.AbstractData;

public class WhiteListData extends AbstractData {

	private String hostname;
	private String filepath;
	private String ip;
	private String successMsg = "添加成功";
	private String failedMsg = "添加失败: 请勿重复添加！";
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	public String getFailedMsg() {
		return failedMsg;
	}
	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
	}
	
}
