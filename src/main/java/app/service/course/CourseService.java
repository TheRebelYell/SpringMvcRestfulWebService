package app.service.course;

import app.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourseByTopic(String topicId);

    public Course getCourseById(String id);

    public void insertCourse(Course course);

    public void updateCourse(Course course);

    public void deleteCourseById(String topicId, String id);
}
