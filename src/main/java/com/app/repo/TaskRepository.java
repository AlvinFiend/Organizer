package com.app.repo;

import com.app.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getByDate(Date date);

    void deleteById(long id);

    Task findById(long id);
}
