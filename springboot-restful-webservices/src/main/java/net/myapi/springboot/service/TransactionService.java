package net.myapi.springboot.service;

import net.myapi.springboot.dto.requestDto.TransactionRequestDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDetailsDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDto;
import net.myapi.springboot.entity.Transaction;

import java.util.List;

public interface TransactionService {

    TransactionResponseDto createTransaction(TransactionRequestDto transactionRequestDto);

    TransactionResponseDto getTransactionById(Integer transactionId);

    TransactionResponseDetailsDto getTransactionDetailsById(Integer transactionId);

    List<Transaction> getAllTransactions();

}
