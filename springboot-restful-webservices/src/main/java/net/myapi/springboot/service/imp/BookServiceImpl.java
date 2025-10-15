package net.myapi.springboot.service.imp;

import net.myapi.springboot.dto.requestDto.BookRequestDto;
import net.myapi.springboot.dto.responseDto.BookResponseDto;

import net.myapi.springboot.entity.Book;

import net.myapi.springboot.exception.DataAlreadyExistException;
import net.myapi.springboot.exception.ResourceNotFoundException;
import net.myapi.springboot.mapper.BookMapper;
import net.myapi.springboot.repository.BookRepository;
import net.myapi.springboot.service.BookService;
import net.myapi.springboot.validation.FieldValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponseDto createBook(BookRequestDto bookDto) {

        Optional<Book> bookTitle = bookRepository.findBookByTitle(bookDto.getTitle());
        FieldValidator.dataAlreadyExistValidate(bookTitle,"Title");
        Book book = BookMapper.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        BookResponseDto savedBookResponseDto = BookMapper.mapToBookResponseDto(savedBook);
        return savedBookResponseDto;
    }


    @Override
    public BookResponseDto getBookById(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "id", bookId.longValue())
        );
        BookResponseDto bookResponseDto = BookMapper.mapToBookResponseDto(book);
        return bookResponseDto;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> book = bookRepository.findAll();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (int i = 0; i < book.size(); i++) {
            BookResponseDto bookResponseDto = BookMapper.mapToBookResponseDto(book.get(i));
            bookResponseDtos.add(bookResponseDto);
        }
        return bookResponseDtos;
    }

    @Override
    public BookResponseDto updateBook(BookRequestDto book) {

        Book existingBook = bookRepository.findById(book.getIdBook()).orElseThrow(
                () -> new ResourceNotFoundException("Book", "id", book.getIdBook().longValue())
        );
        existingBook.setIdBook(book.getIdBook());
        Optional<Book> optionalDbBook = bookRepository.findBookByTitle(book.getTitle());
        if(!optionalDbBook.isEmpty()) {
            Book dbBook = optionalDbBook.get();
            if(!dbBook.getIdBook().equals(book.getIdBook())){
                throw new DataAlreadyExistException("Title is already exist in db");
            }
        }
        existingBook.setTitle(book.getTitle());
        existingBook.setAvailableCopies(book.getAvailableCopies());
        LocalDate bookDateToInsert = LocalDate.of(book.getPublicationYear(),1,1);
        existingBook.setPublicationYear(bookDateToInsert);
        Book updatingUser = bookRepository.save(existingBook);
        return BookMapper.mapToBookResponseDto(updatingUser);
    }
}
