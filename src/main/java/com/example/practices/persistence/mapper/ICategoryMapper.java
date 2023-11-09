package com.example.practices.persistence.mapper;

import com.example.practices.domain.dto.CategoryDto;
import com.example.practices.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active"),
    })
    CategoryDto toCategory(Categoria categoria);
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(CategoryDto categoryDto);

}
