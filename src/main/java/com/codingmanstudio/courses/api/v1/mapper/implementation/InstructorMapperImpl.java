package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.InstructorDTO;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Instructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InstructorMapperImpl implements InstructorMapper {
    @Override
    public InstructorDTO instructorToInstructorDto(Instructor instructor) {
        if (instructor == null) {
            return null;
        } else {
            InstructorDTO instructorDTO = new InstructorDTO();
            instructorDTO.setUsername(instructor.getUsername());
            instructorDTO.setName(instructor.getName());
            instructorDTO.setCompany(instructor.getCompany());
            instructorDTO.setEmail(instructor.getEmail());
            instructorDTO.setImage(instructor.getImage());
            instructorDTO.setQuote(instructor.getQuote());
            instructorDTO.setCategories(this.categorySetToCategoryDTOSet(instructor.getCategories()));
            return instructorDTO;
        }
    }

    private CategoryDTO categoryToCategoryDTO(Category category){
        if(category == null){
            return null;
        }
        else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setDescription(category.getDescription());
            return categoryDTO;
        }
    }

    private Set<CategoryDTO> categorySetToCategoryDTOSet(Set<Category> categories){
       return categories.stream().map(this::categoryToCategoryDTO).collect(Collectors.toSet());
    }
}
