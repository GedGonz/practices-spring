package com.example.practices.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PaymentDto {

    private int paymentDtoId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PaymentItemDto> items;

    public int getPaymentDtoId() {
        return paymentDtoId;
    }
    public void setPaymentDtoId(int paymentDtoId) {
        this.paymentDtoId = paymentDtoId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PaymentItemDto> getItems() {
        return items;
    }

    public void setItems(List<PaymentItemDto> item) {
        this.items = item;
    }
}
