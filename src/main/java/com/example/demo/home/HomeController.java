package com.example.demo.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	//Bookリスト登録画面のPOSTメソッド
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

	//ユーザー削除画面のGETメソッド
	@GetMapping("/deleteBook/{id}")
	public String getdeleteBook(@ModelAttribute AddBookForm form, Model model, @PathVariable("id") int bookId)
	{
			Book book = bookService.selectOne(bookId);


			//対象のデータがない場合はエラーページに遷移させる必要あり
			if(book != null) {
			form.setBookId(book.getBookId());
			form.setTitle(book.getTitle());
			form.setAuthor(book.getAuthor());

			model.addAttribute("addBookForm", form);

		}
		return "home/deleteBook";
	}


	//ユーザー削除用処理
	@PostMapping("/deleteBook")
	public String postdeleteBook(@ModelAttribute AddBookForm form, Model model)
	{
		boolean result = bookService.deleteOne(form.getBookId());

		if(result = true) {
			model.addAttribute("result", "削除成功");
		}else {
			model.addAttribute("result", "削除失敗");
		}
		return getHome(model);
	}

	//ユーザー更新用のGETメソッド
	@GetMapping("/updateBook/{id}")
	public String getupdateBook(@ModelAttribute AddBookForm form, Model model, @PathVariable("id") int bookId) {

		Book book = bookService.selectOne(bookId);

		//対象のデータがない場合はエラーページに遷移させる必要あり
		if(book != null) {

			form.setBookId(book.getBookId());
			form.setTitle(book.getTitle());
			form.setAuthor(book.getAuthor());
			model.addAttribute("addBookForm", form);
		}
		return "home/updateBook";
	}

	//ユーザー更新用処理
	@PostMapping("/updateBook")
	public String postupdateBook(@ModelAttribute AddBookForm form, Model model) {

		Book book = new Book();

		book.setBookId(form.getBookId());
		book.setTitle(form.getTitle());
		book.setAuthor(form.getAuthor());

		//更新処理
		boolean result = bookService.updateOne(book);

		if(result = true) {
			model.addAttribute("result", "更新成功");
			System.out.println("成功");
		}else {
			model.addAttribute("result", "更新失敗");
		}

		return getHome(model);
	}
}


