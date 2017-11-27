package com.fry.model;

public class Article {
	//厂商数据
	private String loginID;//作者ID
	private String author;//作者姓名
	private String title_cn;
	private String title_en;
	private String irTag;
	
	private String norm_title_en;
	private String norm_title_cn;
	
	//文章匹配
	private String placeInSchoolData;
	private String placeInBusyData;
	
	//找每篇文章的位置
	private String placeInCssci="";
	private String placeInSci="";
	private String placeInData1="";
	private String placeInData2="";
	private String placeInData3="";
	
	
	
	
	public String getPlaceInCssci() {
		return placeInCssci;
	}
	public void setPlaceInCssci(String placeInCssci) {
		this.placeInCssci = placeInCssci;
	}
	public String getPlaceInSci() {
		return placeInSci;
	}
	public void setPlaceInSci(String placeInSci) {
		this.placeInSci = placeInSci;
	}
	public String getPlaceInData1() {
		return placeInData1;
	}
	public void setPlaceInData1(String placeInData1) {
		this.placeInData1 = placeInData1;
	}
	public String getPlaceInData2() {
		return placeInData2;
	}
	public void setPlaceInData2(String placeInData2) {
		this.placeInData2 = placeInData2;
	}
	public String getPlaceInData3() {
		return placeInData3;
	}
	public void setPlaceInData3(String placeInData3) {
		this.placeInData3 = placeInData3;
	}
	public String getNorm_title_en() {
		return norm_title_en;
	}
	public void setNorm_title_en(String norm_title_en) {
		this.norm_title_en = norm_title_en;
	}
	public String getNorm_title_cn() {
		return norm_title_cn;
	}
	public void setNorm_title_cn(String norm_title_cn) {
		this.norm_title_cn = norm_title_cn;
	}
	public String getPlaceInSchoolData() {
		return placeInSchoolData;
	}
	public void setPlaceInSchoolData(String placeInSchoolData) {
		this.placeInSchoolData = placeInSchoolData;
	}
	public String getPlaceInBusyData() {
		return placeInBusyData;
	}
	public void setPlaceInBusyData(String placeInBusyData) {
		this.placeInBusyData = placeInBusyData;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle_cn() {
		return title_cn;
	}
	public void setTitle_cn(String title_cn) {
		this.title_cn = title_cn;
	}
	public String getTitle_en() {
		return title_en;
	}
	public void setTitle_en(String title_en) {
		this.title_en = title_en;
	}
	public String getIrTag() {
		return irTag;
	}
	public void setIrTag(String irTag) {
		this.irTag = irTag;
	}
	
	
	
	//
	
	
	
	
	
	
}
