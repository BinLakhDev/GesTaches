package com.gestaches.dao;

import com.gestaches.entities.Tache;

import java.util.List;

public class TacheImplement extends RepositoryImplement <Tache> implements ITache {

    @Override
    public void updateTaskStatus(long taskId, boolean newStatus) {

    }

    @Override
    public void deleteTask(long taskId) {

    }

    @Override
    public List<Tache> getAllTasks() {
        return null;
    }

}
