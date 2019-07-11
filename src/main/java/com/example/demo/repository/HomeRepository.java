package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomeRepository {

	@Autowired
	JdbcTemplate jdbc;

	//public List<Book> selectBookList() throws DataAccessException{}

}
