package net.myapi.springboot.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

// kimenő könyv adat, amit visszaadok "availableCopies": 100,
//    "idBook": 1,
//    "publicationYear": "1999-01-01T00:00:00.000Z",
//    "title": "micimacko"
@JsonPropertyOrder({ "idBook", "title", "publicationYear", "availableCopies" })
public class BookResponseDto {

    private Integer idBook;
    private String title;
    private Integer publicationYear;
    private Integer availableCopies;

    public BookResponseDto(){}

    public BookResponseDto(Integer idBook, String title, Integer publicationYear, Integer availableCopies) {
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
