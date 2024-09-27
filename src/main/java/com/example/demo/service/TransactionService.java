package com.example.demo.service;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAccountFrom(transactionDTO.getAccountFrom());
        transaction.setAccountTo(transactionDTO.getAccountTo());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setCurrency(transactionDTO.getCurrency());
        transaction.setUsdAmount(transactionDTO.getUsdAmount());
        transaction.setCategory(transactionDTO.getCategory());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setLimitExceeded(false); // Логика определения лимита будет добавлена позже

        Transaction savedTransaction = transactionRepository.save(transaction);
        return convertToDTO(savedTransaction);
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionsOverLimit() {
        // Доработать логику определения лимита
        return transactionRepository.findAll().stream()
                .filter(Transaction::isLimitExceeded)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAccountFrom(transaction.getAccountFrom());
        dto.setAccountTo(transaction.getAccountTo());
        dto.setAmount(transaction.getAmount());
        dto.setCurrency(transaction.getCurrency());
        dto.setUsdAmount(transaction.getUsdAmount());
        dto.setCategory(transaction.getCategory());
        dto.setTransactionDate(transaction.getTransactionDate());
        dto.setLimitExceeded(transaction.isLimitExceeded());
        return dto;
    }
}
