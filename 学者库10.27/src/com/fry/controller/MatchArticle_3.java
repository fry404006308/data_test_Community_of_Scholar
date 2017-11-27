package com.fry.controller;

import java.util.Vector;

import com.fry.model.Article;
import com.fry.model.ArticleList;
import com.fry.model.Teacher;
import com.fry.model.TeacherList;

/**
 * 
 * @author Fry 做文章的对应位置的匹配 1、将文章读入内存 //2、分别对与Cssci和Sci的文章，在厂商数据的三个表里面找对应位置
 *         3、可以先找id，再匹配文章，把每一个人的文章存到它自己里面
 *         4、对于每一篇文章，我要记录我在学校数据表中出现的位置和厂商数据表中出现的位置 5、匹配的顺序入下，{Cssci，Sci}
 *         {data1，data2，data3} 6、打印结果
 */
public class MatchArticle_3 {
	//1、将文章读入内存 
	public MatchArticle_3() {
		// 读入所有的表
		ExcelOperation excelOperation = new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/测试数据/2017年在册名单_工号升序.xls");
		excelOperation.readExcel_cssci(ArticleList.cssci, "myRes/测试数据/CssciANDCSCD_工号升序.xls");
		excelOperation.readExcel_sci(ArticleList.sci, "myRes/测试数据/sci_工号升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data1, "myRes/测试数据/厂商数据1-升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data2, "myRes/测试数据/厂商数据2-升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data3, "myRes/测试数据/厂商数据3-升序.xls");
	}
	//2、将每个老师对应的文章存到他的名下
	public void giveTeacherArticle(){
		int cssciStart=0;//起点
		int sciStart=0;//起点
		int data1Start=0;//起点
		int data2Start=0;//起点
		int data3Start=0;//起点
		
		//用来测试的数据
		//int xx=10;
		for(int i=0;i<TeacherList.teacher2017List.size();i++){
			//if(i==5) break;
			
			//用来统计老师的id第一次在表中出现的位置
			boolean firstCssci=true;
			boolean firstSci=true;
			boolean firstData1=true;
			boolean firstData2=true;
			boolean firstData3=true;
			
			Teacher teacher=new Teacher();
			teacher=TeacherList.teacher2017List.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^0-9]", "");
			int id1=Integer.parseInt(ID1);
			//查找某个id是否出现过
			
//			if(xx>0){
//				xx--;
//				System.out.println("id1:"+id1);
//			}
			int articleNum=0;
			//System.out.println(teacher.getName()+" "+teacher.getLoginID());
			//2.1 统计每个老师Cssci里面的文章数
			for(int j=cssciStart;j<ArticleList.cssci.size();j++){
				Article article=new Article();
				article=ArticleList.cssci.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				int id2=Integer.parseInt(ID2);
				
				if(id1==id2){
					//id在表中第一次出现的位置
					if(firstCssci){
						firstCssci=false;
						teacher.setIdPlaceInCssci(j+1+1);
					}
					articleNum++;
					String title_cn=article.getTitle_cn();
					String normTitle_cn=title_cn.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_cn(normTitle_cn);
					teacher.getArticle_inCssci().add(article);
					//System.out.println("  "+normTitle_cn);
				}else if(id2>id1){
					cssciStart=j;
					break;
				}
			}
			teacher.setCssciNum(articleNum);
			//System.out.println(articleNum+" "+teacher.getArticle_inCssci().size());
			
			
			
			//2.2 统计每个老师Sci里面的文章数
			for(int j=sciStart;j<ArticleList.sci.size();j++){
				Article article=new Article();
				article=ArticleList.sci.elementAt(j);
				
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				if(ID2.equals("NULL")) continue;
				int id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id在表中第一次出现的位置
					if(firstSci){
						firstSci=false;
						teacher.setIdPlaceInSci(j+1+1);
					}
					articleNum++;
					String title_en=article.getTitle_en();
					String normTitle_en=title_en.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_en(en_norm(normTitle_en));
					teacher.getArticle_inSci().add(article);
					//System.out.println("  "+normTitle_en);
				}else if(id2>id1){
					sciStart=j;
					break;
				}
			}
			teacher.setSciNum(articleNum);
			
			//System.out.println(teacher.getName()+" "+teacher.getLoginID()+" "+teacher.getCssciNum()+" "+teacher.getSciNum());
			//2.3 统计每个老师Data1里面的文章数
			for(int j=data1Start;j<ArticleList.company_data1.size();j++){
				Article article=new Article();
				article=ArticleList.company_data1.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id在表中第一次出现的位置
					if(firstData1){
						firstData1=false;
						teacher.setIdPlaceInData1(j+1+1);
					}
//					if(article.getIrTag().equals("0"))
//						articleSureNum++;
//					if(article.getIrTag().equals("7"))
//						articleNotSureNum++;
					String title_cn=article.getTitle_cn();
					String normTitle_cn=title_cn.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_cn(normTitle_cn);
					
					String title_en=article.getTitle_en();
					String normTitle_en=title_en.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_en(en_norm(normTitle_en));
					
					teacher.getArticle_inData1().add(article);
				}else if(id2>id1){
					data1Start=j;
					break;
				}
			}
			
