<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<h2>User Registration</h2>
  <form:form  name="regForm" modelAttribute="userVO"  method="post">
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
			
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userName">Username</form:label>
                        </td>
                        <td>
                            <form:input path="userName" name="userName" id="userName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                    <td>
                            <form:label path="user_role">User Role</form:label>
                        </td>
                        <td>
                           <form:radiobutton path="user_role" value="PRINCIPAL"/>Principal 
							<form:radiobutton path="user_role" value="LIBRARIAN"/>Librarian 
                        </td>
                    <tr>
                        <td></td>
                        <td>
                          <input type="button" value="Register" onclick="addUser();"/>  
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>
            </form:form>
</body>
<script>

	
   function addUser() {
    //window.location.href = '${pageContext.request.contextPath}/manageUser';
    	document.regForm.action= "${pageContext.request.contextPath}/addUser"; 
		document.regForm.submit(); 
    	
    	//$("#remove").hide(); 
    	//$("#succcess").show(); 
   }
    </script>
</html>