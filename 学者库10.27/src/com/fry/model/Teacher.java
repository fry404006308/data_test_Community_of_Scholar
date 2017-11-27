package com.fry.model;

import java.util.Vector;

public class Teacher {
	// 2017在职表
	private String loginID;
	private String name;
	private String institution;
	private String proTitle;
	private String subject;

	private int sciNum;
	private int cssciNum;
	private int sureNum;
	private int notSureNum;

	private Vector<Article> article_inCssci;
	private Vector<Article> article_inSci;
	private Vector<Article> article_inData1;
	private Vector<Article> article_inData2;
	private Vector<Article> article_inData3;

	// 人员信息整理表
	private String firstIns;
	private String secondIns;
	private String thirdIns;

	// 这个Teacher的记录最开始出现在各个表的第多少行
	private int idPlaceInCssci=-1;
	private int idPlaceInSci=-1;
	private int idPlaceInData1=-1;
	private int idPlaceInData2=-1;
	private int idPlaceInData3=-1;
	
	// 已确认中匹配了多少篇，未确认中匹配了多少篇
	private int matchSure;
	private int matchNotSure;
	
	

	public Teacher() {
		article_inCssci = new Vector<Article>();
		article_inSci = new Vector<Article>();
		article_inData1 = new Vector<Article>();
		article_inData2 = new Vector<Article>();
		article_inData3 = new Vector<Article>();
	}

	
	
	
	public int getMatchSure() {
		return matchSure;
	}




	public void setMatchSure(int matchSure) {
		this.matchSure = matchSure;
	}




	public int getMatchNotSure() {
		return matchNotSure;
	}




	public void setMatchNotSure(int matchNotSure) {
		this.matchNotSure = matchNotSure;
	}




	public int getIdPlaceInCssci() {
		return idPlaceInCssci;
	}




	public void setIdPlaceInCssci(int idPlaceInCssci) {
		this.idPlaceInCssci = idPlaceInCssci;
	}




	public int getIdPlaceInSci() {
		return idPlaceInSci;
	}




	public void setIdPlaceInSci(int idPlaceInSci) {
		this.idPlaceInSci = idPlaceInSci;
	}




	public int getIdPlaceInData1() {
		return idPlaceInData1;
	}




	public void setIdPlaceInData1(int idPlaceInData1) {
		this.idPlaceInData1 = idPlaceInData1;
	}




	public int getIdPlaceInData2() {
		return idPlaceInData2;
	}




	public void setIdPlaceInData2(int idPlaceInData2) {
		this.idPlaceInData2 = idPlaceInData2;
	}




	public int getIdPlaceInData3() {
		return idPlaceInData3;
	}




	public void setIdPlaceInData3(int idPlaceInData3) {
		this.idPlaceInData3 = idPlaceInData3;
	}




	public Vector<Article> getArticle_inCssci() {
		return article_inCssci;
	}

	public void setArticle_inCssci(Vector<Article> article_inCssci) {
		this.article_inCssci = article_inCssci;
	}

	public Vector<Article> getArticle_inSci() {
		return article_inSci;
	}

	public void setArticle_inSci(Vector<Article> article_inSci) {
		this.article_inSci = article_inSci;
	}

	public Vector<Article> getArticle_inData1() {
		return article_inData1;
	}

	public void setArticle_inData1(Vector<Article> article_inData1) {
		this.article_inData1 = article_inData1;
	}

	public Vector<Article> getArticle_inData2() {
		return article_inData2;
	}

	public void setArticle_inData2(Vector<Article> article_inData2) {
		this.article_inData2 = article_inData2;
	}

	public Vector<Article> getArticle_inData3() {
		return article_inData3;
	}

	public void setArticle_inData3(Vector<Article> article_inData3) {
		this.article_inData3 = article_inData3;
	}

	public int getSciNum() {
		return sciNum;
	}

	public void setSciNum(int sciNum) {
		this.sciNum = sciNum;
	}

	public int getCssciNum() {
		return cssciNum;
	}

	public void setCssciNum(int cssciNum) {
		this.cssciNum = cssciNum;
	}

	public int getSureNum() {
		return sureNum;
	}

	public void setSureNum(int sureNum) {
		this.sureNum = sureNum;
	}

	public int getNotSureNum() {
		return notSureNum;
	}

	public void setNotSureNum(int notSureNum) {
		this.notSureNum = notSureNum;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getProTitle() {
		return proTitle;
	}

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFirstIns() {
		return firstIns;
	}

	public void setFirstIns(String firstIns) {
		this.firstIns = firstIns;
	}

	public String getSecondIns() {
		return secondIns;
	}

	public void setSecondIns(String secondIns) {
		this.secondIns = secondIns;
	}

	public String getThirdIns() {
		return thirdIns;
	}

	public void setThirdIns(String thirdIns) {
		this.thirdIns = thirdIns;
	}

}
