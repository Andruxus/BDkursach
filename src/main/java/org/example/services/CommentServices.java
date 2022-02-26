package org.example.services;

import org.example.dao.CommentDAO;
import org.example.models.Comment;

import java.util.List;

public class CommentServices {
    private CommentDAO commentDAO = new CommentDAO();

    public CommentServices() {
    }

    public Comment findClient(int id) {
        return commentDAO.findById(id);
    }

    public void saveClient(Comment comment) {
        commentDAO.save(comment);
    }

    public void deleteClient(Comment comment) {
        commentDAO.delete(comment);
    }

    public void updateClient(Comment comment) {
        commentDAO.update(comment);
    }

    public List<Comment> findAllUsers() {
        return commentDAO.findAll();
    }


}
