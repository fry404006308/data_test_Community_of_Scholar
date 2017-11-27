package com.fry.test;

import java.util.Vector;

import com.fry.controller.CountArticlePerTeacher;
import com.fry.controller.ExcelOperation;
import com.fry.controller.MatchArticle_3;
import com.fry.controller.MatchTeacherList;
import com.fry.model.ArticleList;
import com.fry.model.Teacher;
import com.fry.model.TeacherList;

import junit.framework.TestCase;

public class JunitTest extends TestCase{
	//��ȡ
	public void testExcelOperation(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/2017���ڲ�����_��������.xls");
	}
	public void testExcelOperation2(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_Arrange(TeacherList.teacherArrange, "myRes/��Ա��Ϣ����-20160325-���İ�.xls");
	}
	public void testMatchTeacherList(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/2017���ڲ�����_��������.xls");
		excelOperation.readExcel_Arrange(TeacherList.teacherArrange, "myRes/��Ա��Ϣ����-20160325-���İ�.xls");
		MatchTeacherList matchTeacherList=new MatchTeacherList();
		matchTeacherList.match_2017_arrange(TeacherList.teacher2017List, TeacherList.teacherArrange);
	}
	public void testExcelOperation3(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.modifyExcel_2017(null, "myRes/2017���ڲ�����_��������.xls", "myRes/2017���ڲ�����_��������1.xls");
	}
	public void testExcelOperation4(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/2017���ڲ�����_��������.xls");
		excelOperation.readExcel_Arrange(TeacherList.teacherArrange, "myRes/��Ա��Ϣ����-20160325-���İ�.xls");
		MatchTeacherList matchTeacherList=new MatchTeacherList();
		Vector<Teacher> match_2017_arrange=matchTeacherList.match_2017_arrange(TeacherList.teacher2017List, TeacherList.teacherArrange);
		excelOperation.modifyExcel_2017(match_2017_arrange, "myRes/2017���ڲ�����_��������.xls", "myRes/2017���ڲ�����_��������_��ӻ���.xls");
	}
	
	/*******************֮ǰ�Ĳ���******************************************************************************************/
	//�������еı�
	public void testExcelOperation1(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/��������/2017���ڲ�����_��������.xls");
		excelOperation.readExcel_cssci(ArticleList.cssci, "myRes/��������/CssciANDCSCD_��������.xls");
		excelOperation.readExcel_sci(ArticleList.sci, "myRes/��������/sci_��������.xls");
		excelOperation.readExcel_data(ArticleList.company_data1, "myRes/��������/��������1-����.xls");
		excelOperation.readExcel_data(ArticleList.company_data2, "myRes/��������/��������2-����.xls");
		excelOperation.readExcel_data(ArticleList.company_data3, "myRes/��������/��������3-����.xls");
	}
	//����ÿ��ְԱ��������
	public void testCountArticlePerTeacher(){
		//�������еı�
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/��������/2017���ڲ�����_��������.xls");
		excelOperation.readExcel_cssci(ArticleList.cssci, "myRes/��������/CssciANDCSCD_��������.xls");
		excelOperation.readExcel_sci(ArticleList.sci, "myRes/��������/sci_��������.xls");
		excelOperation.readExcel_data(ArticleList.company_data1, "myRes/��������/��������1-����.xls");
		excelOperation.readExcel_data(ArticleList.company_data2, "myRes/��������/��������2-����.xls");
		excelOperation.readExcel_data(ArticleList.company_data3, "myRes/��������/��������3-����.xls");
		
		//����ÿ��ְԱ��������
		CountArticlePerTeacher countArticlePerTeacher = new CountArticlePerTeacher();
		countArticlePerTeacher.countCssci2(TeacherList.teacher2017List, ArticleList.cssci);
		countArticlePerTeacher.countSci2(TeacherList.teacher2017List, ArticleList.sci);
		countArticlePerTeacher.countData(TeacherList.teacher2017List, ArticleList.company_data1);
		countArticlePerTeacher.countData(TeacherList.teacher2017List, ArticleList.company_data2);
		countArticlePerTeacher.countData(TeacherList.teacher2017List, ArticleList.company_data3);
		
		//���
		excelOperation.writeExcel_2017(TeacherList.teacher2017List, "myRes/ans/ÿ����ʦ����������.xls");
	}
	//��ÿ����ʦ��������
	public void testMatchArticle_3(){
		MatchArticle_3 matchArticle_3=new MatchArticle_3();
		matchArticle_3.giveTeacherArticle();
		matchArticle_3.createMap();
		matchArticle_3.writeExcel();
	}
}
