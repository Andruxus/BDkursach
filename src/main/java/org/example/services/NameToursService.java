package org.example.services;

import org.example.dao.*;
import org.example.models.*;
import org.example.dao.NameToursDAO;
import org.example.models.NameTours;

import java.util.List;

public class NameToursService {
    private NameToursDAO nameToursDAO = new NameToursDAO();

    public NameToursService() {
    }

    public NameTours findClient(int id) {
        return nameToursDAO.findById(id);
    }

    public void saveClient(NameTours nameTours) {
        nameToursDAO.save(nameTours);
    }

    public void deleteClient(NameTours nameTours) {
        nameToursDAO.delete(nameTours);
    }

    public void updateClient(NameTours nameTours) {
        nameToursDAO.update(nameTours);
    }

    public List<NameTours> findAllUsers() {
        return nameToursDAO.findAll();
    }


}
