package app.service;

import app.entity.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopic();

    Topic getTopicById(String id);

    void insertTopic(Topic topic);

    void updateTopic(Topic topic);

    void deleteTopicById(String id);
}

