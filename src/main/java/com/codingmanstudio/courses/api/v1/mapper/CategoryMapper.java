package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.CategoryDTO;
import com.codingmanstudio.courses.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDto(Category category);
}
