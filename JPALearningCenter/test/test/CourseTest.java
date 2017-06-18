package test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Course;
import entities.CourseEnrollment;

public class CourseTest {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private Course course = null;

	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("LearningCenter");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_course_mappings() {
		course = entityManager.find(Course.class, 1);    

	    assertThat(course,
	        allOf(
	        	hasProperty("id", is(1)),	           
	        	hasProperty("name", is("Real Estate Concepts: Part 1"))    
	      )  
	     );
	}
	
	@Test
	public void test_course_enrollment_association() {
	     course = entityManager.find(Course.class, 1);
	     int expectedOutcome = 1;
	     assertEquals(expectedOutcome, course.getCourseEnrollment().size());
	     
	  }
	
	@Test
	public void test_step_association() {
	     course = entityManager.find(Course.class, 1);
	     int expectedOutcome = 3;
	     assertEquals(expectedOutcome, course.getSteps().size());
	     
	  }
	
	
}

