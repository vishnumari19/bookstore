package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.model.*;
import com.example.bookstore.dao.*;
import java.util.*;
@Service
public class BookService {
	
	@Autowired
	BookRepo br;
	//insert
	public Book get1(Book b)
	{
		return br.save(b);
	}
	//selectall
	public List<Book>get2()
	{
		return br.findAll();
	}
   public Optional<Book>get3(int id)
   {
	   return br.findById(id);
	   //delete
   }
   public void get4(int id)
   {
	   br.deleteById(id);
   }
}
