package data;

import java.util.List;

import entities.CourseEnrollment;

public interface EnrollmentDAO {
  public List<CourseEnrollment> index(int uid);
  public CourseEnrollment show(int uid, int ceid);
  public CourseEnrollment create(int uid, int cid, String courseEnrollmentJson);
  public CourseEnrollment update(int uid, int ceid, String courseEnrollmentJson);
  public Boolean destroy(int uid, int ceid);
}