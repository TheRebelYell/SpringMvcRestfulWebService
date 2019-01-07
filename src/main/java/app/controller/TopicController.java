package app.controller;

import app.entity.Topic;
import app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/topics", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Topic> getAllTopic() {
        return topicService.getAllTopic();
    }

    @GetMapping(value = "/topics/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic getTopicById(@PathVariable String id) {
        return topicService.getTopicById(id);
    }

    @PostMapping(value = "/topics", produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertTopic(@RequestBody Topic topic) {
        topicService.insertTopic(topic);
    }

    @PutMapping(value = "/topics", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

    @DeleteMapping(value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopicById(id);
    }
}
