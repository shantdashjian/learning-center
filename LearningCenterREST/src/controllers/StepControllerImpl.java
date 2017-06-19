package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.StepDAO;
import entities.CourseEnrollment;
import entities.Step;

@RestController
public class StepControllerImpl implements StepControllerI {
	
	@Autowired
	private StepDAO stepDAO;
	
	// GET ping
		@RequestMapping(path = "ping", method = RequestMethod.GET)
		public String ping() {
			return "pong";
		}
		
	//  GET /course/{cid}/step
	@Override
	@RequestMapping(path = "course/{cid}/step", method = RequestMethod.GET)
	public Collection<Step> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid) {
		return stepDAO.index(cid);
	}

	//  GET /course/{cid}/step/sid
	@Override
	@RequestMapping(path = "course/{cid}/step/sid", method = RequestMethod.GET)
	public Step show(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid, @PathVariable int sid) {
		Step result = stepDAO.show(cid, sid);
		if (result == null){
			res.setStatus(404);
		};
		return result;
	}

}
