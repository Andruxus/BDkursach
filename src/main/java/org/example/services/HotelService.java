package org.example.services;

import org.example.dao.*;
import org.example.models.*;
import org.example.dao.HotelDAO;
import org.example.models.Hotel;

import java.util.List;

public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    public HotelService() {
    }

    public Hotel findClient(int id) {
        return hotelDAO.findById(id);
    }

    public void saveClient(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    public void deleteClient(Hotel hotel) {
        hotelDAO.delete(hotel);
    }

    public void updateClient(Hotel hotel) {
        hotelDAO.update(hotel);
    }

    public List<Hotel> findAllUsers() {
        return hotelDAO.findAll();
    }


}
