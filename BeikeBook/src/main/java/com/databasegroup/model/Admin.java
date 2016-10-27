package com.databasegroup.model;

public class Admin {
	private int adminID;
	private String name;
	private String password;
	private String districtAddr;
	private int type;

	public Admin(){
		this.type = 1;
	}

	public Admin(String name,String password,String districtAddr,int type){
		this.name = name;
		this.password = password;
		this.districtAddr = districtAddr;
		this.type = type;
	}

	/**
	** check validate
	**/
	public boolean checkValidate(String pw){
		return this.password == pw;
	}

	public void setPassword(String pw){
		this.password = pw;
	}

	public void setDistrict(String districtAddr){
		this.districtAddr = districtAddr;
	}

	public String getDistrict(){
		return this.districtAddr;
	}

	public String getPassword(){
		return this.password;
	}

	public int getID(){
		return this.adminID;
	}

	public int getType(){
		return this.type;
	}
}
