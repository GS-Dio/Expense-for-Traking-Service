package com.example.demo.service;

import com.example.demo.dto.ExpenseLimitDTO;
import com.example.demo.entity.ExpenseLimit;
import com.example.demo.repository.ExpenseLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseLimitService {

    @Autowired
    private ExpenseLimitRepository expenseLimitRepository;

    // Установка нового лимита
    public ExpenseLimitDTO setExpenseLimit(ExpenseLimitDTO expenseLimitDTO) {
        ExpenseLimit expenseLimit = new ExpenseLimit();
        expenseLimit.setLimitAmount(expenseLimitDTO.getLimitAmount());
        expenseLimit.setCategory(expenseLimitDTO.getCategory());
        expenseLimit.setSetDate(LocalDate.now());

        ExpenseLimit savedLimit = expenseLimitRepository.save(expenseLimit);
        return convertToDTO(savedLimit);
    }

    public List<ExpenseLimitDTO> getAllLimits() {
        return expenseLimitRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ExpenseLimitDTO convertToDTO(ExpenseLimit expenseLimit) {
        ExpenseLimitDTO dto = new ExpenseLimitDTO();
        dto.setId(expenseLimit.getId());
        dto.setLimitAmount(expenseLimit.getLimitAmount());
        dto.setCategory(expenseLimit.getCategory());
        dto.setSetDate(expenseLimit.getSetDate());
        return dto;
    }
}
