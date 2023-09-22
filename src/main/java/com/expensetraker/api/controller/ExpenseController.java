package com.expensetraker.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expensetraker.api.entity.Expense;
import com.expensetraker.api.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expenses")
	public List<Expense> getExepense(Pageable page) {
		int number=1;
		calculatefactorial(number);
		return expenseService.getallExpenses(page).toList();
	}

	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable Long id) {
		return expenseService.getExpenseById(id);

	}

	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam Long id) {
		expenseService.deleteExpenseById(id);
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}

	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
		return expenseService.updateExpenseDetails(id, expense);
	}
	
	public int calculatefactorial(int number) {
		return number*calculatefactorial(number-1);
	}
}
