package com.example.practices.domain.repository;

import com.example.practices.domain.dto.PaymentDto;

import java.util.List;
import java.util.Optional;

public interface IPaymentRepository {
    List<PaymentDto> getAll();
    Optional<List<PaymentDto>> getByClient(String clientId);
    PaymentDto save(PaymentDto paymentDto);
}
