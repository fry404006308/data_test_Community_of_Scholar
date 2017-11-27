package com.fry.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import com.fry.model.Article;
import com.fry.model.Teacher;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelOperation {
	//�����µ�ƥ������д��ÿ����ʦ����������������
	public void modifyExcel_ArticleNum(Vector<Teacher> teacherList, String filenameStart, String filenameEnd) {
		try {
			Workbook rwb = Workbook.getWorkbook(new File(filenameStart));
			WritableWorkbook wwb = Workbook.createWorkbook(new File(filenameEnd), rwb);// copy
			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			WritableFont wfc2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc2);
			WritableSheet ws = wwb.getSheet(0);
			Label label6 = new Label(6, 0, "��ѧУ���ݿ��ҵ�����ȷ�ϱ��������(���ظ�)", wcfFC);
			Label label7 = new Label(7, 0, "��ѧУ���ݿ��ҵ���δȷ�ϱ��������(���ظ�)", wcfFC);
			ws.addCell(label6);
			ws.addCell(label7);
			// ��д���������
			for (int i = 0; i < teacherList.size(); i++) {
				Teacher teacher = teacherList.elementAt(i);
				int matchSure=teacher.getMatchSure();
				int matchNotSure=teacher.getMatchNotSure();
				
				label6 = new Label(6, i + 1, matchSure+"", wcfFC);
				label7 = new Label(7, i + 1, matchNotSure+"", wcfFC);
				ws.addCell(label6);
				ws.addCell(label7);
			}

			wwb.write();
			wwb.close();
			rwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//�޸�Cssci�����ҵ��ı�֮��Ķ�Ӧ��ϵд��������
		public void modifyExcel_DataCompany(Vector<Article> articleList, String filenameStart, String filenameEnd) {
			try {
				Workbook rwb = Workbook.getWorkbook(new File(filenameStart));
				WritableWorkbook wwb = Workbook.createWorkbook(new File(filenameEnd), rwb);// copy
				WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
						UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
				WritableCellFormat wcfFC = new WritableCellFormat(wfc);
				WritableSheet ws = wwb.getSheet(0);
				Label label6 = new Label(6, 0, "Cssci�з��ַ�", wcfFC);
				Label label7 = new Label(7, 0, "Sci�з��ַ�", wcfFC);
				ws.addCell(label6);
				ws.addCell(label7);
				// ��д���������
				for (int i = 0; i < articleList.size(); i++) {
					Article article = articleList.elementAt(i);
					String placeInCssci=article.getPlaceInCssci();
					String placeInSci=article.getPlaceInSci();
					
					label6 = new Label(6, i + 1, placeInCssci, wcfFC);
					label7 = new Label(7, i + 1, placeInSci, wcfFC);
					ws.addCell(label6);
					ws.addCell(label7);
				}

				wwb.write();
				wwb.close();
				rwb.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//�޸�Sci�����ҵ��ı�֮��Ķ�Ӧ��ϵд��������
		public void modifyExcel_Sci(Vector<Article> articleList, String filenameStart, String filenameEnd) {
			try {
				Workbook rwb = Workbook.getWorkbook(new File(filenameStart));
				WritableWorkbook wwb = Workbook.createWorkbook(new File(filenameEnd), rwb);// copy
				WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
						UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
				WritableCellFormat wcfFC = new WritableCellFormat(wfc);
				WritableSheet ws = wwb.getSheet(0);
				Label label4 = new Label(4, 0, "data1�з��ַ�", wcfFC);
				Label label5 = new Label(5, 0, "data2�з��ַ�", wcfFC);
				Label label6 = new Label(6, 0, "data3�з��ַ�", wcfFC);
				ws.addCell(label4);
				ws.addCell(label5);
				ws.addCell(label6);
				// ��д���������
				for (int i = 0; i < articleList.size(); i++) {
					Article article = articleList.elementAt(i);
					String placeInData1=article.getPlaceInData1();
					String placeInData2=article.getPlaceInData2();
					String placeInData3=article.getPlaceInData3();
					label4 = new Label(4, i + 1, placeInData1, wcfFC);
					label5 = new Label(5, i + 1, placeInData2, wcfFC);
					label6 = new Label(6, i + 1, placeInData3, wcfFC);
					ws.addCell(label4);
					ws.addCell(label5);
					ws.addCell(label6);
				}

				wwb.write();
				wwb.close();
				rwb.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//�޸�Cssci�����ҵ��ı�֮��Ķ�Ӧ��ϵд��������
	public void modifyExcel_Cssci(Vector<Article> articleList, String filenameStart, String filenameEnd) {
		try {
			Workbook rwb = Workbook.getWorkbook(new File(filenameStart));
			WritableWorkbook wwb = Workbook.createWorkbook(new File(filenameEnd), rwb);// copy
			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			WritableSheet ws = wwb.getSheet(0);
			Label label10 = new Label(10, 0, "data1�з��ַ�", wcfFC);
			Label label11 = new Label(11, 0, "data2�з��ַ�", wcfFC);
			Label label12 = new Label(12, 0, "data3�з��ַ�", wcfFC);
			ws.addCell(label10);
			ws.addCell(label11);
			ws.addCell(label12);
			// ��д���������
			for (int i = 0; i < articleList.size(); i++) {
				Article article = articleList.elementAt(i);
				String placeInData1=article.getPlaceInData1();
				String placeInData2=article.getPlaceInData2();
				String placeInData3=article.getPlaceInData3();
				label10 = new Label(10, i + 1, placeInData1, wcfFC);
				label11 = new Label(11, i + 1, placeInData2, wcfFC);
				label12 = new Label(12, i + 1, placeInData3, wcfFC);
				ws.addCell(label10);
				ws.addCell(label11);
				ws.addCell(label12);
			}

			wwb.write();
			wwb.close();
			rwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// ���ͳ��ÿλ��ʦ��������
	// �������ûд��
	public void writeExcel_2017(Vector<Teacher> teacherList, String filename) {
		OutputStream os;
		try {
			os = new FileOutputStream(new File(filename));
			// ����������
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			// �����µ�һҳ
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);

			Label label0 = new Label(0, 0, "LoginId", wcfFC);
			Label label1 = new Label(1, 0, "����", wcfFC);
			Label label2 = new Label(2, 0, "Cssci����", wcfFC);
			Label label3 = new Label(3, 0, "Sci����", wcfFC);
			Label label4 = new Label(4, 0, "��ȷ������", wcfFC);
			Label label5 = new Label(5, 0, "δȷ������", wcfFC);
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);

			int cnt = 1;
			for (int i = 0; i < teacherList.size(); i++) {
				Teacher teacher = teacherList.get(i);
				label0 = new Label(0, cnt, teacher.getLoginID());
				label1 = new Label(1, cnt, teacher.getName());
				label2 = new Label(2, cnt, teacher.getCssciNum() + "", wcfFC);
				label3 = new Label(3, cnt, teacher.getSciNum() + "", wcfFC);
				label4 = new Label(4, cnt, teacher.getSureNum() + "", wcfFC);
				label5 = new Label(5, cnt, teacher.getNotSureNum() + "", wcfFC);
				sheet.addCell(label0);
				sheet.addCell(label1);
				sheet.addCell(label2);
				sheet.addCell(label3);
				sheet.addCell(label4);
				sheet.addCell(label5);
				cnt++;
			}
			// �Ѵ���������д�뵽������У����ر������
			workbook.write();
			workbook.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector<Article> readExcel_data(Vector<Article> articleList, String filename) {
		try {
			File file = new File(filename); // �����ļ�����
			Workbook wb = Workbook.getWorkbook(file); // ���ļ����л�ȡExcel����������WorkBook��
			Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��Sheet��
			int n = sheet.getRows();
			int m = sheet.getColumns();
			Article article;
			String[] str = new String[m + 1];
			for (int i = 1; i < n; i++) { // ѭ����ӡExcel���е�����
				for (int j = 0; j < m; j++) {
					Cell cell = sheet.getCell(j, i);
					str[j] = cell.getContents() + "";
					// System.out.printf(str[j]);
				}
				article = new Article();
				article.setLoginID(str[1]);
				article.setTitle_cn(str[2]);
				article.setTitle_en(str[4]);
				article.setIrTag(str[5]);
				articleList.add(article);
				// System.out.println(str[1]+" "+str[2]+" "+str[4]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleList;
	}

	public Vector<Article> readExcel_sci(Vector<Article> articleList, String filename) {
		try {
			File file = new File(filename); // �����ļ�����
			Workbook wb = Workbook.getWorkbook(file); // ���ļ����л�ȡExcel����������WorkBook��
			Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��Sheet��
			int n = sheet.getRows();
			int m = sheet.getColumns();
			Article article;
			String[] str = new String[m + 1];
			for (int i = 1; i < n; i++) { // ѭ����ӡExcel���е�����
				for (int j = 0; j < m; j++) {
					Cell cell = sheet.getCell(j, i);
					str[j] = cell.getContents() + "";
					// System.out.printf(str[j]);
				}
				article = new Article();
				article.setLoginID(str[1]);
				article.setAuthor(str[2]);
				article.setTitle_en(str[10]);
				articleList.add(article);
				// System.out.println(str[1]+" "+str[2]+" "+str[10]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleList;
	}

	public Vector<Article> readExcel_cssci(Vector<Article> articleList, String filename) {
		try {
			File file = new File(filename); // �����ļ�����
			Workbook wb = Workbook.getWorkbook(file); // ���ļ����л�ȡExcel����������WorkBook��
			Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��Sheet��
			int n = sheet.getRows();
			int m = sheet.getColumns();
			Article article;
			String[] str = new String[m + 1];
			for (int i = 1; i < n; i++) { // ѭ����ӡExcel���е�����
				for (int j = 0; j < m; j++) {
					Cell cell = sheet.getCell(j, i);
					str[j] = cell.getContents() + "";
					// System.out.printf(str[j]);
				}
				article = new Article();
				article.setLoginID(str[1]);
				article.setAuthor(str[2]);
				article.setTitle_cn(str[3]);
				articleList.add(article);
				// System.out.println(str[1]+" "+str[2]+" "+str[3]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleList;
	}

	public Vector<Teacher> readExcel_2017(Vector<Teacher> teacherList, String filename) {
		try {
			File file = new File(filename); // �����ļ�����
			Workbook wb = Workbook.getWorkbook(file); // ���ļ����л�ȡExcel����������WorkBook��
			Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��Sheet��
			int n = sheet.getRows();
			int m = sheet.getColumns();
			Teacher teacher;
			String[] str = new String[m + 1];
			for (int i = 1; i < n; i++) { // ѭ����ӡExcel���е�����
				for (int j = 0; j < m; j++) {
					Cell cell = sheet.getCell(j, i);
					str[j] = cell.getContents() + "";
					// System.out.printf(str[j]);
				}
				teacher = new Teacher();
				teacher.setLoginID(str[0]);
				teacher.setName(str[1]);
				teacherList.add(teacher);
				// if(i==5) break;
				// System.out.println(str[0]+" "+str[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherList;
	}

	public Vector<Teacher> readExcel_Arrange(Vector<Teacher> teacherList, String filename) {
		try {
			File file = new File(filename); // �����ļ�����
			Workbook wb = Workbook.getWorkbook(file); // ���ļ����л�ȡExcel����������WorkBook��
			Sheet sheet = wb.getSheet(0); // �ӹ�������ȡ��ҳ��Sheet��
			int n = sheet.getRows();
			int m = sheet.getColumns();
			Teacher teacher;
			String[] str = new String[m + 1];
			for (int i = 1; i < n; i++) { // ѭ����ӡExcel���е�����
				for (int j = 0; j < m; j++) {
					Cell cell = sheet.getCell(j, i);
					str[j] = cell.getContents() + "";
					// System.out.printf(str[j]);
				}
				teacher = new Teacher();
				teacher.setLoginID(str[0]);
				teacher.setName(str[1]);
				teacher.setFirstIns(str[2]);
				teacher.setSecondIns(str[3]);
				teacher.setThirdIns(str[4]);
				teacherList.add(teacher);
				// System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]+"
				// "+str[4]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherList;
	}

	public void modifyExcel_2017(Vector<Teacher> teacherList, String filenameStart, String filenameEnd) {
		try {
			Workbook rwb = Workbook.getWorkbook(new File(filenameStart));
			WritableWorkbook wwb = Workbook.createWorkbook(new File(filenameEnd), rwb);// copy
			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			WritableSheet ws = wwb.getSheet(0);
			Label label5 = new Label(5, 0, "һ������", wcfFC);
			Label label6 = new Label(6, 0, "��������", wcfFC);
			Label label7 = new Label(7, 0, "��������", wcfFC);
			ws.addCell(label5);
			ws.addCell(label6);
			ws.addCell(label7);
			// ��д���������
			for (int i = 0; i < teacherList.size(); i++) {
				Teacher teacher = teacherList.elementAt(i);
				String firstIns = teacher.getFirstIns();
				String secondIns = teacher.getSecondIns();
				String thirdIns = teacher.getThirdIns();
				label5 = new Label(5, i + 1, firstIns, wcfFC);
				label6 = new Label(6, i + 1, secondIns, wcfFC);
				label7 = new Label(7, i + 1, thirdIns, wcfFC);
				ws.addCell(label5);
				ws.addCell(label6);
				ws.addCell(label7);
			}

			wwb.write();
			wwb.close();
			rwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
