package entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="course_enrollment")
public class CourseEnrollment {
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="next_step_no")
	private int nextStepNo;
	
	private int progress;
	
	@Column(name="date_started")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStarted;
	
	// mappings
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference(value="user-course-enrollment")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	// gets and sets
	public int getNextStepNo() {
		return nextStepNo;
	}

	public void setNextStepNo(int nextStepNo) {
		this.nextStepNo = nextStepNo;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getId() {
		return Id;
	}

	// toString
	@Override
	public String toString() {
		return "CourseEnrollment [Id=" + Id + ", nextStepNo=" + nextStepNo + ", progress=" + progress + ", dateStarted="
				+ dateStarted + "]";
	}
}
