package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import entities.Course;

@Transactional
public class CourseDAOImpl implements CourseDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Course> index() {
		String query = "SELECT course from Course course";
		return em.createQuery(query, Course.class).getResultList();
	}
}
