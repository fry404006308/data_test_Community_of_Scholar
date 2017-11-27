package com.fry.controller;

import java.util.Vector;

import com.fry.model.Article;
import com.fry.model.ArticleList;
import com.fry.model.Teacher;
import com.fry.model.TeacherList;

/**
 * 
 * @author Fry �����µĶ�Ӧλ�õ�ƥ�� 1�������¶����ڴ� //2���ֱ����Cssci��Sci�����£��ڳ������ݵ������������Ҷ�Ӧλ��
 *         3����������id����ƥ�����£���ÿһ���˵����´浽���Լ�����
 *         4������ÿһƪ���£���Ҫ��¼����ѧУ���ݱ��г��ֵ�λ�úͳ������ݱ��г��ֵ�λ�� 5��ƥ���˳�����£�{Cssci��Sci}
 *         {data1��data2��data3} 6����ӡ���
 */
public class MatchArticle_3 {
	//1�������¶����ڴ� 
	public MatchArticle_3() {
		// �������еı�
		ExcelOperation excelOperation = new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/��������/2017���ڲ�����_��������.xls");
		excelOperation.readExcel_cssci(ArticleList.cssci, "myRes/��������/CssciANDCSCD_��������.xls");
		excelOperation.readExcel_sci(ArticleList.sci, "myRes/��������/sci_��������.xls");
		excelOperation.readExcel_data(ArticleList.company_data1, "myRes/��������/��������1-����.xls");
		excelOperation.readExcel_data(ArticleList.company_data2, "myRes/��������/��������2-����.xls");
		excelOperation.readExcel_data(ArticleList.company_data3, "myRes/��������/��������3-����.xls");
	}
	//2����ÿ����ʦ��Ӧ�����´浽��������
	public void giveTeacherArticle(){
		int cssciStart=0;//���
		int sciStart=0;//���
		int data1Start=0;//���
		int data2Start=0;//���
		int data3Start=0;//���
		
		//�������Ե�����
		//int xx=10;
		for(int i=0;i<TeacherList.teacher2017List.size();i++){
			//if(i==5) break;
			
			//����ͳ����ʦ��id��һ���ڱ��г��ֵ�λ��
			boolean firstCssci=true;
			boolean firstSci=true;
			boolean firstData1=true;
			boolean firstData2=true;
			boolean firstData3=true;
			
			Teacher teacher=new Teacher();
			teacher=TeacherList.teacher2017List.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^0-9]", "");
			int id1=Integer.parseInt(ID1);
			//����ĳ��id�Ƿ���ֹ�
			
//			if(xx>0){
//				xx--;
//				System.out.println("id1:"+id1);
//			}
			int articleNum=0;
			//System.out.println(teacher.getName()+" "+teacher.getLoginID());
			//2.1 ͳ��ÿ����ʦCssci�����������
			for(int j=cssciStart;j<ArticleList.cssci.size();j++){
				Article article=new Article();
				article=ArticleList.cssci.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				int id2=Integer.parseInt(ID2);
				
				if(id1==id2){
					//id�ڱ��е�һ�γ��ֵ�λ��
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
			
			
			
			//2.2 ͳ��ÿ����ʦSci�����������
			for(int j=sciStart;j<ArticleList.sci.size();j++){
				Article article=new Article();
				article=ArticleList.sci.elementAt(j);
				
				String ID2=article.getLoginID().replaceAll("[^a-zA-Z_0-9\u4e00-\u9fa5]", "");
				if(ID2.equals("NULL")) continue;
				int id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id�ڱ��е�һ�γ��ֵ�λ��
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
			//2.3 ͳ��ÿ����ʦData1�����������
			for(int j=data1Start;j<ArticleList.company_data1.size();j++){
				Article article=new Article();
				article=ArticleList.company_data1.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id�ڱ��е�һ�γ��ֵ�λ��
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
			
			//2.4 ͳ��ÿ����ʦData2�����������
			for(int j=data2Start;j<ArticleList.company_data2.size();j++){
				Article article=new Article();
				article=ArticleList.company_data2.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id�ڱ��е�һ�γ��ֵ�λ��
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
			
			//2.5 ͳ��ÿ����ʦData3�����������
			for(int j=data3Start;j<ArticleList.company_data3.size();j++){
				Article article=new Article();
				article=ArticleList.company_data3.elementAt(j);
				String ID2=article.getLoginID().replaceAll("[^0-9]", "");
				int id2=0;
				if(ID2.equals("")) id2=0;
				else id2=Integer.parseInt(ID2);
				if(id1==id2){
					//id�ڱ��е�һ�γ��ֵ�λ��
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
	
	//3����{Cssci��Sci}��{data1��data2��data3}֮�佨������
	public void createMap(){
		for(int i=0;i<TeacherList.teacher2017List.size();i++){
			
			Teacher teacher=TeacherList.teacher2017List.elementAt(i);
			String ID1=teacher.getLoginID().replaceAll("[^0-9]", "");
			int id1=Integer.parseInt(ID1);
			//System.out.println(teacher.getName()+" "+teacher.getLoginID());
			//System.out.println(teacher.getIdPlaceInCssci()+" "+teacher.getIdPlaceInSci()+" "+teacher.getIdPlaceInData1()+" "+teacher.getIdPlaceInData2()+" "+teacher.getIdPlaceInData3());
			//3.1 ��Cssci��ȥ��{data1��data2��data3}
			for(int j=0;j<teacher.getArticle_inCssci().size();j++){
				Article article1=teacher.getArticle_inCssci().elementAt(j);
				String norm_title_cn1=article1.getNorm_title_cn();
				//data1
				for(int k=0;k<teacher.getArticle_inData1().size();k++){
					Article article2=teacher.getArticle_inData1().elementAt(k);
					String norm_title_cn2=article2.getNorm_title_cn();
					//����idΪ19740060
//					if(id1==19620045){
//						System.out.println("norm_title_cn1:"+norm_title_cn1);
//						System.out.println("norm_title_cn2:"+norm_title_cn2);
//						System.out.println(norm_title_cn1.equals(norm_title_cn2));
//					}
					if(norm_title_cn1.equals(norm_title_cn2)){
						//��ȷ����ƥ���˶���ƪ��δȷ����ƥ���˶���ƪ
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
						placeInCssci=placeInCssci+"Cssci��ĵ�"+(j+teacher.getIdPlaceInCssci())+"��;";
						placeInData1=placeInData1+"data1��ĵ�"+(k+teacher.getIdPlaceInData1())+"��;";
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
						//��ȷ����ƥ���˶���ƪ��δȷ����ƥ���˶���ƪ
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
						placeInCssci=placeInCssci+"Cssci��ĵ�"+(j+teacher.getIdPlaceInCssci())+"��;";
						placeInData2=placeInData2+"data2��ĵ�"+(k+teacher.getIdPlaceInData2())+"��;";
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
						//��ȷ����ƥ���˶���ƪ��δȷ����ƥ���˶���ƪ
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
						placeInCssci=placeInCssci+"Cssci��ĵ�"+(j+teacher.getIdPlaceInCssci())+"��;";
						placeInData3=placeInData3+"data3��ĵ�"+(k+teacher.getIdPlaceInData3())+"��;";
						article2.setPlaceInCssci(placeInCssci);
						article1.setPlaceInData3(placeInData3);
						//System.out.println(article2.getTitle_cn()+placeInCssci+"   "+placeInData3);
					}
				}
			}
			//3.2 ��Sci��ȥ��{data1��data2��data3}
			for(int j=0;j<teacher.getArticle_inSci().size();j++){
				Article article1=teacher.getArticle_inSci().elementAt(j);
				String norm_title_en1=article1.getNorm_title_en();
				//data1
				for(int k=0;k<teacher.getArticle_inData1().size();k++){
					Article article2=teacher.getArticle_inData1().elementAt(k);
					String norm_title_en2=article2.getNorm_title_en();
					if(norm_title_en1.equals(norm_title_en2)){
						//��ȷ����ƥ���˶���ƪ��δȷ����ƥ���˶���ƪ
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
						placeInSci=placeInSci+"Sci��ĵ�"+(j+teacher.getIdPlaceInSci())+"��;";
						placeInData1=placeInData1+"data1��ĵ�"+(k+teacher.getIdPlaceInData1())+"��;";
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
						//��ȷ����ƥ���˶���ƪ��δȷ����ƥ���˶���ƪ
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
						placeInSci=placeInSci+"Sci��ĵ�"+(j+teacher.getIdPlaceInSci())+"��;";
						placeInData2=placeInData2+"data2��ĵ�"+(k+teacher.getIdPlaceInData2())+"��;";
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
						//��ȷ����ƥ���˶���ƪ��δȷ����ƥ���˶���ƪ
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
						placeInSci=placeInSci+"Sci��ĵ�"+(j+teacher.getIdPlaceInSci())+"��;";
						placeInData3=placeInData3+"data3��ĵ�"+(k+teacher.getIdPlaceInData3())+"��;";
						article2.setPlaceInSci(placeInSci);
						article1.setPlaceInData3(placeInData3);
						//System.out.println(article2.getTitle_en()+placeInSci+"   "+placeInData3);
					}
				}
			}
		}
	}
	//4������Ϣ(���¶�Ӧ��ӳ���ϵ)�������
	public void writeExcel(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.modifyExcel_Cssci(ArticleList.cssci, "myRes/��������/CssciANDCSCD_��������.xls", "myRes/ans/CssciANDCSCD_��������_modify.xls");
		excelOperation.modifyExcel_Sci(ArticleList.sci, "myRes/��������/sci_��������.xls", "myRes/ans/sci_��������_modify.xls");
		excelOperation.modifyExcel_DataCompany(ArticleList.company_data1, "myRes/��������/��������1-����.xls", "myRes/ans/��������1-����_modify.xls");
		excelOperation.modifyExcel_DataCompany(ArticleList.company_data2, "myRes/��������/��������2-����.xls", "myRes/ans/��������2-����_modify.xls");
		excelOperation.modifyExcel_DataCompany(ArticleList.company_data3, "myRes/��������/��������3-����.xls", "myRes/ans/��������3-����_modify.xls");
		
		//5�������µ�ƥ������д��ÿ����ʦ����������������
		excelOperation.modifyExcel_ArticleNum(TeacherList.teacher2017List, "myRes/��������/ÿ����ʦ����������.xls", "myRes/ans/ÿ����ʦ����������_modify.xls");
		
	}
	
	//��Ӣ����������ȫ��Ū��Сд����׼��
	public String en_norm(String src){
		return src.toLowerCase();
	}
	
	
}
