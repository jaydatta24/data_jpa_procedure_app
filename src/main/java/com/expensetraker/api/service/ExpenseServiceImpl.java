package com.expensetraker.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.expensetraker.api.entity.Expense;
import com.expensetraker.api.exceptions.ResourceNotFoundException;
import com.expensetraker.api.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Page<Expense> getallExpenses(Pageable page) {
		return expenseRepository.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {

		Optional<Expense> expense = expenseRepository.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense Is not found By id " + id);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepository.deleteById(id);

	}

	@Override
	public Expense saveExpenseDetails(Expense expese) {
		return expenseRepository.save(expese);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);
		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
		existingExpense.setDescription(
				expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());

		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		existingExpense
				.setCategery(expense.getCategery() != null ? expense.getCategery() : existingExpense.getCategery());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		return expenseRepository.save(existingExpense);

	}

	@Override
	public List<Expense> readByCategory(String category, Pageable pageable) {
		
		return null;
	}

}
