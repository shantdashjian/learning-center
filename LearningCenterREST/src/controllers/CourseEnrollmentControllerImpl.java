package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.CourseEnrollmentDAO;
import entities.CourseEnrollment;

@RestController
public class CourseEnrollmentControllerImpl implements CourseEnrollmentControllerI {

	@Autowired
	private CourseEnrollmentDAO courseEnrollmentDAO;
	
	// GET ping
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
		
	// GET /user/{uid}/courseEnrollment
	@Override
	@RequestMapping(path = "user/{uid}/courseEnrollment", method = RequestMethod.GET)
	public Collection<CourseEnrollment> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
		return courseEnrollmentDAO.index(uid);
	}

	// GET /user/{uid}/courseEnrollment/{ceid}
	@Override
	@RequestMapping(path = "user/{uid}/courseEnrollment/{ceid}", method = RequestMethod.GET)
	public CourseEnrollment show(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int ceid) {
		CourseEnrollment result = courseEnrollmentDAO.show(uid, ceid);
		if (result == null){
			res.setStatus(404);
		};
		return result;
	}

	//  POST /user/{uid}/courseEnrollment/{cid}
	@Override
	@RequestMapping(path = "user/{uid}/courseEnrollment", method = RequestMethod.POST)
	public CourseEnrollment create(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int cid,
			@RequestBody String courseEnrollmentJson) {
		return courseEnrollmentDAO.create(uid, cid, courseEnrollmentJson);
	}

	//  PUT /user/{uid}/courseEnrollment/{ceid}
	@Override
	@RequestMapping(path = "user/{uid}/courseEnrollment/{ceid}", method = RequestMethod.PUT)
	public CourseEnrollment update(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int ceid,
			@RequestBody String courseEnrollmentJson) {
		return courseEnrollmentDAO.update(uid, ceid, courseEnrollmentJson);

	}
	//  DELETE /user/{uid}/courseEnrollment/{ceid}
	@Override
	@RequestMapping(path = "user/{uid}/courseEnrollment/{ceid}", method = RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int ceid) {
		return courseEnrollmentDAO.destroy(uid, ceid);
	}

}
