package com.linkedin.taskmanager.service;

import com.linkedin.taskmanager.model.Task;
import com.linkedin.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testUpdateTaskStatus(){
        //arrange
        Task task = new Task(1L,"need to update", "to do");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        //act
        Task updatedTask = taskService.updateTaskStatus(1L,"in progress");

        //asserts

        assertNotNull(updatedTask);
        assertEquals("in progress",updatedTask.getStatus());

    }

}
