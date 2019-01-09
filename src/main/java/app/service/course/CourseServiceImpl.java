package app.service.course;

import app.dao.course.CourseDao;
import app.entity.Course;
import app.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourseByTopic(String topicId) {
        return courseDao.getAllCourseByTopicId(topicId);
    }

    @Override
    public Course getCourseById(String id, String topicId) {
        return courseDao.getCourseById(id, topicId);
    }

    @Override
    public void insertCourse(Course course, String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseDao.insertCourse(course);
    }

    @Override
    public void updateCourse(Course course, String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourseById(String id, String topicId) {
        courseDao.deleteCourseById(id, topicId);
    }
}
