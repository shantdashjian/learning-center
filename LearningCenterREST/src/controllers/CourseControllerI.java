package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Course;

public interface CourseControllerI {	
	
	//  GET /course
    public Collection<Course> index(HttpServletRequest req, HttpServletResponse res);
}