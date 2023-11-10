package com.example.practices.domain.service;

import com.example.practices.domain.dto.PaymentDto;
import com.example.practices.domain.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    public List<PaymentDto> getAll(){
        return paymentRepository.getAll();
    }
    public Optional<List<PaymentDto>> getByClient(String clientId){
        return paymentRepository.getByClient(clientId);
    }
    public PaymentDto save(PaymentDto paymentDto){
        return  paymentRepository.save(paymentDto);
    }
}
