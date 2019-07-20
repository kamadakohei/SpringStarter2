package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public boolean insert(Book book) {

		int rowNumber = bookRepository.insertOne(book);

		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;
	}

	//1件削除用メソッド
	public boolean deteleOne(int bookId) {
		int rowNumber = bookRepository.DeleteOne(bookId);

		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;
	}

	//1件取得用メソッド
	public Book selectOne(int bookId) {
		return bookRepository.selectOne(bookId);
	}

}
