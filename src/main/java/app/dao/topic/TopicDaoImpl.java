package app.dao.topic;

import app.dao.topic.mappers.TopicMapper;
import app.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TopicDaoImpl implements TopicDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_TOPIC =
            "SELECT id, name, description FROM topics";
    private static final String SELECT_TOPIC_BY_ID =
            "SELECT id, name, description FROM topics WHERE id = ?";
    private static final String INSERT_TOPIC =
            "INSERT INTO topics (id, name, description) VALUES (?, ?, ?)";
    private static final String UPDATE_TOPIC =
            "UPDATE topics SET name = ?, description = ? WHERE id = ?";
    private static final String DELETE_TOPIC_BY_ID =
            "DELETE FROM topics WHERE id = ?";

    @Autowired
    public TopicDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Topic> getAllTopic() {
        return jdbcTemplate.query(SELECT_ALL_TOPIC,
                new TopicMapper());
    }

    @Override
    public Topic getTopicById(String id) {
        return jdbcTemplate.queryForObject(SELECT_TOPIC_BY_ID,
                new TopicMapper(),
                id);
    }

    @Override
    public void insertTopic(Topic topic) {
        jdbcTemplate.update(INSERT_TOPIC,
                topic.getId(),
                topic.getName(),
                topic.getDescription());
    }

    @Override
    public void updateTopic(Topic topic) {
        jdbcTemplate.update(UPDATE_TOPIC,
                topic.getName(),
                topic.getDescription(),
                topic.getId());
    }

    @Override
    public void deleteTopicById(String id) {
        jdbcTemplate.update(DELETE_TOPIC_BY_ID, id);
    }
}
