package data;

import java.util.HashSet;
import java.util.List;

import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import entities.Course;
import entities.CourseEnrollment;
import entities.User;

@Transactional
@Repository
public class AuthDAOImpl implements AuthDAO {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private EnrollmentDAO courseEnrollmentDAO;	
	
	@Override
	public User register(User user) {
		String passwordSha = encoder.encode(user.getPassword());
		user.setPassword(passwordSha);
		em.persist(user);
		em.flush();
		// Enroll user in all courses
		// 1. Get all course
		List<Course> courses = courseDAO.index();
		// 2. For each course enroll the user
		courses.forEach((course) -> {
			System.out.println(course);
			String courseEnrollmentJson = Json.createObjectBuilder()
					.add("nextStepNo", "1")
					.add("progress", "0")
					.build()
					.toString();
			System.out.println(courseEnrollmentJson);
			courseEnrollmentDAO.create(user.getId(), course.getId(), courseEnrollmentJson);
		});
		
		return user;
	}

	@Override
	public User login(User user) {
		User managedUser = null;
		try {
			String q = "SELECT u FROM User u JOIN FETCH u.courseEnrollments WHERE u.email = :email";
			managedUser = em.createQuery(q, User.class).setParameter("email", user.getEmail()).getSingleResult();
			if (encoder.matches(user.getPassword(), managedUser.getPassword())) {
				return managedUser;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			String q = "SELECT u FROM User u WHERE u.email = :email";
			managedUser = em.createQuery(q, User.class).setParameter("email", user.getEmail()).getSingleResult();
			managedUser.setCourseEnrollments(new HashSet<CourseEnrollment>());
			if (encoder.matches(user.getPassword(), managedUser.getPassword())) {
				return managedUser;
			} else {
				return null;
			}
		}
	}
}
