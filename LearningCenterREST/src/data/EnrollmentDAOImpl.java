package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Course;
import entities.CourseEnrollment;
import entities.User;

@Transactional
@Repository
public class EnrollmentDAOImpl implements EnrollmentDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<CourseEnrollment> index(int uid) {
		String query = "SELECT courseEnrollment from CourseEnrollment courseEnrollment "
				+ "where courseEnrollment.user.id = :id";
		return em.createQuery(query, CourseEnrollment.class).setParameter("id", uid).getResultList();
	}

	@Override
	public CourseEnrollment show(int uid, int ceid) {
		return em.find(CourseEnrollment.class, ceid);
	}

	@Override
	public CourseEnrollment create(int uid, int cid, String courseEnrollmentJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			CourseEnrollment mappedCourseEnrollment = mapper.readValue(courseEnrollmentJson, CourseEnrollment.class);
			User user = em.find(User.class, uid);
			Course course = em.find(Course.class, cid);
			mappedCourseEnrollment.setUser(user);
			mappedCourseEnrollment.setCourse(course);
			em.persist(mappedCourseEnrollment);
			em.flush();
			return mappedCourseEnrollment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CourseEnrollment update(int uid, int ceid, String courseEnrollmentJson) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			CourseEnrollment courseEnrollment = mapper.readValue(courseEnrollmentJson, CourseEnrollment.class);
			CourseEnrollment mappedCourseEnrollment = em.find(CourseEnrollment.class, ceid);
			mappedCourseEnrollment.setNextStepNo(courseEnrollment.getNextStepNo());
			mappedCourseEnrollment.setProgress(courseEnrollment.getProgress());			
			return mappedCourseEnrollment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean destroy(int uid, int ceid) {
		boolean flag = false;
		try {			
			em.remove(em.find(CourseEnrollment.class, ceid));
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
}
