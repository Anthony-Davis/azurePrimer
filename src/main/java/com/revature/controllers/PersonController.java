package com.revature.controllers;

import com.revature.models.Person;
import com.revature.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
	
	@Autowired
	private PersonRepo pr;
	
	@PostMapping(value = "", consumes = "application/json", produces = "application/json")
	public Person addPerson(@RequestBody Person p) {
		return pr.save(p);
	}
	
	@GetMapping("/{id}")
	public Person getUser(@PathVariable("id") int id) {
		return pr.findById(id).get();
	}
	
	@GetMapping
	public List<Person> getAllPeople(){
		return (List<Person>) pr.findAll();
	}
}