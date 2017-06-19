package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.CourseEnrollment;

public interface CourseEnrollmentControllerI {
//    GET /user/{uid}/courseEnrollment
    public Collection<CourseEnrollment> index(HttpServletRequest req, HttpServletResponse res, int uid);
    
//    GET /user/{uid}/courseEnrollment/{ceid}
    public CourseEnrollment show(HttpServletRequest req, HttpServletResponse res, int uid, int ceid);
    
//    POST /user/{uid}/courseEnrollment/{cid}
    public CourseEnrollment create(HttpServletRequest req, HttpServletResponse res, int uid, int cid, String courseEnrollmentJson);
    
//    PUT /user/{uid}/courseEnrollment/{ceid}
    public CourseEnrollment update(HttpServletRequest req, HttpServletResponse res, int uid, int ceid, String courseEnrollmentJson);
    
//    DELETE /user/{uid}/courseEnrollment/{ceid}
    public Boolean destroy(HttpServletRequest req, HttpServletResponse res, int uid,int ceid);
}