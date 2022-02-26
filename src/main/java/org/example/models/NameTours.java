package org.example.models;

import javax.persistence.*;

@Entity
@Table(name="nametours")
public class NameTours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tours_id")
    private Tour tours;

    public Tour getTours() {
        return tours;
    }

    public void setTours(Tour tours) {
        this.tours = tours;
    }

    public NameTours(){}

    public NameTours(int id, String name) {
        this.id = id;
        this.name = name;
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
}
