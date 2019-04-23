package com.app.service.impl;

import com.app.domain.Task;
import com.app.repo.TaskRepository;
import com.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void remove(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getByDate(Date date) {
        return taskRepository.getByDate(date);
    }

    @Override
    public void removeById(long id) {
        taskRepository.deleteById(id);
    }
}
