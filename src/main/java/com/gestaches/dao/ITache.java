package com.gestaches.dao;

import com.gestaches.entities.Tache;

import java.util.List;

public interface ITache extends Repository <Tache>{

    void updateTaskStatus(long taskId, boolean newStatus);
    void deleteTask(long taskId);

    List<Tache> getAllTasks();
}
