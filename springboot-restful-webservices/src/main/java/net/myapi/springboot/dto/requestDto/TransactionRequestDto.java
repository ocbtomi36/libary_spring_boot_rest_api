package net.myapi.springboot.dto.requestDto;

import java.time.LocalDate;
public class TransactionRequestDto {

    private LocalDate returnDate;

    private Integer userId;
    private Integer bookId;

    public TransactionRequestDto() {}

    public TransactionRequestDto(LocalDate returnDate, Integer userId, Integer bookId) {
        this.returnDate = returnDate;
        this.userId = userId;
        this.bookId = bookId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
