package org.example.models;

import javax.persistence.*;

@Entity
@Table(name="hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="rating")
    private int rating;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tours_id")
    private Tour tours;

    public Tour getTours() {
        return tours;
    }

    public void setTours(Tour tours) {
        this.tours = tours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Hotel(){}

    public Hotel(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

}
