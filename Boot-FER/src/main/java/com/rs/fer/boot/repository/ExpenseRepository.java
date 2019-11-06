package com.rs.fer.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rs.fer.boot.bean.Expense;
public interface ExpenseRepository extends CrudRepository<Expense, Integer>
{
	
	//List<Expense> findByNameAndCountry(String name, String country);
}
