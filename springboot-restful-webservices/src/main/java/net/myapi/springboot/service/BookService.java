package net.myapi.springboot.service;

import net.myapi.springboot.dto.requestDto.BookRequestDto;
import net.myapi.springboot.dto.requestDto.UserRequestDto;
import net.myapi.springboot.dto.responseDto.BookResponseDto;
import net.myapi.springboot.dto.responseDto.UserResponseDto;
import net.myapi.springboot.entity.Book;

import java.util.List;

public interface BookService {

    BookResponseDto createBook(BookRequestDto bookDto);

    BookResponseDto getBookById(Integer bookId);

    List<BookResponseDto> getAllBooks();

    BookResponseDto updateBook(BookRequestDto book);


}