			//2.4 统计每个老师Data2里面的文章数
			for(int j=data2Start;j<ArticleList.company_data2.size();j++){
				Article article=new Article();
				article=ArticleList.company_data2.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id在表中第一次出现的位置
					if(firstData2){
						firstData2=false;
						teacher.setIdPlaceInData2(j+1+1);
					}
//					if(article.getIrTag().equals("0"))
//						articleSureNum++;
//					if(article.getIrTag().equals("7"))
//						articleNotSureNum++;
					String title_cn=article.getTitle_cn();
					String normTitle_cn=title_cn.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_cn(normTitle_cn);
					
					String title_en=article.getTitle_en();
					String normTitle_en=title_en.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_en(en_norm(normTitle_en));
					
					teacher.getArticle_inData2().add(article);
				}else if(id2>id1){
					data2Start=j;
					break;
				}
			}
			
			//2.5 统计每个老师Data3里面的文章数
			for(int j=data3Start;j<ArticleList.company_data3.size();j++){
				Article article=new Article();
				article=ArticleList.company_data3.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id在表中第一次出现的位置
					if(firstData2){
						firstData2=false;
						teacher.setIdPlaceInData3(j+1+1);
					}
//					if(article.getIrTag().equals("0"))
//						articleSureNum++;
//					if(article.getIrTag().equals("7"))
//						articleNotSureNum++;
					String title_cn=article.getTitle_cn();
					String normTitle_cn=title_cn.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_cn(normTitle_cn);
					
					String title_en=article.getTitle_en();
					String normTitle_en=title_en.replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
					article.setNorm_title_en(en_norm(normTitle_en));
					
					teacher.getArticle_inData3().add(article);
				}else if(id2>id1){
					data3Start=j;
					break;
				}
			}
			
