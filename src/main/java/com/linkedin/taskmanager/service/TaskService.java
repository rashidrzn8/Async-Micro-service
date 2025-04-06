package com.linkedin.taskmanager.service;

import com.linkedin.taskmanager.model.Task;
import com.linkedin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task updateTaskStatus(Long id, String status){
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()){
            Task t= task.get();
            t.setStatus(status);
            return taskRepository.save(t);
        }
        return null;
    }
}
