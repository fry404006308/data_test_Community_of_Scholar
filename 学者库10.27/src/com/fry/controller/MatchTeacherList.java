package com.fry.controller;

import java.util.Vector;

import com.fry.model.Teacher;

public class MatchTeacherList {
	//把teacherList2017和teacherListArrange匹配的结果放在teacherList2017表里面
	public Vector<Teacher> match_2017_arrange(Vector<Teacher> teacherList2017,Vector<Teacher> teacherListArrange){
		for(int i=0;i<teacherList2017.size();i++){
			Teacher teacher1=teacherList2017.elementAt(i);
			String ID1=teacher1.getLoginID().replaceAll("[^a-zA-Z_\u4e00-\u9fa5]1-9", "");
			//String ID1=teacher1.getLoginID().replaceAll("\\ ", "");
			for(int j=0;j<teacherListArrange.size();j++){
				Teacher teacher2=teacherListArrange.elementAt(j);
				String ID2=teacher2.getLoginID().replaceAll("[^a-zA-Z_\u4e00-\u9fa5]1-9", "");
				//String ID2=teacher2.getLoginID().replaceAll("\\ ", "");
				if(ID2.equals(ID1)){
					//System.out.println(ID1);
					teacher1.setFirstIns(teacher2.getFirstIns());
					teacher1.setSecondIns(teacher2.getSecondIns());
					teacher1.setThirdIns(teacher2.getThirdIns());
				}
			}
			//System.out.println(teacher1.getLoginID()+" "+teacher1.getName()+" "+teacher1.getFirstIns()+" "+teacher1.getSecondIns()+" "+teacher1.getThirdIns());
		}
		return teacherList2017;
	}
}
