package org.snascimento.apimongo.repository;

import org.snascimento.apimongo.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
