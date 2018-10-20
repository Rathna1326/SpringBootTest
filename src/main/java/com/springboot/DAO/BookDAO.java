package com.springboot.DAO;

import java.util.List;

import com.springboot.VO.BookVO;

public interface BookDAO {
	
	public boolean addBook(BookVO book) throws Exception;
	public boolean updateBook(BookVO book) throws Exception;
	public BookVO queryBookById(int bookId) throws Exception;
	public boolean deleteBook(int bookId) throws Exception;
	public List<BookVO> getAllBooks() throws Exception;

}
