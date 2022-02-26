package org.example.services;

import org.example.dao.*;
import org.example.models.*;
import org.example.dao.DiscountsDAO;
import org.example.models.Discounts;

import java.util.List;

public class DiscountsService {
    private DiscountsDAO discountsDAO = new DiscountsDAO();

    public DiscountsService() {
    }

    public Discounts findClient(int id) {
        return discountsDAO.findById(id);
    }

    public void saveClient(Discounts discounts) {
        discountsDAO.save(discounts);
    }

    public void deleteClient(Discounts discounts) {
        discountsDAO.delete(discounts);
    }

    public void updateClient(Discounts discounts) {
        discountsDAO.update(discounts);
    }

    public List<Discounts> findAllUsers() {
        return discountsDAO.findAll();
    }


}
