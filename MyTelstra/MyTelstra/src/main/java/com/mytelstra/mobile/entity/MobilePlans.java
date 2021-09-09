package com.mytelstra.mobile.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MobilePlans")
public class MobilePlans {
	private String id;
	private String plan;
	private int duration;
	private int price;
	private int data;
	private int voice;
	private int sms;
	
	
	public MobilePlans() {
		super();
	}


	public MobilePlans(String id, String plan, int duration, int price, int data, int voice, int sms) {
		super();
		this.id = id;
		this.plan = plan;
		this.duration = duration;
		this.price = price;
		this.data = data;
		this.voice = voice;
		this.sms = sms;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPlan() {
		return plan;
	}


	public void setPlan(String plan) {
		this.plan = plan;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public int getVoice() {
		return voice;
	}


	public void setVoice(int voice) {
		this.voice = voice;
	}


	public int getSms() {
		return sms;
	}


	public void setSms(int sms) {
		this.sms = sms;
	}


	@Override
	public String toString() {
		return "MobilePlans [id=" + id + ", plan=" + plan + ", duration=" + duration + ", price=" + price + ", data="
				+ data + ", voice=" + voice + ", sms=" + sms + "]";
	}
	
}
