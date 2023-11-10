package com.example.practices.persistence.mapper;

import com.example.practices.domain.dto.PaymentDto;
import com.example.practices.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPaymentItemMapper.class})
public interface IPaymentMapper {

    @Mappings({
            @Mapping( source = "idCompra", target = "paymentDtoId"),
            @Mapping( source = "idCliente", target = "clientId"),
            @Mapping( source = "fecha", target = "date"),
            @Mapping( source = "medioPago", target = "paymentMethod"),
            @Mapping( source = "comentario", target = "comment"),
            @Mapping( source = "estado", target = "state"),
            @Mapping( source = "comprasProductos", target = "items")
    })
    PaymentDto toPaymentDto(Compra compra);
    List<PaymentDto> toPaymentDtos( List<Compra> compras);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true)
    })
    Compra toCompra(PaymentDto paymentDto);
}
