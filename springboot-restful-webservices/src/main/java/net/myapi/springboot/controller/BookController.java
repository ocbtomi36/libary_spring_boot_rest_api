package net.myapi.springboot.controller;

import net.myapi.springboot.dto.requestDto.BookRequestDto;
import net.myapi.springboot.dto.responseDto.BookResponseDto;
import net.myapi.springboot.service.BookService;
import net.myapi.springboot.validation.FieldValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    private void validate(BookRequestDto bookDto) {
        if(bookDto == null) {
            throw new IllegalArgumentException("book can't be null");
        }
        FieldValidator.notNullFieldValidate(bookDto.getTitle(),"Title", 100);
        FieldValidator.minusIntegerValidate(bookDto.getAvailableCopies(),"Available copies");
        FieldValidator.yearValidate(bookDto.getPublicationYear());
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook( @RequestBody BookRequestDto bookDto){
        validate(bookDto);
        BookResponseDto savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable("id") Integer bookId){
        BookResponseDto bookResponseDto = bookService.getBookById(bookId);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> booksResponseDto = bookService.getAllBooks();
        return new ResponseEntity<>(booksResponseDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookResponseDto> updateUser(@PathVariable("id") Integer bookId, @RequestBody BookRequestDto book) {
        validate(book);
        book.setIdBook(bookId);
        BookResponseDto updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }
}


