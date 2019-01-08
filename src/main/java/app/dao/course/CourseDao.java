package app.dao.course;

import app.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourseByTopicId(String topicId);

    Course getCourseById(String id);

    void insertCourse(Course course);

    void updateCourse(Course course);

    void deleteCourseById(String topicId, String id);
}
