package com.app.service;

import com.app.domain.Task;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface TaskService {

    Task save(@NonNull Task task);

    void remove(@NonNull Task task);

    List<Task> getAll();

    Task getById(long id);

    default Task getById(String id){
        return this.getById(Long.valueOf(id));
    }

    List<Task> getByDate(@NonNull Date date);

    void removeById(@NonNull long id);

    default void removeById(@NonNull String id){
        this.removeById(Long.valueOf(id));
    }
}
