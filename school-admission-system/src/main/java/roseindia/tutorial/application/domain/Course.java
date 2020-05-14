package roseindia.tutorial.application.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "duration")
	private String duration;

	@Column(name = "fee")
	private Integer fee;

	@Column(name = "admission_open_on")
	private Timestamp admissionOpenOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Timestamp getAdmissionOpenOn() {
		return admissionOpenOn;
	}

	public void setAdmissionOpenOn(Timestamp admissionOpenOn) {
		this.admissionOpenOn = admissionOpenOn;
	}
}