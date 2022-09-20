package DAoandBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {
	private final String URL = "jdbc:mysql://localhost:3306/LeaderBord";
	private final String USER = "root";
	private final String PASSWORD = "1234";
	private static GameDAO instance =new GameDAO();
	private int score;
	private int level;
	
	private GameDAO() {
		this.createDB();
	}
	public static GameDAO getInstance() {
		if (instance == null) instance = new GameDAO();
		return instance;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	private void createDB() {
		String sql = "CREATE DATABASE if NOT exists LEADERBORD";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", USER, PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			this.createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void createTable() {
		String sql = "CREATE TABLE if NOT exists  LEADERBORD (\r\n"
				+ "    Score int,\r\n"
				+ "    Level int,\r\n"
				+ "    Name varchar(255)\r\n"
				+ "); ";
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void create(String name) {
		String sql = "insert into LeaderBord values(?, ?, ?)";
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, this.score);
			pstmt.setInt(2, this.level);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Player> getAll() {
		String sql = "select * from leaderbord order by score;";
		List<Player> list= new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Player player= new Player(rs.getString("Name"),
										  rs.getInt("Score"),
										  rs.getInt("Level"));
				list.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
