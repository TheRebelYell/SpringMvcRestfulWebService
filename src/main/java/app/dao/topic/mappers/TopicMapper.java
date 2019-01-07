package app.dao.topic.mappers;

import app.entity.Topic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicMapper implements RowMapper<Topic> {
    @Override
    public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topic topic = new Topic();
        topic.setId(rs.getString("id"));
        topic.setName(rs.getString("name"));
        topic.setDescription(rs.getString("description"));

        return topic;
    }
}
