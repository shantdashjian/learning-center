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
@Table(name = "course")
public class Course {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String name;
	
	// mappings
	@OneToMany(mappedBy = "course")
	@JsonManagedReference(value = "course-course-progress")
	private Set<CourseProgress> courseProgresses;
	
	@OneToMany(mappedBy = "course")
	@JsonManagedReference(value = "course-step")
	private Set<Step> steps;
	
}
