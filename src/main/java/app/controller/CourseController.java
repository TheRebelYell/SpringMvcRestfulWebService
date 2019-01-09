package app.controller;

import app.entity.Course;
import app.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/topics/{topicId}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getAllCourseByTopicId(@PathVariable String topicId) {
        return courseService.getAllCourseByTopic(topicId);
    }

    @GetMapping(value = "/topics/{topicId}/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourseById(@PathVariable String id, @PathVariable String topicId) {
        return courseService.getCourseById(id, topicId);
    }

    @PostMapping(value = "/topics/{topicId}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertCourse(@RequestBody Course course, @PathVariable String topicId) {
        courseService.insertCourse(course, topicId);
    }

    @PutMapping(value = "/topics/{topicId}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
        courseService.updateCourse(course, topicId);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id, @PathVariable String topicId) {
        courseService.deleteCourseById(id, topicId);
    }
}
