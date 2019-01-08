package app.dao.course.mappers;

import app.entity.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(rs.getString("id"));
        course.setName(rs.getString("name"));
        course.setDescription(rs.getString("description"));
        course.setTopicId(rs.getString("topic_id"));

        return course;
    }
}
