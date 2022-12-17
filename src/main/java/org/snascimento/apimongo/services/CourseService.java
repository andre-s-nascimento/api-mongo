package org.snascimento.apimongo.services;

import org.snascimento.apimongo.model.Course;
import org.snascimento.apimongo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
  @Autowired CourseRepository courseRepository;

  public List<Course> getAllCourses() {
    return courseRepository.findAll();
  }

  public Optional<Course> getCourse(String id) {
    return courseRepository.findById(id);
  }

  public void addCourse(Course course) {
    courseRepository.save(course);
  }

  public void updateCourse(Course course) {
    Course existingCourse = this.getCourse(course.getId()).get();
    Course updatedCourse =
        Course.builder()
            .id(existingCourse.getId())
            .name(course.getName())
            .description(course.getDescription())
            .build();
    courseRepository.save(updatedCourse);
  }

  public void deleteCourse(String id) {
    Course existingCourse = this.getCourse(id).get();
    courseRepository.delete(existingCourse);
  }
}
