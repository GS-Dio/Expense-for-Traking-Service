package com.example.demo.controller;

import com.example.demo.dto.ExpenseLimitDTO;
import com.example.demo.service.ExpenseLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/limits")
public class ExpenseLimitController {

    @Autowired
    private ExpenseLimitService expenseLimitService;
    @PostMapping
    public ResponseEntity<ExpenseLimitDTO> setExpenseLimit(@RequestBody ExpenseLimitDTO expenseLimitDTO) {
        ExpenseLimitDTO createdLimit = expenseLimitService.setExpenseLimit(expenseLimitDTO);
        return ResponseEntity.ok(createdLimit);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseLimitDTO>> getAllLimits() {
        List<ExpenseLimitDTO> limits = expenseLimitService.getAllLimits();
        return ResponseEntity.ok(limits);
    }
}
