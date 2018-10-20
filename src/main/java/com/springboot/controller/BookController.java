package com.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.VO.BookVO;
import com.springboot.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	  }

	 @RequestMapping(value = { "/addBookRedirect"}, method = RequestMethod.GET)
	    public String productsPage(ModelMap model) {
		 	model.addAttribute("bookVO", new BookVO());
	        return "AddBook"; 
	    }
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ModelAndView addBook(HttpServletRequest request,
	        HttpServletResponse response,
	        @ModelAttribute("bookVO")
	    BookVO bookVO) { 
		System.out.println("BookController addBook()  Entry:  ");
		 ModelAndView modelAndView = new ModelAndView("AddBook");
		 String message="";
		try {
			boolean insert=bookService.addBook(bookVO);
			if(insert){
	            message = "Book Added Successfully";
	            modelAndView.addObject("isErrorMsg", false);
	            modelAndView.addObject("message", message);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}

	 @RequestMapping(value = { "/viewAllBooks"}, method = RequestMethod.GET)
	    public String queryAllBooks(ModelMap model) {
		 List<BookVO> lsBook=bookService.getAllBooks();
		 	model.addAttribute("lsBookVO", lsBook);
	        return "viewBook"; 
	    }
	 
		@RequestMapping(value = "/viewBook/{id}", method = RequestMethod.GET)
		public ModelAndView viewBook(HttpServletRequest request,
		        HttpServletResponse response,@PathVariable int id)  { 
			System.out.println("BookController addBook()  Entry:  ");
			 ModelAndView modelAndView = new ModelAndView("EditBook");
			try {
				BookVO bookVO=bookService.queryBook(id);
				modelAndView.addObject("bookVO", bookVO);
		           
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return modelAndView;
		}
		
		@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
		public ModelAndView updateBook(HttpServletRequest request,
		        HttpServletResponse response,
		        @ModelAttribute("bookVO")
		    BookVO bookVO) { 
			System.out.println("BookController updateBook()  Entry:  ");
			 ModelAndView modelAndView = new ModelAndView("EditBook");
			 String message="";
			try {
				boolean insert=bookService.updateBook(bookVO);
				if(insert){
		            message = "Book Updated Successfully";
		            modelAndView.addObject("isErrorMsg", false);
		            modelAndView.addObject("message", message);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return modelAndView; 
		}
		
		@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
		public ModelAndView deleteBook(HttpServletRequest request,
		        HttpServletResponse response,@PathVariable int id)  { 
			System.out.println("BookController deleteBook()  Entry:  ");
			String out="";
			ModelAndView modelAndView = new ModelAndView("viewBook");
			try {
				boolean delete=bookService.deleteBook(id);
				
				 List<BookVO> lsBook=bookService.getAllBooks();
				 modelAndView.addObject("lsBookVO", lsBook);
		           
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return modelAndView;
		}
}
