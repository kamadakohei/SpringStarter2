package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public class BookRepository {

	@Autowired
	JdbcTemplate jdbc;

	public List<Book> selectBookList() throws DataAccessException{

		//複数件のselect
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM booklist");

		//結果返却用の変数
		List<Book> bookList = new ArrayList<>();

		//取得したデータを結果返却用の変数Listに格納していく
		for(Map<String, Object> map: getList) {
			Book book = new Book();

			book.setBookId((int)map.get("book_id"));
			book.setTitle((String)map.get("title"));
			book.setAuthor((String)map.get("author"));

			bookList.add(book);
		}
		return bookList;
	}

	public int insertOne(Book book) throws DataAccessException{

		//insert
		int rowNumber =  jdbc.update("INSERT INTO booklist(book_id, title, author) VALUES(?, ?, ?)", book.getBookId(), book.getTitle(), book.getAuthor());

		return rowNumber;
	}

	public int DeleteOne(int bookId) throws DataAccessException{

		//delete
		int rowNumber = jdbc.update("DELETE FROM booklist WHERE book_Id = ?", bookId);
		return rowNumber;
	}

	public Book selectOne(int bookId) throws DataAccessException{

		//selectOne
		Map<String, Object> map = jdbc.queryForMap("select * from booklist where book_id = ?", bookId);


		Book book = new Book();

		book.setBookId((int)map.get("book_id"));
		book.setTitle((String)map.get("title"));
		book.setAuthor((String)map.get("author"));

		return book;
	}

	public int UpdateOne(Book book) throws DataAccessException{

		//update
		int rowNumber = jdbc.update("update booklist set title = ?, author = ? where book_id = ?", book.getTitle(), book.getAuthor(), book.getBookId());
		return rowNumber;
	}
}
