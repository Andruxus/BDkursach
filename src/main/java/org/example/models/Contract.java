package org.example.models;

import javax.persistence.*;

@Entity
@Table(name="contract")
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="count")
    private int count;
    @Column(name="sum")
    private int sum;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tours_id")
    private Tour tour;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="worker_id")
    private Worker worker;
    public Contract(){

    }

    public Contract(int id, int count, int sum, Client client, Tour tour, Worker worker) {
        this.id = id;
        this.count = count;
        this.sum = sum;
        this.client = client;
        this.tour = tour;
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
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
