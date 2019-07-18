package com.example.demo.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.AddBookForm;
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
	@GetMapping("/addBook")
	public String getadd(@ModelAttribute AddBookForm form) {
		return "home/addBook";
	}

	//Bookリスト登録画面の‘POSTメソッド
	@PostMapping("/addBook")
	public String postaddBook(@ModelAttribute AddBookForm form, BindingResult bindingResult, Model model) {

		Book book = new Book();

		book.setBookId(form.getBookId());
		book.setTitle(form.getTitle());
		book.setAuthor(form.getAuthor());

		boolean result = bookService.insert(book);

		if(result == true) {
			System.out.println("insert成功");
		}else {
			System.out.println("insert失敗");
		}

		return "redirect:/home";
	}
	
	//更新ページへのGETリクエスト
	@GetMapping ("/deleteBook")
	public String getdelete(Model model) {
		
	}


}
