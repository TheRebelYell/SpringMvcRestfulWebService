package app.service.topic;

import app.dao.topic.TopicDao;
import app.entity.Topic;
import app.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicDao.getAllTopic();
    }

    @Override
    public Topic getTopicById(String id) {
        return topicDao.getTopicById(id);
    }

    @Override
    public void insertTopic(Topic topic) {
        topicDao.insertTopic(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        topicDao.updateTopic(topic);
    }

    @Override
    public void deleteTopicById(String id) {
        topicDao.deleteTopicById(id);
    }
}
