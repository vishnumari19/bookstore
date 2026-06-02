package com.example.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.model.*;
import com.example.bookstore.service.*;
@RestController
public class BookController {
	
	@Autowired
    BookService bs;
	
	
	@PostMapping("/abc")
	public ResponseEntity<Book> set1(@RequestBody Book b)
	{
		Book b1=bs.get1(b);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
		
	}
	@GetMapping("/home")
	public List<Book> set2()
	{
		return bs.get2();
	}
	
	@GetMapping("/sel/{id}")
	public ResponseEntity<Book> set3(@PathVariable int id)
	{
		Optional<Book> b=bs.get3(id);
		return b.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
		
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<Book>set4(@PathVariable int id,@RequestBody Book b)
	{
		if (!bs.get3(id).isPresent())
		{
			
			return ResponseEntity.notFound().build();
			
		}
		b.setId(id);
		Book b1=bs.get1(b);
		return ResponseEntity.ok(b1);
		
		
	}
	//delete t set title=''where id=1
	@DeleteMapping("del/{id}")
	public ResponseEntity<Book>set4(@PathVariable int id)
	{
		if (!bs.get3(id).isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		bs.get4(id);
		
		return ResponseEntity.noContent().build();
	}
		
		
		
	}

