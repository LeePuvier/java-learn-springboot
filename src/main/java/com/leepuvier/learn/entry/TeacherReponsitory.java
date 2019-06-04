package com.leepuvier.learn.entry;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherReponsitory extends MongoRepository<Teacher, Integer> {
    Teacher findByName(String name);
}
