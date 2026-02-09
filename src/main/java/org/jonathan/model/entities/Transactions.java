package org.jonathan.model.entities;

import org.jonathan.model.Type;

import java.time.LocalDateTime;

public class Transactions {

    private Long id;
    private Long userId;
    private Long categoryId;
    private Type type;
    private double cost;
    private String description;
    private LocalDateTime transactionDate;

    public Transactions(Long id, Long userId, Long categoryId, Type type, double cost, String description, LocalDateTime transactionDate) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.type = type;
        this.cost = cost;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public Transactions(Long userId, Long categoryId, Type type, double cost, String description) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.type = type;
        this.cost = cost;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
