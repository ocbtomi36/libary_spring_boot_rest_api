package net.myapi.springboot.controller;

import net.myapi.springboot.dto.requestDto.TransactionRequestDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDetailsDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDto;
import net.myapi.springboot.service.TransactionService;
import net.myapi.springboot.validation.FieldValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {


    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        FieldValidator.idValidate(transactionRequestDto.getBookId(),"Book id");
        FieldValidator.idValidate(transactionRequestDto.getUserId(), "User id");
        FieldValidator.pastDateValidate(transactionRequestDto.getReturnDate());
        TransactionResponseDto savedTransaction = transactionService.createTransaction(transactionRequestDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable("id") Integer transactionId){
        TransactionResponseDto transactionResponseDto = transactionService.getTransactionById(transactionId);
        return new ResponseEntity<>(transactionResponseDto, HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<TransactionResponseDetailsDto> getTransactionDetailsById(@PathVariable("id") Integer transactionId){
        TransactionResponseDetailsDto transactionResponseDetailsDto = transactionService.getTransactionDetailsById(transactionId);
        return new ResponseEntity<>(transactionResponseDetailsDto,HttpStatus.OK);
    }
}
