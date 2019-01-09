package app.dao.course;

import app.dao.course.mappers.CourseMapper;
import app.dao.topic.TopicDaoImpl;
import app.entity.Course;
import app.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_COURSE_BY_TOPIC_ID =
            "SELECT id, name, description, topic_id FROM courses WHERE topic_id = ?";
    private static final String SELECT_COURSE_BY_ID =
            "SELECT id, name, description, topic_id FROM courses WHERE id = ? AND topic_id = ?";
    private static final String INSERT_COURSE =
            "INSERT INTO courses (id, name, description, topic_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_COURSE =
            "UPDATE courses SET name = ?, description = ? WHERE id = ? AND topic_id = ?";
    private static final String DELETE_COURSE_BY_ID =
            "DELETE FROM courses WHERE id = ? AND topic_id = ?";

    @Autowired
    public CourseDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Course> getAllCourseByTopicId(String topicId) {
        Topic topic = new TopicDaoImpl(jdbcTemplate.getDataSource()).getTopicById(topicId);
        List<Course> courses = jdbcTemplate.query(SELECT_ALL_COURSE_BY_TOPIC_ID,
                new Object[] {topicId},
                new CourseMapper());
        courses.forEach(course -> course.setTopic(topic));

        return courses;
    }

    @Override
    public Course getCourseById(String id, String topicId) {
        Topic topic = new TopicDaoImpl(jdbcTemplate.getDataSource()).getTopicById(topicId);
        Course course = jdbcTemplate.queryForObject(SELECT_COURSE_BY_ID,
                new CourseMapper(),
                id,
                topicId);
        course.setTopic(topic);

        return course;
    }

    @Override
    public void insertCourse(Course course) {
        jdbcTemplate.update(INSERT_COURSE,
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getTopic().getId());
    }

    @Override
    public void updateCourse(Course course) {
        jdbcTemplate.update(UPDATE_COURSE,
                course.getName(),
                course.getDescription(),
                course.getId(),
                course.getTopic().getId());
    }

    @Override
    public void deleteCourseById(String id, String topicId) {
        jdbcTemplate.update(DELETE_COURSE_BY_ID, id, topicId);
    }
}
