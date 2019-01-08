package app.service.course;

import app.dao.course.CourseDao;
import app.entity.Course;
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
    public Course getCourseById(String id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void insertCourse(Course course) {
        courseDao.insertCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourseById(String topicId, String id) {
        courseDao.deleteCourseById(topicId, id);
    }
}
