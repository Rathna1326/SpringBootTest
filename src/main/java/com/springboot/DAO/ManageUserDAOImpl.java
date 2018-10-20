package com.springboot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.VO.UserDetailsVO;

@Repository
public class ManageUserDAOImpl implements ManageUserDAO{

	 @Autowired
	 DataSource dataSource;
	
public boolean addUser(UserDetailsVO user) throws Exception{
        
        Connection con = dataSource.getConnection();
        boolean insert=false;
        try {
               String query = "insert into Users (username,password,enabled) values (?,?,?)";
               PreparedStatement stmt = con.prepareStatement(query.toString());
             //  stmt.setInt(1,book.getBookId());
               stmt.setString(1,user.getUserName());
               stmt.setString(2, user.getPassword()); 
               stmt.setBoolean(3, true);
               
                int i=stmt.executeUpdate();
                if(i>0)
                insert =  true;
                if(insert){
                	query="insert into user_roles (username,role) values (?,?)";
                	stmt = con.prepareStatement(query.toString());
                    //  stmt.setInt(1,book.getBookId());
                      stmt.setString(1,user.getUserName());
                      stmt.setString(2, user.getUser_role()); 
                      
                        i=stmt.executeUpdate();
                       if(i>0)
                       insert =  true;
                }
               
        } catch (SQLException e) {
 
               throw new Exception();
        }finally {
               
               con.close();
               
               System.out.println("connection closed in addUser");  
        }
        return insert;

 }
	
}
