package com.springboot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.VO.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {

	 @Autowired
	 DataSource dataSource;
	
public boolean addBook(BookVO book) throws Exception{
        
        Connection con = dataSource.getConnection();
        boolean insert=false;
        try {
               String query = "insert into Book (title,price,volume,publish_date) values (?,?,?,?)";
               PreparedStatement stmt = con.prepareStatement(query.toString());
             //  stmt.setInt(1,book.getBookId());
               stmt.setString(1, book.getTitle());
               stmt.setDouble(2, book.getPrice()); 
               stmt.setInt(3, book.getVolume());
               stmt.setDate(4,   new java.sql.Date(book.getPublishDate().getTime())); 
               
                int i=stmt.executeUpdate();
                if(i>0)
                insert =  true;
               
        } catch (SQLException e) {
 
               throw new Exception();
        }finally {
               
               con.close();
               
               System.out.println("connection closed in saveBook");  
        }
        return insert;

 }

    public BookVO queryBookById(int bookId) throws Exception{
    	 Connection con = dataSource.getConnection();             
    	 Statement s1 = null;
    	 BookVO book=null;
         try{
                
                s1= con.createStatement();
                String sql = "select * from Book where id="+bookId;
                
                ResultSet rs = s1.executeQuery(sql);
                while (rs.next()) {
                	book=new BookVO();
                	book.setBookId(rs.getInt(1));
                	book.setTitle(rs.getString(2));
                	book.setPrice(rs.getDouble(3));
                	book.setVolume(rs.getInt(4));
                	book.setPublishDate(rs.getDate(5));
                }
         }
         catch (SQLException e) {
                
                throw new Exception();
         }finally {
                
                con.close();
                
                System.out.println("connection closed in queryBookById");  
         }
         return book;

    }
    
    public boolean updateBook(BookVO book)  throws Exception{
        Connection con = dataSource.getConnection();
        boolean update=false;
        try{
               
               String query = "Update Book set title=?, price=?,volume=?,publish_date=? WHERE id=?";
               PreparedStatement stmt = con.prepareStatement(query.toString());
               stmt.setString(1, book.getTitle());
               stmt.setDouble(2, book.getPrice());
               stmt.setInt(3, book.getVolume());
               stmt.setDate(4,   new java.sql.Date(book.getPublishDate().getTime())); 
               stmt.setInt(5,book.getBookId());
               
                int i=stmt.executeUpdate();
                if(i>0)
                     update =  true;
        }
        catch (SQLException e) {
               
               throw new Exception();
        }finally {
               
               con.close();
               
               System.out.println("connection closed in updateBook");  
        }
        return update;
 }

  public boolean deleteBook(int id) throws Exception{
	  Connection con = dataSource.getConnection();
      boolean delete=false;
      try{
             
             String query = "delete from Book WHERE id=?";
             PreparedStatement stmt = con.prepareStatement(query.toString());
            
             stmt.setInt(1,id);
             
              int i=stmt.executeUpdate();
              if(i>0)
                   delete =  true;
      }
      catch (SQLException e) {
             
             throw new Exception();
      }finally {
             
             con.close();
             
             System.out.println("connection closed in deleteBook");  
      }
      return delete;
  }
    
  
  public List<BookVO> getAllBooks() throws Exception{
	  Connection con = dataSource.getConnection(); 
	  Statement s1 = null;
      List<BookVO> bookLs=new ArrayList<BookVO>();
      try{
          
          s1= con.createStatement();
          String sql = "select * from Book";
          
          ResultSet rs = s1.executeQuery(sql);
          while (rs.next()) {
        	BookVO  book=new BookVO();
          	book.setBookId(rs.getInt(1));
          	book.setTitle(rs.getString(2));
          	book.setPrice(rs.getDouble(3));
          	book.setVolume(rs.getInt(4));
          	book.setPublishDate(rs.getDate(5));
          	bookLs.add(book);
          }
   }
   catch (SQLException e) {
          
          throw new Exception();
   }finally {
          
          con.close();
          
          System.out.println("connection closed in getAllBooks");  
   }
   return bookLs;

  }
	
}
