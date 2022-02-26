package org.example.services;

import org.example.dao.*;
import org.example.models.*;
import org.example.dao.FeedDAO;
import org.example.models.Feed;

import java.util.List;

public class FeedService {
    private FeedDAO feedDAO = new FeedDAO();

    public FeedService() {
    }

    public Feed findClient(int id) {
        return feedDAO.findById(id);
    }

    public void saveClient(Feed feed) {
        feedDAO.save(feed);
    }

    public void deleteClient(Feed feed) {
        feedDAO.delete(feed);
    }

    public void updateClient(Feed feed) {
        feedDAO.update(feed);
    }

    public List<Feed> findAllUsers() {
        return feedDAO.findAll();
    }


}
