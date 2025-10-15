package net.myapi.springboot.mapper;


import net.myapi.springboot.dto.requestDto.TransactionRequestDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDetailsDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDto;
import net.myapi.springboot.entity.Transaction;

import java.time.LocalDateTime;

public class TransactionMapper {

    public static TransactionResponseDto mapToTransactionResponseDto(Transaction transaction) {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transaction.getIdTransaction(), transaction.getCheckoutDate(),transaction.getReturnDate(),transaction.getBook().getIdBook(), transaction.getUser().getIdUser());
        return transactionResponseDto;
    }
    public static Transaction mapToTransaction(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = new Transaction(LocalDateTime.now(), transactionRequestDto.getReturnDate());
        return transaction;
    }
    public static TransactionResponseDetailsDto mapToTransactionResponseDetailsDto(Transaction transaction){
        TransactionResponseDetailsDto transactionResponseDetailsDto = new TransactionResponseDetailsDto(transaction.getIdTransaction(),transaction.getUser().getName(),transaction.getBook().getTitle(),transaction.getBook().getPublicationYear(),transaction.getBook().getAvailableCopies());
        return transactionResponseDetailsDto;
    }

}
