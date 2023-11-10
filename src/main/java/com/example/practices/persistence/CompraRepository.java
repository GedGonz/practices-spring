package com.example.practices.persistence;

import com.example.practices.domain.dto.PaymentDto;
import com.example.practices.domain.repository.IPaymentRepository;
import com.example.practices.persistence.crud.ICompraCrudRepository;
import com.example.practices.persistence.entity.Compra;
import com.example.practices.persistence.mapper.IPaymentItemMapper;
import com.example.practices.persistence.mapper.IPaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements IPaymentRepository {


    @Autowired
    private ICompraCrudRepository compraCrudRepository;
    @Autowired
    private IPaymentMapper paymentMapper;
    @Override
    public List<PaymentDto> getAll() {
        var result=(List<Compra>) compraCrudRepository.findAll();
        return paymentMapper.toPaymentDtos(result);
    }

    @Override
    public Optional<List<PaymentDto>> getByClient(String clientId) {
        Optional<List<Compra>> compras= compraCrudRepository.findByIdCliente(clientId);
        return compras.map(resp-> paymentMapper.toPaymentDtos(resp));
    }

    @Override
    public PaymentDto save(PaymentDto paymentDto) {
        Compra compra = paymentMapper.toCompra(paymentDto);
        compra.getComprasProductos().forEach(producto -> producto.setCompra(compra));
        return paymentMapper.toPaymentDto(compraCrudRepository.save(compra));
    }
}
