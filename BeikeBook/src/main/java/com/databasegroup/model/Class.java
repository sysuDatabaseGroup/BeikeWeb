package com.databasegroup.model;

public class Class {
	private int classID;
	private String className;
	private String classImg;
	
	@Override
	public String toString() {
		return "" + classID + ' ' + className + ' ' + classImg;
	}
	
	/**
	 * @return the classID
	 */
	public int getClassID() {
		return classID;
	}
	/**
	 * @param classID the classID to set
	 */
	public void setClassID(int classID) {
		this.classID = classID;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the classImg
	 */
	public String getClassImg() {
		return classImg;
	}
	/**
	 * @param classImg the classImg to set
	 */
	public void setClassImg(String classImg) {
		this.classImg = classImg;
	}
}
