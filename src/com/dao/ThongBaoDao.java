package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.ThongBao;
import com.utils.DatabaseUtils;

public class ThongBaoDao {
	
	
	public ThongBao getThongBao(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "SELECT * FROM ThongBao WHERE usernhan = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		ThongBao thongBao = new ThongBao();
		if (resultSet.next()) {
			thongBao.setId(resultSet.getInt(1));
			thongBao.setUserGui(resultSet.getString(2));
			thongBao.setUserNhan(resultSet.getString(3));
			thongBao.setNoiDung(resultSet.getString(4));
			thongBao.setNgayGui(resultSet.getString(5));
			thongBao.setStatus(resultSet.getInt(6));
		}
		DatabaseUtils.closeConnection(connection);
		return thongBao;
	}
	
	public List<ThongBao> getListThongBao(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<ThongBao> listThongBao = new ArrayList<>();
		String sql = "SELECT * FROM ThongBao WHERE usernhan = ? order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			ThongBao thongBao = new ThongBao();
			thongBao.setId(resultSet.getInt(1));
			thongBao.setUserGui(resultSet.getString(2));
			thongBao.setUserNhan(resultSet.getString(3));
			thongBao.setNoiDung(resultSet.getString(4));
			thongBao.setNgayGui(resultSet.getString(5));
			thongBao.setStatus(resultSet.getInt(6));
			listThongBao.add(thongBao);
		}
		DatabaseUtils.closeConnection(connection);
		return listThongBao;
		
	}
	
	public boolean addThongBao(ThongBao thongBao) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "insert into ThongBao values (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, thongBao.getUserGui());
		preparedStatement.setString(2, thongBao.getUserNhan());
		preparedStatement.setString(3, thongBao.getNoiDung());
		preparedStatement.setString(4, thongBao.getNgayGui());
		preparedStatement.setInt(5, thongBao.getStatus());

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
	
	public boolean updateStatus(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "UPDATE thongbao SET trangthai = 1 WHERE usernhan = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);

		try {
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				return true;
			}
			return false;
		} finally {
			DatabaseUtils.closeConnection(connection);
		}
	}
	
	public int countStatus(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(trangthai) from thongbao where trangthai = 0 and usernhan = '" + username + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ThongBaoDao thongBaoDao = new ThongBaoDao();
		
	}
}
