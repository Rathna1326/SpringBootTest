package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.VO.BookVO;
import com.springboot.DAO.BookDAO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDAO;
	
	
	public boolean addBook(BookVO book) throws Exception{
		return bookDAO.addBook(book);
	}
	
	public boolean updateBook(BookVO book) throws Exception{
		return bookDAO.updateBook(book);
	}
	public BookVO queryBook(int bookId) throws Exception{
		return bookDAO.queryBookById(bookId);
	}
	
	public boolean deleteBook(int bookId) throws Exception
	{
		return bookDAO.deleteBook(bookId);
	}
	
	public List<BookVO> getAllBooks(){
		System.out.println("BookService getAllBooks() Entry:  ");
		 List<BookVO> bookLs=null;
		try {
			bookLs=	bookDAO.getAllBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("BookService getAllBooks() Exit:  ");
			return bookLs;
	}
}
