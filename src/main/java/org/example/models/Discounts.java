package org.example.models;

import javax.persistence.*;

@Entity
@Table(name="discounts")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tours_id")
    private Tour tours;

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

    public Tour getTour() {
        return tours;
    }

    public void setTour(Tour tour) {
        this.tours = tour;
    }

    public Discounts(){}

    public Discounts(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
