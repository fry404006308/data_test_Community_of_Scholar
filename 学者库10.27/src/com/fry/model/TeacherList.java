package com.fry.model;

import java.util.Vector;

public class TeacherList {
	//2017��ʦ��
	public static Vector<Teacher> teacher2017List=new Vector<Teacher>();
	//��Ա�����
	public static Vector<Teacher> teacherArrange=new Vector<Teacher>();
	
	
	
	public Vector<Teacher> getTeacher2017List() {
		return teacher2017List;
	}
	public void setTeacher2017List(Vector<Teacher> teacher2017List) {
		this.teacher2017List = teacher2017List;
	}
	public Vector<Teacher> getTeacherArrange() {
		return teacherArrange;
	}
	public void setTeacherArrange(Vector<Teacher> teacherArrange) {
		this.teacherArrange = teacherArrange;
	}
	
	
}
