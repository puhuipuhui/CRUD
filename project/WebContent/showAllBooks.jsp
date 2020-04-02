<%@page import="com.lucene.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.lucene.book.Dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/validate.js"></script>
<title>Insert title here</title>
<a href="addBook.html">添加图书</a>
所有图书如下：<hr>
</head>
<body>
	<%
		BookDao bookDao=new BookDao();
		List<Book> bookList=bookDao.selectAllBooks();
		
		for(int i=0;i<bookList.size();i++)
		{
			out.println(bookList.get(i).getId() + "," + bookList.get(i).getIsdn() +","+bookList.get(i).getAuthor()+","+ bookList.get(i).getPress() + " "
					+ bookList.get(i).getBookname() + "," +bookList.get(i).getPrice() + bookList.get(i).getPages()
					+ "<a href='update.jsp?id=" + bookList.get(i).getId() + "'>更新</a>&nbsp;<a href='delete.jsp?id="
					+ bookList.get(i).getId() + "'onclick='return deleteRecord()'>删除</a>" + "<br>");

		}

		
	%>
</body>
</html>