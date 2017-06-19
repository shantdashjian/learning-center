package test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;

public class UserTest {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private User user = null;

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
	
	@Test
	public void test_user_mappings() {
		user = entityManager.find(User.class, 1);    

	    assertThat(user,
	        allOf(
	        	hasProperty("id", is(1)),	           
	        	hasProperty("email", is("student@theceshop.com")),	           
	        	hasProperty("password", is("student"))          
	      )  
	     );
	}
	
	@Test
	public void test_course_enrollment_association() {
	     user = entityManager.find(User.class, 1);
	     int expectedOutcome = 2;
	     assertEquals(expectedOutcome, user.getCourseEnrollments().size());
	     
	  }
}
