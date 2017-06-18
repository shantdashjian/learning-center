package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String password;

	// mappings
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private Set<CourseProgress> courseProgresses;

	// gets and sets
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<CourseProgress> getCourseProgresses() {
		return courseProgresses;
	}

	public void setCourseProgresses(Set<CourseProgress> courseProgresses) {
		this.courseProgresses = courseProgresses;
	}

	public int getId() {
		return id;
	}

	// toString
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
