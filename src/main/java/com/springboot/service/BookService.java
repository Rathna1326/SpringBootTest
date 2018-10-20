package com.springboot.service;

import java.util.List;

import com.springboot.VO.BookVO;

public interface BookService {

	public boolean addBook(BookVO book) throws Exception;
	public boolean updateBook(BookVO book) throws Exception;
	public BookVO queryBook(int bookId) throws Exception;
	public boolean deleteBook(int bookId) throws Exception;
	public List<BookVO> getAllBooks();
}
