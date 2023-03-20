package com.serverside.Api.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    private int id;

    @Column(name = "sender_id")
    private Long sender_id;


    @Column(name = "receiver_id")
    private Long receiver_id;


    @Column(name = "amount")
    private double amount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transaction(Long sender, Long receiver, double amount) {

        this.sender_id = sender;
        this.receiver_id = receiver;
        this.amount = amount;
    }

    public Transaction() {
    }
}
