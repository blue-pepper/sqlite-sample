package sqlitesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteTest {
	private Connection conn;
	private final String URL = "jdbc:sqlite:";
	private String file = "C://sqlite/todo.db";
	
	private String createTodo = "create table todo (\r\n" + 
			"id integer primary key\r\n" + 
			", name text\r\n" + 
			", todo text\r\n" + 
			");";
	
	private String insertTodo = "insert into todo(id, name, todo) values(?, ?, ?)";
	
	public void createTodo() throws SQLException {
		createConnection();
		Statement stmt = conn.createStatement();
		stmt.execute(createTodo);
		closeConnection();
	}
	
	public void insertTodo(int id, String name, String todo) throws SQLException {
		createConnection();
		PreparedStatement pstmt = conn.prepareStatement(insertTodo);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, todo);
		pstmt.executeUpdate();
		closeConnection();
	}
	
	private void createConnection() throws SQLException {
		conn = DriverManager.getConnection(URL + file);
	}
	
	private void closeConnection() throws SQLException {
		if(conn != null) conn.close();
	}
}
