package com.mytelstra.mobile.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserInformation")
public class UserInfo {
	private String id;
	private String mobilenumber;
	private String username;
	private List<RechargeInfo> planshistory;
	private RechargeInfo activeplan;
	private double dataremaining;
	private int voiceremaining;
	private int smsremaining;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String id, String mobilenumber, String username, List<RechargeInfo> planshistory,
			RechargeInfo activeplan, double dataremaining, int voiceremaining, int smsremaining) {
		super();
		this.id = id;
		this.mobilenumber = mobilenumber;
		this.username = username;
		this.planshistory = planshistory;
		this.activeplan = activeplan;
		this.dataremaining = dataremaining;
		this.voiceremaining = voiceremaining;
		this.smsremaining = smsremaining;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<RechargeInfo> getPlanshistory() {
		return planshistory;
	}
	public void setPlanshistory(List<RechargeInfo> planshistory) {
		this.planshistory = planshistory;
	}
	public RechargeInfo getActiveplan() {
		return activeplan;
	}
	public void setActiveplan(RechargeInfo activeplan) {
		this.activeplan = activeplan;
	}
	public double getDataremaining() {
		return dataremaining;
	}
	public void setDataremaining(double dataremaining) {
		this.dataremaining = dataremaining;
	}
	public int getVoiceremaining() {
		return voiceremaining;
	}
	public void setVoiceremaining(int voiceremaining) {
		this.voiceremaining = voiceremaining;
	}
	public int getSmsremaining() {
		return smsremaining;
	}
	public void setSmsremaining(int smsremaining) {
		this.smsremaining = smsremaining;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", mobilenumber=" + mobilenumber + ", username=" + username + ", planshistory="
				+ planshistory + ", activeplan=" + activeplan + ", dataremaining=" + dataremaining + ", voiceremaining="
				+ voiceremaining + ", smsremaining=" + smsremaining + "]";
	}	
	
}
