package com.example.demo.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
public class HomeController {

	@Autowired
	BookService bookService;


	//Bookリスト一覧画面のGETメソッド
	@GetMapping("/home")
	// localhost:8082/homeへのGETに対する処理をさせる
	public String getHome(Model model) {

		List<Book> bookList = bookService.selectBookList();

		model.addAttribute("bookList", bookList);
		// GETリクエストに対してhome.htmlを表示させる
		return "home/bookList";
	}

	//Bookリスト登録画面のGETメソッド
	//@GetMapping("/")


}