//			System.out.println(teacher.getArticle_inCssci().size()+" "+teacher.getArticle_inSci().size()+" "+teacher.getArticle_inData1().size()+" "+
//			teacher.getArticle_inData2().size()+" "+teacher.getArticle_inData3().size());
		}
		
		
		
	}
	
	//3、在{Cssci，Sci}和{data1，data2，data3}之间建立链接
	public void createMap(){
		for(int i=0;i<TeacherList.teacher2017List.size();i++){
			
			Teacher teacher=TeacherList.teacher2017List.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^0-9]", "");
			int id1=Integer.parseInt(ID1);
			//System.out.println(teacher.getName()+" "+teacher.getLoginID());
			//System.out.println(teacher.getIdPlaceInCssci()+" "+teacher.getIdPlaceInSci()+" "+teacher.getIdPlaceInData1()+" "+teacher.getIdPlaceInData2()+" "+teacher.getIdPlaceInData3());
			//3.1 在Cssci中去找{data1，data2，data3}
			for(int j=0;j<teacher.getArticle_inCssci().size();j++){
				Article article1=teacher.getArticle_inCssci().elementAt(j);
				String norm_title_cn1=article1.getNorm_title_cn();
				//data1
				for(int k=0;k<teacher.getArticle_inData1().size();k++){
					Article article2=teacher.getArticle_inData1().elementAt(k);
					String norm_title_cn2=article2.getNorm_title_cn();
					//测试id为19740060
//					if(id1==19620045){
//						System.out.println("norm_title_cn1:"+norm_title_cn1);
//						System.out.println("norm_title_cn2:"+norm_title_cn2);
//						System.out.println(norm_title_cn1.equals(norm_title_cn2));
//					}
					if(norm_title_cn1.equals(norm_title_cn2)){
						//已确认中匹配了多少篇，未确认中匹配了多少篇
						if(article2.getIrTag().equals("0")){
							int num=teacher.getMatchSure();
							num++;
							teacher.setMatchSure(num);
						}
							
						if(article2.getIrTag().equals("7")){
							int num=teacher.getMatchNotSure();
							num++;
							teacher.setMatchNotSure(num);
						}
						
						String placeInData1=article1.getPlaceInData1();
						String placeInCssci=article2.getPlaceInCssci();
						placeInCssci=placeInCssci+"Cssci表的第"+(j+teacher.getIdPlaceInCssci())+"行;";
						placeInData1=placeInData1+"data1表的第"+(k+teacher.getIdPlaceInData1())+"行;";
						article2.setPlaceInCssci(placeInCssci);
						article1.setPlaceInData1(placeInData1);
						//System.out.println(article2.getTitle_cn()+placeInCssci+"   "+placeInData1);
					}
				}
				//data2
				for(int k=0;k<teacher.getArticle_inData2().size();k++){
					Article article2=teacher.getArticle_inData2().elementAt(k);
					String norm_title_cn2=article2.getNorm_title_cn();
					if(norm_title_cn1.equals(norm_title_cn2)){
						//已确认中匹配了多少篇，未确认中匹配了多少篇
						if(article2.getIrTag().equals("0")){
							int num=teacher.getMatchSure();
							num++;
							teacher.setMatchSure(num);
						}
							
						if(article2.getIrTag().equals("7")){
							int num=teacher.getMatchNotSure();
							num++;
							teacher.setMatchNotSure(num);
						}
						
						String placeInData2=article1.getPlaceInData2();
						String placeInCssci=article2.getPlaceInCssci();
						placeInCssci=placeInCssci+"Cssci表的第"+(j+teacher.getIdPlaceInCssci())+"行;";
						placeInData2=placeInData2+"data2表的第"+(k+teacher.getIdPlaceInData2())+"行;";
						article2.setPlaceInCssci(placeInCssci);
						article1.setPlaceInData2(placeInData2);
						//System.out.println(article2.getTitle_cn()+placeInCssci+"   "+placeInData2);
					}
				}
				//data3
				for(int k=0;k<teacher.getArticle_inData3().size();k++){
					Article article2=teacher.getArticle_inData3().elementAt(k);
					String norm_title_cn2=article2.getNorm_title_cn();
					if(norm_title_cn1.equals(norm_title_cn2)){
						//已确认中匹配了多少篇，未确认中匹配了多少篇
						if(article2.getIrTag().equals("0")){
							int num=teacher.getMatchSure();
							num++;
							teacher.setMatchSure(num);
						}
							
						if(article2.getIrTag().equals("7")){
							int num=teacher.getMatchNotSure();
							num++;
							teacher.setMatchNotSure(num);
						}
						
						String placeInData3=article1.getPlaceInData3();
						String placeInCssci=article2.getPlaceInCssci();
						placeInCssci=placeInCssci+"Cssci表的第"+(j+teacher.getIdPlaceInCssci())+"行;";
						placeInData3=placeInData3+"data3表的第"+(k+teacher.getIdPlaceInData3())+"行;";
						article2.setPlaceInCssci(placeInCssci);
						article1.setPlaceInData3(placeInData3);
						//System.out.println(article2.getTitle_cn()+placeInCssci+"   "+placeInData3);
					}
				}
			}
			//3.2 在Sci中去找{data1，data2，data3}
			for(int j=0;j<teacher.getArticle_inSci().size();j++){
				Article article1=teacher.getArticle_inSci().elementAt(j);
				String norm_title_en1=article1.getNorm_title_en();
				//data1
				for(int k=0;k<teacher.getArticle_inData1().size();k++){
					Article article2=teacher.getArticle_inData1().elementAt(k);
					String norm_title_en2=article2.getNorm_title_en();
					if(norm_title_en1.equals(norm_title_en2)){
						//已确认中匹配了多少篇，未确认中匹配了多少篇
						if(article2.getIrTag().equals("0")){
							int num=teacher.getMatchSure();
							num++;
							teacher.setMatchSure(num);
						}
							
						if(article2.getIrTag().equals("7")){
							int num=teacher.getMatchNotSure();
							num++;
							teacher.setMatchNotSure(num);
						}
						
						String placeInData1=article1.getPlaceInData1();
						String placeInSci=article2.getPlaceInSci();
						placeInSci=placeInSci+"Sci表的第"+(j+teacher.getIdPlaceInSci())+"行;";
						placeInData1=placeInData1+"data1表的第"+(k+teacher.getIdPlaceInData1())+"行;";
						article2.setPlaceInSci(placeInSci);
						article1.setPlaceInData1(placeInData1);
						//System.out.println(article2.getTitle_en()+placeInSci+"   "+placeInData1);
					}
				}
				//data2
				for(int k=0;k<teacher.getArticle_inData2().size();k++){
					Article article2=teacher.getArticle_inData2().elementAt(k);
					String norm_title_en2=article2.getNorm_title_en();
					if(norm_title_en1.equals(norm_title_en2)){
						//已确认中匹配了多少篇，未确认中匹配了多少篇
						if(article2.getIrTag().equals("0")){
							int num=teacher.getMatchSure();
							num++;
							teacher.setMatchSure(num);
						}
							
						if(article2.getIrTag().equals("7")){
							int num=teacher.getMatchNotSure();
							num++;
							teacher.setMatchNotSure(num);
						}
						
						String placeInData2=article1.getPlaceInData2();
						String placeInSci=article2.getPlaceInSci();
						placeInSci=placeInSci+"Sci表的第"+(j+teacher.getIdPlaceInSci())+"行;";
						placeInData2=placeInData2+"data2表的第"+(k+teacher.getIdPlaceInData2())+"行;";
						article2.setPlaceInSci(placeInSci);
						article1.setPlaceInData2(placeInData2);
						//System.out.println(article2.getTitle_en()+placeInSci+"   "+placeInData2);
					}
				}
				//data3
				for(int k=0;k<teacher.getArticle_inData3().size();k++){
					Article article2=teacher.getArticle_inData3().elementAt(k);
					String norm_title_en2=article2.getNorm_title_en();
					if(norm_title_en1.equals(norm_title_en2)){
						//已确认中匹配了多少篇，未确认中匹配了多少篇
						if(article2.getIrTag().equals("0")){
							int num=teacher.getMatchSure();
							num++;
							teacher.setMatchSure(num);
						}
							
						if(article2.getIrTag().equals("7")){
							int num=teacher.getMatchNotSure();
							num++;
							teacher.setMatchNotSure(num);
						}
						
						String placeInData3=article1.getPlaceInData3();
						String placeInSci=article2.getPlaceInSci();
						placeInSci=placeInSci+"Sci表的第"+(j+teacher.getIdPlaceInSci())+"行;";
						placeInData3=placeInData3+"data3表的第"+(k+teacher.getIdPlaceInData3())+"行;";
						article2.setPlaceInSci(placeInSci);
						article1.setPlaceInData3(placeInData3);
						//System.out.println(article2.getTitle_en()+placeInSci+"   "+placeInData3);
					}
				}
			}
		}
	}
	//4、将信息(文章对应的映射关系)填进表中
	public void writeExcel(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.modifyExcel_Cssci(ArticleList.cssci, "myRes/测试数据/CssciANDCSCD_工号升序.xls", "myRes/ans/CssciANDCSCD_工号升序_modify.xls");
		excelOperation.modifyExcel_Sci(ArticleList.sci, "myRes/测试数据/sci_工号升序.xls", "myRes/ans/sci_工号升序_modify.xls");
		excelOperation.modifyExcel_DataCompany(ArticleList.company_data1, "myRes/测试数据/厂商数据1-升序.xls", "myRes/ans/厂商数据1-升序_modify.xls");
		excelOperation.modifyExcel_DataCompany(ArticleList.company_data2, "myRes/测试数据/厂商数据2-升序.xls", "myRes/ans/厂商数据2-升序_modify.xls");
		excelOperation.modifyExcel_DataCompany(ArticleList.company_data3, "myRes/测试数据/厂商数据3-升序.xls", "myRes/ans/厂商数据3-升序_modify.xls");
		
		//5、将文章的匹配数据写进每个老师的文章数量表里面
		excelOperation.modifyExcel_ArticleNum(TeacherList.teacher2017List, "myRes/测试数据/每个老师的文章数量.xls", "myRes/ans/每个老师的文章数量_modify.xls");
		
	}
	
	//将英语文章名字全部弄成小写，标准化
	public String en_norm(String src){
		return src.toLowerCase();
	}
	
	
}
