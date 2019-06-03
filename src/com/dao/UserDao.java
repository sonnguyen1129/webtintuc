package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.User;
import com.utils.DatabaseUtils;

public class UserDao {
	
	public boolean checkLogin(String username, String matkhau)
			throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "SELECT * FROM Users WHERE username = ? AND matkhau = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, matkhau);
		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.next()) {
				return true;
			}
			return false;
		} finally {
			DatabaseUtils.closeConnection(connection);
		}
	}

	public User getUser(String username, String matkhau) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "SELECT * FROM Users WHERE username = ? AND matkhau = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, matkhau);
		ResultSet resultSet = preparedStatement.executeQuery();
		User user = new User();
		if (resultSet.next()) {
			user.setUsername(resultSet.getString(1));
			user.setMatkhau(resultSet.getString(2));
			user.setHoten(resultSet.getString(3));
			user.setQuyen(resultSet.getInt(4));
		}
		DatabaseUtils.closeConnection(connection);
		return user;
	}
	
	public User getUserNoPass(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "SELECT * FROM Users WHERE username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		User user = new User();
		if (resultSet.next()) {
			user.setUsername(resultSet.getString(1));
			user.setMatkhau(resultSet.getString(2));
			user.setHoten(resultSet.getString(3));
			user.setQuyen(resultSet.getInt(4));
		}
		DatabaseUtils.closeConnection(connection);
		return user;
	}
	
	public boolean checkUsername(String username) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "SELECT * FROM Users WHERE username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.next()) {
				return true;
			}
			return false;
		} finally {
			DatabaseUtils.closeConnection(connection);
		}
		
	}
	
	public boolean addUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "insert into Users values (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getMatkhau());
		preparedStatement.setString(3, user.getHoten());
		preparedStatement.setInt(4, user.getQuyen());

		try {
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			} else
				return false;
		} finally {
			DatabaseUtils.closeConnection(connection);
		}

	}
	
	public boolean deleteUser(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query =  " delete from thongbao where usergui = ?\r\n "+ 
						" delete from Baiviet where username = ?\r\n" + 
						" delete from users where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, username);
		preparedStatement.setString(3, username);

		try {
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			} else
				return false;
		} finally {
			DatabaseUtils.closeConnection(connection);
		}
	}
	
	public int countUsers() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(username) from users where quyen = 0";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}

	public List<User> getListUsers() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<User> listUsers = new ArrayList<>();
		String sql = "select u.username,u.hoten, sum(b.duyet) as 'so bai viet'\r\n" + 
				"from users as u\r\n" + 
				"left join\r\n" + 
				"Baiviet as b on u.username = b.username \r\n" + 
				"where u.quyen = 0\r\n" + 
				"group by u.username,u.hoten";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			User user = new User();
			user.setUsername(resultSet.getString(1));
			user.setMatkhau("xxxxxxxxxxxxxx");
			user.setHoten(resultSet.getString(2));
			if(resultSet.getString(3) != null) {
				user.setQuyen(resultSet.getInt(3));
			} else 
				user.setQuyen(0);
			listUsers.add(user);
		}
		DatabaseUtils.closeConnection(connection);
		return listUsers;
		
	}
	
}
