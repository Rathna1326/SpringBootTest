<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Book</title>
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
<jsp:include page="Header.jsp"></jsp:include>
</head>

<body>

<div class="row">
  <div class="column left" >
   <jsp:include page="LibrarianMenus.jsp"></jsp:include>
  </div>
 
  <div class="column right" >
<h2>Edit Book</h2>  
<form:form method="post" name="bookform" modelAttribute="bookVO">  
  <form:input type="hidden" path="bookId" />
  <c:if test="${not empty message}">
				<div class="statusMsg"
					style="width: 50px; height: 25px; font-weight: bold; font-size: 14px; color: red; padding-top: 3px; padding-left: 30px">
					<c:choose>
						<c:when test="${isErrorMsg eq false}">
							<font class="userValue"
								style="color: #006400; font-weight: bold; white-space: nowrap;">${message}</font>
						</c:when>
						<c:otherwise>
							<font class="userValue"
								style="color: #ff0000; font-weight: bold; white-space: nowrap;">${message}</font>
						</c:otherwise>
					</c:choose>
				</div>
			</c:if>
			
  
    <table>  
    <tr>  
        <td><form:label path="title">Book Title</form:label></td>  
        <td><form:input path="title" /></td>   
    </tr>  
    <tr>  
        <td><form:label path="price">Price</form:label></td>  
        <td><form:input path="price" /></td>  
    </tr>  
    <tr>  
        <td><form:label path="volume">Volume</form:label></td>  
        <td><form:input path="volume" /></td>  
    </tr>  
    <tr>  
        <td><form:label path="publishDate">Publish Date</form:label></td>  
        <td><form:input path="publishDate" /></td>  
    </tr>  
    <tr>  
        <td colspan="2">  
            <input type="button" value="Edit Book" onclick="editBook();"/>  
        </td>  
    </tr>  
</table>    
      
</form:form>  
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>  
<script>

	
   function editBook() {
    	//window.location.href = '${pageContext.request.contextPath}/manageUser';
    	document.bookform.action= "${pageContext.request.contextPath}/updateBook";
		document.bookform.submit(); 
    	
    	//$("#remove").hide(); 
    	//$("#succcess").show(); 
   }
    </script>
</html>