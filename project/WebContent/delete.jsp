<%@page import="com.lucene.book.Dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
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
	Boolean flag=bookDao.deleteBookById(id);

	if(flag)
	{
		out.println("<script>alert('删除成功');window.location.href='showAllBooks.jsp'</script>");
	}
	else
	{
		out.println("<script>alert('删除异常');window.location.href='showAllBooks.jsp'</script>");
	}

%>
</body>
</html>