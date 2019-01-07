package app.dao.topic;

import app.entity.Topic;

import java.util.List;

public interface TopicDao {
    List<Topic> getAllTopic();

    Topic getTopicById(String id);

    void insertTopic(Topic topic);

    void updateTopic(Topic topic);

    void deleteTopicById(String id);
}
