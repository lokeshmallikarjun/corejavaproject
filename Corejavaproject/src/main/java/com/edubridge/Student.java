package com.edubridge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studenttable")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)//autoincrement
@Column(name="StudentId")
int studentId;

@Column(name="StudentName",length=40,nullable=false)
String studentName;

@Column(name="StudentAddress",length=50)
String studentAddress;

@Column(name="StudentContact")
String studentContact;

@Column(name="StudentGrade",length=50)
 String studentGrade;

public String getStudentContact() {
	return studentContact;
}

public void setStudentContact(String studentContact) {
	this.studentContact = studentContact;
}

public String getStudentGrade() {
	return studentGrade;
}

public void setStudentGrade(String studentGrade) {
	this.studentGrade = studentGrade;
}

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public String getStudentAddress() {
	return studentAddress;
}

public void setStudentAddress(String studentAddress) {
	this.studentAddress = studentAddress;
}

@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
			+ ", studentContact=" + studentContact + ", studentGrade=" + studentGrade + "]";


}

}
