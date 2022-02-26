package org.example.models;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="text")
    private String text;
    @Column (name="role")
    private String role;
    @Column (name="name")
    private String name;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tours_id")
    private Tour tour;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="workers_id")
    private Worker worker;
    public Comment(){

    };

    public Comment(int id, String text, String role, String name) {
        this.id = id;
        this.text = text;
        this.role = role;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
