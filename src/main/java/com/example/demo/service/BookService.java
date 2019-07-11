package com.example.demo.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository  bookRepository;

	//全件取得用メソッド
	public List<Book> selectBookList(){

		return bookRepository.selectBookList();
	}
}
