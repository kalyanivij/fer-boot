package com.rs.fer.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rs.fer.boot.bean.Expense;
import com.rs.fer.boot.bean.User;
import com.rs.fer.boot.service.FerService;

@RestController
@RequestMapping(value = { "/user" })
public class FerController {
	@Autowired
	FerService ferService;

	/*
	 * @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
	 * System.out.println("Fetching User with id " + id); User user =
	 * userService.findById(id); if (user == null) { return new
	 * ResponseEntity<User>(HttpStatus.NOT_FOUND); } return new
	 * ResponseEntity<User>(user, HttpStatus.OK); }
	 */

	@PostMapping(value = "/add", headers = "Accept=application/json")
	public ResponseEntity<Void> addExpense(@RequestBody Expense expense, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Expense by: " + expense.getBy_whom());
		ferService.addExpense(expense);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/addExpense/{id}").buildAndExpand(expense.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PostMapping(value = "/registration", headers = "Accept=application/json")
	public ResponseEntity<Void> registation(@ModelAttribute User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User: " + user.getUsername());
		ferService.registration(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/*
	 * @GetMapping(value = "/get", headers = "Accept=application/json") public
	 * List<User> getAllUser() { List<User> tasks = ferService.getUser(); return
	 * tasks;
	 * 
	 * }
	 */

	@PutMapping(value = "/edit", headers = "Accept=application/json")
	public ResponseEntity<String> editExpense(@RequestBody Expense expense) {
		System.out.println("sd");
		Expense expense1 = ferService.editExpense(expense);
		if (expense1 == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		ferService.editExpense(expense);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Integer> deleteExpense(@PathVariable Expense id) {
		Expense expense = ferService.deleteExpense(id);
		if (expense == null) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		ferService.deleteExpense(id);
		return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
	}

	/*
	 * @DeleteMapping(value = "/delete", headers = "Accept=application/json") public
	 * ResponseEntity<User> deleteUserQP(@RequestParam(required=false) long id) {
	 * User user = userService.findById(id); if (user == null) { return new
	 * ResponseEntity<User>(HttpStatus.NOT_FOUND); } userService.deleteUserById(id);
	 * return new ResponseEntity<User>(HttpStatus.NO_CONTENT); }
	 */
	/*
	 * @PatchMapping(value = "/{id}", headers = "Accept=application/json") public
	 * ResponseEntity<User> updateUserPartially(@PathVariable("id") long
	 * id, @RequestBody User currentUser) { User user = userService.findById(id); if
	 * (user == null) { return new ResponseEntity<User>(HttpStatus.NOT_FOUND); }
	 * User usr = userService.updatePartially(currentUser, id); return new
	 * ResponseEntity<User>(usr, HttpStatus.OK); }
	 */
	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		System.out.println("sd");
		User user1 = ferService.updateUser(user);
		if (user1 == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		ferService.updateUser(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
