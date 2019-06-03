package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.entities.Post;
import com.utils.DatabaseUtils;

public class PostDao {
	
	public Post getNewBaiviet() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select top 1 * from baiviet where duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}

	public Post getNewGiaitri() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select top 1 * from baiviet where theloai = 'giaitri' and duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}

	public Post getNewThethao() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select top 1 * from baiviet where theloai = 'thethao' and duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}
	
	public Post getNewCongnghe() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select top 1 * from baiviet where theloai = 'congnghe' and duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}

	public Post getNewVanhoa() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select top 1 * from baiviet where theloai = 'vanhoa' and duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}

	public Post getNewDoisong() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select top 1 * from baiviet where theloai = 'doisong' and duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}


	public boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	public String getFullName(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();

		String sql = "select hoten from Users where username = '" + username + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		String fullName = null;
		while (resultSet.next()) {
			fullName = resultSet.getString(1);
		}
		DatabaseUtils.closeConnection(connection);
		return fullName;
	}

	public List<Post> getList(String theloai) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where duyet = 1 and theloai = '" + theloai + "' order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}
	
	public List<Post> getListCungTheloai(String id, String theloai) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select top 2 * from baiviet where id <> " + id + "and duyet = 1 and theloai = '" + theloai + "' order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public List<Post> getWaitList(String theloai) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where duyet = 0 and theloai = '" + theloai + "' order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public Post getPostByid(int postId) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select * from baiviet where id = '" + postId + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}

	public List<Post> getList3Post() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select top 3 * from baiviet where duyet = 1 order by luotxem desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}

		DatabaseUtils.closeConnection(connection);
		return listPost;
	}
	
	
	
	public List<Post> getList2Post() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from (select top 3 * from baiviet where duyet = 1 order by id desc) as b \r\n" + 
				"where id < (select max(id) from baiviet where duyet = 1)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}

		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public boolean addPost(Post post) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "insert into baiviet values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, post.getTieuDe());
		preparedStatement.setString(2, post.getUsername());
		preparedStatement.setString(3, post.getTheLoai());
		preparedStatement.setString(4, post.getTomTat());
		preparedStatement.setString(5, post.getNoiDung());
		preparedStatement.setString(6, post.getHinhAnh());
		preparedStatement.setString(7, post.getNgayDang());
		preparedStatement.setInt(8, post.getDuyet());
		preparedStatement.setString(9, post.getNgayDuyet());
		preparedStatement.setInt(10, post.getView());

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

	public int getCountList(String theLoai) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(id) from baiviet\r\n" + "where duyet = 1 and theloai = '" + theLoai + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}

	public int getCountWaitList(String theLoai) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(id) from baiviet\r\n" + "where duyet = 0 and theloai = '" + theLoai + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}

	public Post getPostByTieuDe(String tieuDe) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = DatabaseUtils.getConnection();
		Post post = new Post();
		String sql = "select * from baiviet where tieuDe = N'" + tieuDe + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
		}
		DatabaseUtils.closeConnection(connection);
		return post;
	}

	public List<Post> getListNoDuyet(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where username = '" + username + "' and duyet = 0 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public int getCountNoDuyet(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(id) from baiviet\r\n" + "where username = '" + username + "' and duyet = 0";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}

	public boolean updatePost(Post post) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "UPDATE baiviet SET tieude = ?, theloai = ?, tomtat = ?, noidung = ?, hinhanh = ? WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, post.getTieuDe());
		preparedStatement.setString(2, post.getTheLoai());
		preparedStatement.setString(3, post.getTomTat());
		preparedStatement.setString(4, post.getNoiDung());
		preparedStatement.setString(5, post.getHinhAnh());
		preparedStatement.setString(6, post.getId());

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
	
	public String getTheloai(String theloai) {
		String theloai1;
		if (theloai.equals("giaitri"))
			theloai1 = "Giải trí";
		else if (theloai.equals("vanhoa"))
			theloai1 = "Văn hóa";
		else if (theloai.equals("doisong"))
			theloai1 = "Đời sống";
		else
			theloai1 = "Thể thao";

		return theloai1;
	}
	
	public boolean updateView(String id, int view) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "update baiviet \r\n" + 
				"set luotxem = ? \r\n" + 
				"where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, view);
		preparedStatement.setString(2, id);
		

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

	public boolean deletePost(String id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "Delete FROM baiviet WHERE id = ?;";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);

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

	public List<Post> getListDuyet(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where username = '" + username + "' and duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}
	
	public List<Post> getListByUsername(String id, String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where id <> " + id + " and username = '" + username + "' and duyet = 1 order by luotxem desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public int getCountDuyet(String username) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(id) from baiviet\r\n" + "where username = '" + username + "' and duyet = 1";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	

	public int countDuyet() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(id) from baiviet\r\n" + "where duyet = 1";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}

	public int countNoDuyet() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String query = "select count(id) from baiviet\r\n" + "where duyet = 0";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}

	public List<Post> getListDuyet() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where duyet = 1 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public List<Post> getListNoDuyet() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		List<Post> listPost = new ArrayList<>();

		String sql = "select * from baiviet where duyet = 0 order by id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Post post = new Post();
			post.setId(resultSet.getString(1));
			post.setTieuDe(resultSet.getString(2));
			post.setUsername(resultSet.getString(3));
			post.setTheLoai(resultSet.getString(4));
			post.setTomTat(resultSet.getString(5));
			post.setNoiDung(resultSet.getString(6));
			post.setHinhAnh(resultSet.getString(7));
			post.setNgayDang(resultSet.getString(8));
			post.setDuyet(resultSet.getInt(9));
			post.setNgayDuyet(resultSet.getString(10));
			post.setView(resultSet.getInt(11));
			listPost.add(post);
		}
		DatabaseUtils.closeConnection(connection);
		return listPost;
	}

	public boolean duyetPost(String id, String ngayDuyet) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
		String sql = "UPDATE baiviet SET duyet = 1, ngayduyet = ? WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, ngayDuyet);
		preparedStatement.setString(2, id);

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

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		@SuppressWarnings("unused")
		PostDao postDao = new PostDao();
	}
}
