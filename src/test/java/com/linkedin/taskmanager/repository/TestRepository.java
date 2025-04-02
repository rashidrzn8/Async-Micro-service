package com.linkedin.taskmanager.repository;

import com.linkedin.taskmanager.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TestRepository {
    @Autowired
    TaskRepository taskRepository;
    @Test
    void testSaveTask(){
        Task task = new Task("domo","to do");


       Task savedTask =  taskRepository.save(task);

        assertNotNull(savedTask);
        assertEquals("to do", savedTask.getTitle());
    }

    @Test
    void testDeleteTask(){
        //arrange
        Task task = new Task("demo","demo");

        //act
        taskRepository.save(task);
        taskRepository.delete(task);

        Optional<Task> deletedTask = taskRepository.findById(task.getId());


        //asserts

        assertFalse(deletedTask.isPresent());
    }

    @Test
    void testFindAllTask(){

        //arrange
        Task task1= new Task("test1","test1");
        taskRepository.save(task1);
        Task task2= new Task("test2","test2");
        taskRepository.save(task2);

        //act
        List<Task> allTask = taskRepository.findAll();

        assertEquals(2,allTask.size());

    }

    @Test
    void testFindTaskById(){
        //arrange
        Task task1= new Task("test1","test1");
        taskRepository.save(task1);

        Optional<Task> task = taskRepository.findById(task1.getId());

        assertFalse(task.isEmpty());
    }

    @Test
    void testUpdateTask(){
        Task task1= new Task("test1","test1");
        taskRepository.save(task1);

        task1.setStatus("demo2");
        taskRepository.save(task1);
        Optional<Task> task = taskRepository.findById(task1.getId());

        assertEquals(task1.getStatus(),task.get().getStatus());
    }
}
