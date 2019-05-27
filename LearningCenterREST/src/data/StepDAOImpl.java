package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import entities.Step;

@Transactional
public class StepDAOImpl implements StepDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Step> index(int cid) {
		String query = "SELECT step from Step step where step.course.id = :id";
		return em.createQuery(query, Step.class).setParameter("id", cid).getResultList();
	}

	@Override
	public Step show(int cid, int sid) {
		return em.find(Step.class, sid);
	}
}
