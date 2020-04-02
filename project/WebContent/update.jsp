<%@page import="com.lucene.book.Dao.BookDao"%>
<%@page import="com.lucene.model.Book"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		int id=Integer.parseInt(request.getParameter("id"));
		
		BookDao bookDao=new BookDao();
		Book book=bookDao.selectBookById(id);
		
		if(book!=null)
		{
			%>
			<h2>修改图书基本信息：</h2>
			<form action="doUpdate.jsp?id=<%=id%>" method="post">
				isbn:<input type="text" name="isbn" value="<%=book.getIsdn()%>"><br>
				 bookname: <input type="text" name="bookname" value="<%=book.getBookname()%>"><br> 
				 author: <input type="text" name="author" value="<%=book.getAuthor()%>"><br>
				  press: <input type="text" name="press" value="<%=book.getPress()%>"><br> 
				  price: <input type="text" name="price" value="<%=book.getPrice()%>"><br>
				pages: <input type="text" name="pages" value="<%=book.getPages()%>"><br> 
				<input type="submit" value="更新">
			</form>
			<% 
		}
		else
		{
			out.println("<script>alert('更新异常lalal');window.location.href='showAllBooks.jsp'</script>");
		}
		
		
		
%>

</body>
</html>