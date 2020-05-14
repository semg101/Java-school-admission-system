package roseindia.tutorial.application.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="roll_no")
	private int rollNo;

	@Column(name="name")
	private String name;

	@Column(name="course")
	private int course;

	@Column(name="address")
	private String address;

	@Column(name="phone_no")
	private Long phoneNo;

	@Column(name="admission_date")
	private Timestamp admissinDate;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Timestamp getAdmissinDate() {
		return admissinDate;
	}

	public void setAdmissinDate(Timestamp admissinDate) {
		this.admissinDate = admissinDate;
	}

}