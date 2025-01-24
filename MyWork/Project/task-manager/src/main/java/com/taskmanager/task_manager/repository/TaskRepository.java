package com.taskmanager.task_manager.repository;

import com.taskmanager.task_manager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
