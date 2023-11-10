package com.example.practices.domain.dto;

public class PaymentItemDto {

    private int prodcutId;
    private int quantity;
    private double total;
    private boolean active;
    public int getProdcutId() {
        return prodcutId;
    }

    public void setProdcutId(int prodcutoId) {
        this.prodcutId = prodcutoId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
