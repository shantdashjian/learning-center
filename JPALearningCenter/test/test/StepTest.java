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
import entities.Step;

public class StepTest {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private Step step = null;

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
	public void test_step_mappings() {
		step = entityManager.find(Step.class, 1);    

	    assertThat(step,
	        allOf(
	        	hasProperty("id", is(1)),	           
	        	hasProperty("stepNo", is(1)),	           
	        	hasProperty("title", is("Acceleration Clause")),          
	        	hasProperty("description", is("A clause in your mortgage which allows the lender to demand payment of the outstanding loan balance for various reasons. The most common reasons for accelerating a loan are if the borrower defaults on the loan or transfers title to another individual without informing the lender.")),          
	        	hasProperty("imageUrl", is("http://notequeen.com/wp-content/uploads/sites/45/2008/11/halloween.jpg")),          
	        	hasProperty("question", is("The acceleration clause allows the lender to demand payment.")),    
	        	hasProperty("answer", is("A"))   
	      )  
	     );
	}
	
	
	@Test
	public void test_course_association() {
	     step = entityManager.find(Step.class, 1);
	     Course course = step.getCourse();
	     assertEquals(1, course.getId());
	     assertEquals("Real Estate Concepts: Part 1", course.getName());	     
	  }
	
	
	
}

