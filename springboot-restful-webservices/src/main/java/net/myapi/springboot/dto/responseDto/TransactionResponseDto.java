package net.myapi.springboot.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.myapi.springboot.entity.Book;
import net.myapi.springboot.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({ "idTransaction", "checkoutDate", "returnDate", "idBook", "idUser" })
public class TransactionResponseDto {

    private Integer idTransaction;

    private LocalDateTime checkoutDate; // book

    private LocalDate returnDate; // book

    private Integer idBook;

    private Integer idUser;

    public TransactionResponseDto(){}

    public TransactionResponseDto(Integer idTransaction, LocalDateTime checkoutDate, LocalDate returnDate, Integer idBook, Integer idUser) {
        this.idTransaction = idTransaction;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
        this.idBook = idBook;
        this.idUser = idUser;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
