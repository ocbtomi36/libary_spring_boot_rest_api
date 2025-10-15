package net.myapi.springboot.dto.requestDto;

import java.time.LocalDate;
public class BookRequestDto {

    private Integer idBook;
    private String title;

    private Integer publicationYear;

    private Integer availableCopies;

    public BookRequestDto(Integer idBook,String title, Integer publicationYear, Integer availableCopies) {
        this.idBook = idBook;
        this.title = title;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
