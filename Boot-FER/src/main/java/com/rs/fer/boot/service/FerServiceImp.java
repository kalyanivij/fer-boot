package com.rs.fer.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rs.fer.boot.bean.Expense;
import com.rs.fer.boot.bean.User;
import com.rs.fer.boot.repository.ExpenseRepository;
import com.rs.fer.boot.repository.UserRepository;

@Service
@Transactional
public class FerServiceImp implements FerService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ExpenseRepository expenseRepository;

	

	@Override
	public boolean addExpense(Expense expense) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Expense editExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	@Override
	public Expense deleteExpense(Expense expense) {
		expenseRepository.delete(expense);
		return expense;
	}

	@Override
	public void reset(int id, String currentPassword, String newPassword) {

	}

	@Override
	public Expense findById(int id) {
		Expense expense = expenseRepository.findOne(id);
		return expense;
	}

	@Override
	public User getUser(int id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<Expense> getExpenses() {
		return (List<Expense>) expenseRepository.findAll();
	}

	@Override
	public List<Expense> expenseReport(String expense_type, String fromDate, String toDate) {

		return (List<Expense>) expenseRepository.findAll();
	}

	@Override
	public void registration(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

}
