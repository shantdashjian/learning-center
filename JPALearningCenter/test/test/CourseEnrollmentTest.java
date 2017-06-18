package test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Course;
import entities.CourseEnrollment;
import entities.User;


public class CourseEnrollmentTest {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private CourseEnrollment courseEnrollment = null;

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
	public void test_course_enrollment_mappings() {
		courseEnrollment = entityManager.find(CourseEnrollment.class, 1);    

	    assertThat(courseEnrollment,
	        allOf(
	        	hasProperty("id", is(1)),	           
	        	hasProperty("nextStepNo", is(1)),	           
	        	hasProperty("progress", is(0))  
	      )  
	     );
	}
	
	@Test
	public void test_date_started_temporal() {
		courseEnrollment = entityManager.find(CourseEnrollment.class, 1);    
		assertEquals("2017-06-18 00:00:00.0", courseEnrollment.getDateStarted().toString());
	}
	
	@Test
	public void test_user_association() {
		courseEnrollment = entityManager.find(CourseEnrollment.class, 1);
	     User user = courseEnrollment.getUser();
	     assertEquals(1, user.getId());
	     assertEquals("student@theceshop.com", user.getEmail());	     
	  }
	
	@Test
	public void test_course_association() {
		courseEnrollment = entityManager.find(CourseEnrollment.class, 1);
	     Course course = courseEnrollment.getCourse();
	     assertEquals(1, course.getId());
	     assertEquals("Real Estate Concepts: Part 1", course.getName());	     
	  }
	
}

