package com.fabreads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fabreads.javabeans.*;
import com.fabreads.utils.JDBCConnection;

public class BookDetailsDAO 
{
	
	public Book getBookDetails(int id)
	{
		Book book = null;
		Connection conn = JDBCConnection.getConnection();
		book = getBookData(conn, id);		
		return book;
	}

	private Book getBookData(Connection conn, int id) {
		
		Book book = new Book();
		String query = "select bookname, bookauthors, booklanguage, edition_no, ISBN from BookDetails where bookid = ?";
		try {
			PreparedStatement selectStmt = conn.prepareStatement(query);
			selectStmt.setInt(1, id);
			ResultSet res = selectStmt.executeQuery();			
			while(res.next())
			{
				book.setId(id);
				book.setBookName(res.getString(1));
				book.setBookAuthors(res.getString(2));
				book.setBookLanguage(res.getString(3));	
				book.setEditionNumber(res.getInt(4));
				book.setIsbn(res.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

}
