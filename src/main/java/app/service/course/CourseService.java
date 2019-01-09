package app.service.course;

import app.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourseByTopic(String topicId);

    public Course getCourseById(String id, String topicId);

    public void insertCourse(Course course, String topicId);

    public void updateCourse(Course course, String topicId);

    public void deleteCourseById(String id, String topicId);
}
