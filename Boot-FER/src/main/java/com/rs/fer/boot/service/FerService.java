package com.rs.fer.boot.service;

import java.util.List;

import com.rs.fer.boot.bean.Expense;
import com.rs.fer.boot.bean.User;

public interface FerService {
	
	// registration
			public void registration(User user);

		//login
			public void login(String username, String password);

		//addExpense
			boolean addExpense(Expense expense);

		//editExpense
			 public Expense editExpense(Expense expense);

		//deletExpense
			public Expense deleteExpense(Expense expense);

		//reset password
			 void reset(int id, String currentPassword, String newPassword);

		//get expenses
			 List<Expense> getExpenses();

		//get expense
		 Expense findById(int id);

		//expense report
			List<Expense> expenseReport(String expense_type, String fromDate, String toDate);

		//get user
			User getUser(int id);

		//update user
			 public User updateUser(User user);


	}

