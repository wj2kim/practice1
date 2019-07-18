package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	// 이 클라스의 역할은 공통적으로 생성관리되야하는 DAO에 원래 있던 메소드들을 보관하는 객체
	// 예를들어 Connection생성, Statement, PreparedStatement객체 반환
	// ResultSet객체 반환, commit, rollback. 
	// 공통적으로 사용되는 메소드이기 때문에 static 으로 선언해야 한다 

	public static Connection getConnection() {
		Properties prop=new Properties();
		Connection conn=null;
		try {
			prop.load(new FileReader("driver.properties"));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pw"));
			conn.setAutoCommit(false);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null&&!stmt.isClosed()) {
				stmt.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null&&!rs.isClosed()) {
				rs.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) {
				conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) {
				conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
