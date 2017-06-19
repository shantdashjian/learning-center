package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.CourseDAO;
import entities.Course;
import entities.CourseEnrollment;

@RestController
public class CourseControllerImpl implements CourseControllerI {

	@Autowired
	private CourseDAO courseDAO;
	
	// GET course
	@Override
	@RequestMapping(path = "course", method = RequestMethod.GET)
	public Collection<Course> index(HttpServletRequest req, HttpServletResponse res) {
		return courseDAO.index();
	}

}
