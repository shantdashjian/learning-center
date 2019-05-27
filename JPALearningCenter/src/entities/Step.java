package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="step")
public class Step {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="step_no")
	private int stepNo;
	
	private String title;
	
	private String description;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private String question;
	
	private String answer;
	
	// mappings
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonBackReference(value="course-step")
	private Course course;

	// gets and sets
	public int getStepNo() {
		return stepNo;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getId() {
		return id;
	}

	// toString
	@Override
	public String toString() {
		return "Step [id=" + id + ", stepNo=" + stepNo + ", title=" + title + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", question=" + question + ", answer=" + answer + "]";
	}
}
