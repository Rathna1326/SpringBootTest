<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>

/* Create two unequal columns that floats next to each other */
.column {
    float: left;
    padding: 10px;
    height: 500px; /* Should be removed. Only for demonstration */
}

.left {
  width: 15%;
}

.right {
  width: 50%;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}
</style>

<title>view Book</title>
<jsp:include page="Header.jsp"></jsp:include>
</head>
<body>

<div class="row">
  <div class="column left" >
   <jsp:include page="LibrarianMenus.jsp"></jsp:include>
  </div>
 
  <div class="column right" >
<h1>Books List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Title</th><th>Price</th><th>Volume</th><th>Published Date</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="book" items="${lsBookVO}">   
   <tr>  
   <td>${book.bookId}</td>  
   <td>${book.title}</td>  
   <td>${book.price}</td>  
   <td>${book.volume}</td>  
   <td>${book.publishDate}</td>  
   <td><a href="viewBook/${book.bookId}">Edit</a></td>  
   <td><a href="deleteBook/${book.bookId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    </div>
</div>
   <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>