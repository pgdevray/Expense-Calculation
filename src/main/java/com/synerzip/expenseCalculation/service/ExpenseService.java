package com.synerzip.expenseCalculation.service;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.synerzip.expenseCalculation.model.Category;
import com.synerzip.expenseCalculation.model.Expense;
import com.synerzip.expenseCalculation.model.User;
import com.synerzip.expenseCalculation.repository.ExpenseRepository;
import com.synerzip.expenseCalculation.repository.UserRepository;

@Service
public class ExpenseService {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ExpenseRepository expenseRepository;

	public Expense addExpense(int userId, Expense expense) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		expense.setUser(user);//set userid only
		Category category = categoryService.findByCategoryName(expense.getCategoryName());
		expense.setCategory(category);
		return expenseRepository.save(expense);
	}
	
	public Collection<Expense> getAll(int userId) {
		
		Collection<Expense> allExpenses = expenseRepository.findAllByUserId(userId);
		return allExpenses;
		
	}
}
