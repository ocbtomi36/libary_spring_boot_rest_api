package net.myapi.springboot.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"transactionId","name","title","publicationYear","availableCopies"})
public class TransactionResponseDetailsDto {

    private Integer transactionId;
    private String name;
    private String title;
    private LocalDate publicationYear;
    private Integer availableCopies;

    public TransactionResponseDetailsDto(){}

    public TransactionResponseDetailsDto(Integer transactionId,String name, String title, LocalDate publicationYear, Integer availableCopies) {
        this.transactionId = transactionId;
        this.name = name;
        this.title = title;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
