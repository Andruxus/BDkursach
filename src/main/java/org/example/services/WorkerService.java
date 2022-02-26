package org.example.services;

import org.example.dao.*;
import org.example.models.*;
import org.example.dao.WorkerDAO;
import org.example.models.Worker;

import java.util.List;

public class WorkerService {
    private WorkerDAO workerDAO = new WorkerDAO();

    public WorkerService() {
    }

    public Worker findClient(int id) {
        return workerDAO.findById(id);
    }

    public void saveClient(Worker worker) {
        workerDAO.save(worker);
    }

    public void deleteClient(Worker worker) {
        workerDAO.delete(worker);
    }

    public void updateClient(Worker worker) {
        workerDAO.update(worker);
    }

    public List<Worker> findAllUsers() {
        return workerDAO.findAll();
    }


}
