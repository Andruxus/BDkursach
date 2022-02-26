package org.example.services;

import org.example.dao.*;
import org.example.models.*;
import org.example.dao.TourDAO;
import org.example.models.Tour;

import java.util.List;

public class TourService {
    private TourDAO tourDAO = new TourDAO();

    public TourService() {
    }

    public Tour findClient(int id) {
        return tourDAO.findById(id);
    }

    public void saveClient(Tour tour) {
        tourDAO.save(tour);
    }


    public void updateClient(Tour tour) {
        tourDAO.update(tour);
    }

    public List<Tour> findAllUsers() {
        return tourDAO.findAll();
    }


}
