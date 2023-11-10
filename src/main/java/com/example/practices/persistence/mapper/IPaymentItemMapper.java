package com.example.practices.persistence.mapper;

import com.example.practices.domain.dto.PaymentDto;
import com.example.practices.domain.dto.PaymentItemDto;
import com.example.practices.persistence.entity.Compra;
import com.example.practices.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IProductMapper.class})
public interface IPaymentItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "prodcutId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PaymentItemDto toPaymentItemDto(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PaymentItemDto paymentItemDto);
}
