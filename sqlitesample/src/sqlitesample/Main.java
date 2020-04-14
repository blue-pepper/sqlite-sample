package sqlitesample;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		SqliteTest st = new SqliteTest();
		st.createTodo();
		st.insertTodo(1, "Kim", "Test SQLite");
		st.insertTodo(2, "Kim", "Homework");
		st.insertTodo(3, "Lee", "Get back to hell");
		st.insertTodo(4, "Park", "Being mean");
	}
}
