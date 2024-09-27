package com.example.demo.repository;

import com.example.demo.entity.ExpenseLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseLimitRepository extends JpaRepository<ExpenseLimit, Long> {
}
