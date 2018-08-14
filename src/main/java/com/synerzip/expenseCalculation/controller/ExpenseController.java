package com.synerzip.expenseCalculation.controller;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.synerzip.expenseCalculation.model.Expense;
import com.synerzip.expenseCalculation.service.ExpenseService;

@RestController
@RequestMapping(path = "/user/expenses")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@PostMapping(path = "/{userId}")
	public Expense addExpense(@PathVariable int userId, @Valid @RequestBody Expense expense) {
		return expenseService.addExpense(userId, expense);
	}
	
	@GetMapping(path="/hello")
	public String hello(Authentication auth) {
		
		return "Hello " + auth.getName() + auth.getCredentials();
	}
	
	@GetMapping(path = "/{userId}")
	public Collection<Expense> viewAll(@PathVariable int userId) {
		return expenseService.getAll(userId);
		
	}
}
