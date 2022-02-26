package org.example.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Table(name="client", uniqueConstraints = {@UniqueConstraint(name="numbers",columnNames = {"numbers"})})
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="secondname")
    private String secondName;
    @Column(name="numbers",unique=true)
    private String numbers;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    public Client(){}

    public Client(String firstName, String secondName, String numbers) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.numbers = numbers;
        this.comments = new ArrayList<>();
    }


    public void addComment(Comment comment)
    {
        comment.setClient(this);
        comments.add(comment);
    }
    public void removeComent(Comment comment){
        comments.remove(comment);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String toString(List<Client> clients) {
        String s = "Client:";
        for (Client tou : clients) {
            s += tou.getFirstName() + " " + tou.getSecondName() + " " + tou.getNumbers() + "\n";
        }
        return s;
    }
}
