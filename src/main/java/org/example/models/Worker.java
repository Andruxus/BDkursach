package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="secondname")
    private String secondName;
    @Column(name="numbers")
    private String numbers;
    @OneToMany(mappedBy = "worker",cascade = CascadeType.ALL)
    private List<Comment> comments;
    public Worker(){}

    public Worker(int id, String firstName, String secondName, String numbers) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.numbers = numbers;
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
}
