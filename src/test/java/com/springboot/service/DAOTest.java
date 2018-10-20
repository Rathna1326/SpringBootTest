package com.springboot.service;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.DAO.BookDAO;
import com.springboot.VO.BookVO;

@Transactional
public class DAOTest extends AbstractTest {

	@Autowired
	BookDAO bookDAO;
	
	@Test
    public void testFindOne() {

        Integer id = new Integer(6);

        BookVO entity = null;
		try {
			entity = bookDAO.queryBookById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Assert.assertNotNull("failure - expected not null", entity);
     /*   Assert.assertEquals("failure - expected id attribute match", id,
                entity.getBookId());*/

    }
	
	@Test
	//@Ignore
	public void testBook(){

		BookVO book =new BookVO();
		
		book.setBookId(7);
		book.setTitle("Gandhi's Saritham");
		book.setPrice(300);
		book.setPublishDate(new Date());
		book.setVolume(500);
		
	    try {
			
			 assertTrue(bookDAO.addBook(book));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	
	}
	
	@Test
	public void testUpdateBook(){
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		BookVO book =new BookVO();
		  try {
		book.setBookId(6);
		book.setTitle("Wings of Fire");
		book.setPrice(500);
		book.setVolume(350);
	  
	    	Date today = sdf.parse("14/11/2012");
	    	book.setPublishDate(today);
	    	System.out.println("Date is : " + today.toString());
			 assertTrue(bookDAO.updateBook(book));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
    public void testDeleteBook() {

        Integer id = new Integer(13);

		try {
			assertTrue(bookDAO.deleteBook(id));
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
	
}
