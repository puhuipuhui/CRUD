package com.lucene.book.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucene.book.dbutil.ConnectionManager;
import com.lucene.book.dbutil.SQLManager;
import com.lucene.model.Book;


public class BookDao {
	
	public boolean insertBook(final Book book) {
		//插入
		String isbn=book.getIsdn();
		String bookname=book.getBookname();
		String author=book.getAuthor();
		String press=book.getPress();
		double price=book.getPrice();
		int pages=book.getPages();
			
			ConnectionManager connectionManager=new ConnectionManager();
			Connection conn=connectionManager.getConnection();
			String strSQL="insert into book(isbn,bookname,author,press,price,pages) values(?,?,?,?,?,?)";
			Object[] params=new Object[] {isbn,bookname,author,press,price,pages};
			
			SQLManager sqlManager=new SQLManager();
			int affectedRows=sqlManager.execUpdate(conn, strSQL, params);
			if(affectedRows>0)
			{
				return true;
			}
			else {
				return false;
			}
	
		
	}
	
	
	
	public Book selectBookById(final int id) {
		//查询指定书籍
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection =	connectionManager.getConnection();
		SQLManager sqlManager=new SQLManager();
		String strSQL="select * from book where id=?";
		Object[] params=new Object[] {id};
		ResultSet rs=sqlManager.execQury(connection, strSQL, params);
		try {
			if(rs.next())
			{
				Book book=new Book();
				book.setId(id);
				book.setIsdn(rs.getString(2));
				book.setBookname(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPress(rs.getString(5));
				book.setPrice(rs.getDouble(6));
				book.setPages(rs.getInt(7));
				return book;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Book> selectAllBooks()
	{
		//查
		List<Book> bookList=new ArrayList<Book>();
		
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.getConnection();
		SQLManager sqlManager=new SQLManager();
		String strSQL="select * from book";
		Object[] params=new Object[] {};
		ResultSet rs=sqlManager.execQury(connection, strSQL, params);
		try {
			while(rs.next())
			{
				Book book=new Book();
				book.setId(rs.getInt("id"));
				book.setIsdn(rs.getString("isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getDouble("price"));
				book.setPages(rs.getInt("pages"));
				
				bookList.add(book);
			}
			
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}
	public boolean deleteBookById(final int id) {
		//删除
		ConnectionManager connectionManager=new ConnectionManager();
		Connection conn=connectionManager.getConnection();
		String strSQL="delete from book where id=?";
		Object[] params=new Object[] {id};
		SQLManager sqlManager=new SQLManager();
		int affecedRows=sqlManager.execUpdate(conn, strSQL, params);
		if (affecedRows>0) {
			return true;
		}
		return false;
	}
	public boolean updateBookById(final Book book,final int id) {
		//更新
		String isbn=book.getIsdn();
		String bookname=book.getBookname();
		String author=book.getAuthor();
		String press=book.getPress();
		double price=book.getPrice();
		int pages=book.getPages();
		
		ConnectionManager connectionManager=new ConnectionManager();
		Connection conn=connectionManager.getConnection();
		SQLManager sqlManager=new SQLManager();
		String strSQL="update book set isbn=?,bookname=?,author=?,press=?,price=?,pages=? where id=?";
		Object[] params=new Object[] {isbn,bookname,author,press,price,pages,id};
		int affectedRows=sqlManager.execUpdate(conn, strSQL, params);
		if (affectedRows>0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
}
