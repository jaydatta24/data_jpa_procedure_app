package com.expensetraker.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expensetraker.api.entity.Expense;

public interface ExpenseService {
	
	Page<Expense> getallExpenses(Pageable page);
	Expense	getExpenseById(Long id);
	void deleteExpenseById(Long id);
	Expense saveExpenseDetails(Expense expese);
	Expense updateExpenseDetails(Long id,Expense expense);
	List<Expense> readByCategory(String category, Pageable pageable);
}
