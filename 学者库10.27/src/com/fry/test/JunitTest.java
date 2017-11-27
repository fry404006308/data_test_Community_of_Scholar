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
	//读取
	public void testExcelOperation(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/2017年在册名单_工号升序.xls");
	}
	public void testExcelOperation2(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_Arrange(TeacherList.teacherArrange, "myRes/人员信息整理-20160325-第四版.xls");
	}
	public void testMatchTeacherList(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/2017年在册名单_工号升序.xls");
		excelOperation.readExcel_Arrange(TeacherList.teacherArrange, "myRes/人员信息整理-20160325-第四版.xls");
		MatchTeacherList matchTeacherList=new MatchTeacherList();
		matchTeacherList.match_2017_arrange(TeacherList.teacher2017List, TeacherList.teacherArrange);
	}
	public void testExcelOperation3(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.modifyExcel_2017(null, "myRes/2017年在册名单_工号升序.xls", "myRes/2017年在册名单_工号升序1.xls");
	}
	public void testExcelOperation4(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/2017年在册名单_工号升序.xls");
		excelOperation.readExcel_Arrange(TeacherList.teacherArrange, "myRes/人员信息整理-20160325-第四版.xls");
		MatchTeacherList matchTeacherList=new MatchTeacherList();
		Vector<Teacher> match_2017_arrange=matchTeacherList.match_2017_arrange(TeacherList.teacher2017List, TeacherList.teacherArrange);
		excelOperation.modifyExcel_2017(match_2017_arrange, "myRes/2017年在册名单_工号升序.xls", "myRes/2017年在册名单_工号升序_添加机构.xls");
	}
	
	/*******************之前的测试******************************************************************************************/
	//读入所有的表
	public void testExcelOperation1(){
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/测试数据/2017年在册名单_工号升序.xls");
		excelOperation.readExcel_cssci(ArticleList.cssci, "myRes/测试数据/CssciANDCSCD_工号升序.xls");
		excelOperation.readExcel_sci(ArticleList.sci, "myRes/测试数据/sci_工号升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data1, "myRes/测试数据/厂商数据1-升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data2, "myRes/测试数据/厂商数据2-升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data3, "myRes/测试数据/厂商数据3-升序.xls");
	}
	//计算每个职员的文章数
	public void testCountArticlePerTeacher(){
		//读入所有的表
		ExcelOperation excelOperation=new ExcelOperation();
		excelOperation.readExcel_2017(TeacherList.teacher2017List, "myRes/测试数据/2017年在册名单_工号升序.xls");
		excelOperation.readExcel_cssci(ArticleList.cssci, "myRes/测试数据/CssciANDCSCD_工号升序.xls");
		excelOperation.readExcel_sci(ArticleList.sci, "myRes/测试数据/sci_工号升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data1, "myRes/测试数据/厂商数据1-升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data2, "myRes/测试数据/厂商数据2-升序.xls");
		excelOperation.readExcel_data(ArticleList.company_data3, "myRes/测试数据/厂商数据3-升序.xls");
		
		//计算每个职员的文章数
		CountArticlePerTeacher countArticlePerTeacher = new CountArticlePerTeacher();
		countArticlePerTeacher.countCssci2(TeacherList.teacher2017List, ArticleList.cssci);
		countArticlePerTeacher.countSci2(TeacherList.teacher2017List, ArticleList.sci);
		countArticlePerTeacher.countData(TeacherList.teacher2017List, ArticleList.company_data1);
		countArticlePerTeacher.countData(TeacherList.teacher2017List, ArticleList.company_data2);
		countArticlePerTeacher.countData(TeacherList.teacher2017List, ArticleList.company_data3);
		
		//打表
		excelOperation.writeExcel_2017(TeacherList.teacher2017List, "myRes/ans/每个老师的文章数量.xls");
	}
	//给每个老师分配文章
	public void testMatchArticle_3(){
		MatchArticle_3 matchArticle_3=new MatchArticle_3();
		matchArticle_3.giveTeacherArticle();
		matchArticle_3.createMap();
		matchArticle_3.writeExcel();
	}
}
