package com.fry.controller;

import java.util.Vector;

import com.fry.model.Article;
import com.fry.model.Teacher;

//统计每一个作者的发文数
public class CountArticlePerTeacher {
	
	public void countData(Vector<Teacher> teacherList,Vector<Article> articleList){
		int artcleStart=0;//起点
		for(int i=0;i<teacherList.size();i++){
			Teacher teacher=new Teacher();
			teacher=teacherList.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^0-9]", "");
			int id1=Integer.parseInt(ID1);
			int articleSureNum=teacher.getSureNum();
			int articleNotSureNum=teacher.getNotSureNum();
			
			//System.out.println("id1:  "+id1);
			for(int j=artcleStart;j<articleList.size();j++){
				Article article=new Article();
				article=articleList.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				//System.out.println("        id2:  "+id2);
				if(id1==id2){
					//if(id1==19740060) System.out.println("19740060");
					if(article.getIrTag().equals("0"))
						articleSureNum++;
					if(article.getIrTag().equals("7"))
						articleNotSureNum++;
				}else if(id2>id1){
					artcleStart=j;
					break;
				}
			}
			
			teacher.setSureNum(articleSureNum);
			teacher.setNotSureNum(articleNotSureNum);
			//System.out.println(teacher.getLoginID()+" "+teacher.getName()+" "+teacher.getSciNum()+" "+teacher.getSureNum()+" "+teacher.getNotSureNum());
			//if(i==5) break;
		}
		//System.out.println(teacherList.size()+" "+articleList.size());
	}
	
	public void countSci2(Vector<Teacher> teacherList,Vector<Article> articleList){
		int artcleStart=0;//起点
		for(int i=0;i<teacherList.size();i++){
			Teacher teacher=new Teacher();
			teacher=teacherList.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
			int id1=Integer.parseInt(ID1);
			int articleNum=0;
			
			for(int j=artcleStart;j<articleList.size();j++){
				Article article=new Article();
				article=articleList.elementAt(j);
				
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				if(ID2.equals("NULL")) continue;
				int id2=Integer.parseInt(ID2);
				if(id1==id2){
					articleNum++;
				}else if(id2>id1){
					artcleStart=j;
					break;
				}
			}
			teacher.setSciNum(articleNum);
			//System.out.println(teacher.getLoginID()+" "+teacher.getName()+" "+teacher.getSciNum());
		}
		//System.out.println(teacherList.size()+" "+articleList.size());
	}
	
	public void countCssci2(Vector<Teacher> teacherList,Vector<Article> articleList){
		int artcleStart=0;//起点
		for(int i=0;i<teacherList.size();i++){
			Teacher teacher=new Teacher();
			teacher=teacherList.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
			int id1=Integer.parseInt(ID1);
			int articleNum=0;
			
			for(int j=artcleStart;j<articleList.size();j++){
				Article article=new Article();
				article=articleList.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				int id2=Integer.parseInt(ID2);
				if(id1==id2){
					articleNum++;
				}else if(id2>id1){
					artcleStart=j;
					break;
				}
			}
			teacher.setCssciNum(articleNum);
			//System.out.println(teacher.getLoginID()+" "+teacher.getName()+" "+teacher.getCssciNum());
		}
		//System.out.println(teacherList.size()+" "+articleList.size());
	}
	
	public void countCssci(Vector<Teacher> teacherList,Vector<Article> articleList){
		for(int i=0;i<teacherList.size();i++){
			Teacher teacher=new Teacher();
			teacher=teacherList.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
			int articleNum=0;
			for(int j=0;j<articleList.size();j++){
				Article article=new Article();
				article=articleList.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				if(ID2.equals(ID1)){
					articleNum++;
				}
			}
			teacher.setCssciNum(articleNum);
			System.out.println(teacher.getLoginID()+" "+teacher.getName()+" "+teacher.getCssciNum());
		}
		//System.out.println(teacherList.size()+" "+articleList.size());
	}
	
}
