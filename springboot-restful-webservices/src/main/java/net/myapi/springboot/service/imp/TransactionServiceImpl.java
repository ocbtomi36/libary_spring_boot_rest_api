package net.myapi.springboot.service.imp;

import net.myapi.springboot.dto.requestDto.TransactionRequestDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDetailsDto;
import net.myapi.springboot.dto.responseDto.TransactionResponseDto;
import net.myapi.springboot.entity.Book;
import net.myapi.springboot.entity.Transaction;
import net.myapi.springboot.entity.User;
import net.myapi.springboot.exception.NotMinusValueException;
import net.myapi.springboot.exception.ResourceNotFoundException;
import net.myapi.springboot.mapper.TransactionMapper;
import net.myapi.springboot.repository.BookRepository;
import net.myapi.springboot.repository.TransactionRepository;
import net.myapi.springboot.repository.UserRepository;
import net.myapi.springboot.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {


    private TransactionRepository transactionRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public TransactionResponseDto createTransaction(TransactionRequestDto transactionRequestDto) {

        User user = userRepository.findById(transactionRequestDto.getUserId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", transactionRequestDto.getUserId().longValue())
        );
        Book book = bookRepository.findById(transactionRequestDto.getBookId()).orElseThrow(
                () -> new ResourceNotFoundException("Book", "id", transactionRequestDto.getBookId().longValue())
        );

        Transaction transaction = TransactionMapper.mapToTransaction(transactionRequestDto);
        transaction.setBook(book);
        transaction.setUser(user);
        if(book.getAvailableCopies() <= 0) {
            throw new NotMinusValueException("Copy is null, there is no borrow possible");
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        Book setBook = bookRepository.save(book);
        Transaction savedTransaction = transactionRepository.save(transaction);
        TransactionResponseDto returnTransactionResponseDto = new TransactionResponseDto(savedTransaction.getIdTransaction(),savedTransaction.getCheckoutDate(),savedTransaction.getReturnDate(),book.getIdBook(),user.getIdUser());

        return returnTransactionResponseDto;
    }

    @Override
    public TransactionResponseDto getTransactionById(Integer transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction","id",transactionId.longValue())
        );
        TransactionResponseDto transactionResponseDto = TransactionMapper.mapToTransactionResponseDto(transaction);
        return transactionResponseDto;
    }

    @Override
    public TransactionResponseDetailsDto getTransactionDetailsById(Integer transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                () -> new ResourceNotFoundException("Transaction","id",transactionId.longValue())
        );
        User user = userRepository.findById(transaction.getUser().getIdUser()).orElseThrow(
                () -> new ResourceNotFoundException("User","id",transaction.getUser().getIdUser().longValue())
        );
        Book book = bookRepository.findById(transaction.getBook().getIdBook()).orElseThrow(
                () -> new ResourceNotFoundException("Book","id",transaction.getBook().getIdBook().longValue())
        );
        transaction.setUser(user);
        transaction.setBook(book);
        TransactionResponseDetailsDto transactionResponseDetailsDto = TransactionMapper.mapToTransactionResponseDetailsDto(transaction);
        return transactionResponseDetailsDto;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return null;
    }
}
