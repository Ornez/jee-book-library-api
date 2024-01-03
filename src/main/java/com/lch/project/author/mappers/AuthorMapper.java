package com.lch.project.author.mappers;

import com.lch.project.author.dtos.AddAuthorDto;
import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.author.model.Author;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
@Repository
public interface AuthorMapper {
    AuthorDto mapAuthorToAuthorDto(Author author);
    Author mapAddAuthorDtoToAuthor(AddAuthorDto addAuthorDto);
}
