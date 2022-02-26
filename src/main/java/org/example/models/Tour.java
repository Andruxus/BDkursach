package org.example.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "date")
    private Date date;
    @Column(name = "country")
    private String country;
    @Column(name = "operator")
    private String operator;
    @Column(name = "people")
    private int people;
    @Column(name = "days")
    private int days;
    @OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Countries> countries;
    @OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feed> feeds;
    @OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NameTours> nameTours;
    @OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discounts> discounts;
    @OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotel> hotels;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public List<NameTours> getNameTours() {
        return nameTours;
    }

    public void setNameTours(List<NameTours> nameTours) {
        this.nameTours = nameTours;
    }

    public List<Discounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discounts> discounts) {
        this.discounts = discounts;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Tour(String name, String price, Date date, String country, String operator, int people, int days) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.country = country;
        this.operator = operator;
        this.people = people;
        this.days = days;
        this.countries = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.feeds = new ArrayList<>();
        this.nameTours = new ArrayList<>();
        this.hotels = new ArrayList<>();
    }

    public Tour() {
    }

}


