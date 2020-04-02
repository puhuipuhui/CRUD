<%@page import="com.lucene.model.Book"%>
<%@page import="com.lucene.book.Dao.BookDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
    <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	int id=Integer.parseInt(request.getParameter("id"));
	
	String isbn = request.getParameter("isbn");
	String bookname = request.getParameter("bookname");
	String author = request.getParameter("author");
	String press = request.getParameter("press");
	double price =Double.parseDouble(request.getParameter("price"));
	int pages = Integer.parseInt(request.getParameter("pages"));

	Book book= new Book(isbn,bookname,author,press,price,pages);
	BookDao bookDao = new BookDao();
	boolean flag=bookDao.updateBookById(book, id);
	
	if(flag)
	{
		out.println("<script>window.location.href='showAllBooks.jsp'</script>");
	}
	else{
		out.println("<script>alert('更新异常');window.location.href='showAllBooks.jsp'</script>");
	}
		
%>
</body>
</html>