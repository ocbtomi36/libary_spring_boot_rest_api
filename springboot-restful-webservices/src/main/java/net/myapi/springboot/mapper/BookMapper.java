package net.myapi.springboot.mapper;

import net.myapi.springboot.dto.requestDto.BookRequestDto;
import net.myapi.springboot.dto.responseDto.BookResponseDto;
import net.myapi.springboot.entity.Book;

import java.time.LocalDate;


public class BookMapper {

    public static BookResponseDto mapToBookResponseDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto(book.getIdBook(), book.getTitle(), book.getPublicationYear().getYear(), book.getAvailableCopies());

        return bookResponseDto;
    }

    public static Book mapToBook(BookRequestDto bookDto) {
        Book book = new Book(bookDto.getTitle(),LocalDate.of(bookDto.getPublicationYear(),1,1),bookDto.getAvailableCopies());
        return book;
    }


}
