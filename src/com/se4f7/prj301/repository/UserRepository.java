	package com.se4f7.prj301.repository;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import com.se4f7.prj301.entities.User;
	import org.mindrot.jbcrypt.BCrypt;

	import com.se4f7.prj301.dto.request.LoginRequestDto;
	import com.se4f7.prj301.dto.request.RegisterRequestDto;
	import com.se4f7.prj301.dto.response.LoginResponseDto;
	import com.se4f7.prj301.enums.UserStatus;
	import com.se4f7.prj301.utils.DBUtil;

	public class UserRepository {

		private static final String INSERT_USERS_SQL = "INSERT INTO users"
				+ "  (username, password, status, firstName, lastName) VALUES " + " (?, ?, ?, ?, ?);";
		private static final String VALIDATE_LOGIN = "select * from users where username = ? and status = ?";
		private static final String SELECT_USER = "select * from user";

		private static final String SELECT_USER_PROFILE = "select * from user where id = ?";
		public boolean registerUser(RegisterRequestDto user) throws SQLException {
			try (Connection connection = DBUtil.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));

				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, hashPassword);
				preparedStatement.setInt(3, UserStatus.ACTIVE.ordinal());
				preparedStatement.setString(4, user.getFirstName());
				preparedStatement.setString(5, user.getLastName());

				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				return true;
			} catch (SQLException e) {
				DBUtil.printSQLException(e);
			}
			return false;
		}

		public LoginResponseDto validateLogin(LoginRequestDto user) throws SQLException {
			try (Connection connection = DBUtil.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_LOGIN)) {
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setInt(2, UserStatus.ACTIVE.ordinal());

				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					if (BCrypt.checkpw(user.getPassword(), rs.getString("password"))) {
						return new LoginResponseDto(rs.getInt("id"), rs.getString("username"), UserStatus.ACTIVE);
					}
				}
			} catch (SQLException e) {
				DBUtil.printSQLException(e);
			}
			return null;
		}

		public List<User> getAllUsers() {
			List<User> userList = new ArrayList<>();
			try (Connection connection = DBUtil.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
				 ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");
					String title = resultSet.getString("title");
					String status = resultSet.getString("status");
					String position = resultSet.getString("position");

					// Chuyển đổi trạng thái từ String sang int
					int statusInt;
					switch (status) {
						case "Active":
							statusInt = 1;
							break;
						case "Onboarding":
							statusInt = 2;
							break;
						case "Awaiting":
							statusInt = 3;
							break;
						default:
							statusInt = 0; // Trạng thái mặc định hoặc xử lý lỗi
					}

					// Tạo một đối tượng User từ các thông tin lấy được
					User user = new User(id, firstName, lastName, email, password, title, statusInt, position);
					// Thêm người dùng vào danh sách
					userList.add(user);
				}
			} catch (SQLException e) {
				DBUtil.printSQLException(e);
			}
			return userList;
		}



		public User getUser(int userId) {
			User user = null;
			try (Connection connection = DBUtil.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_PROFILE)) {
				preparedStatement.setInt(1, userId);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						int id = resultSet.getInt("id");
						String firstName = resultSet.getString("firstName");
						String lastName = resultSet.getString("lastName");
						String email = resultSet.getString("email");
						String password = resultSet.getString("password");
						String title = resultSet.getString("title");
						String status = resultSet.getString("status");
						String position = resultSet.getString("position");

						// Chuyển đổi trạng thái từ String sang int
						int statusInt;
						switch (status) {
							case "Active":
								statusInt = 1;
								break;
							case "Onboarding":
								statusInt = 2;
								break;
							case "Awaiting":
								statusInt = 3;
								break;
							default:
								statusInt = 0; // Trạng thái mặc định hoặc xử lý lỗi
						}

						// Tạo một đối tượng User từ các thông tin lấy được
						user = new User(id, firstName, lastName, email, password, title, statusInt, position);
					}
				}
			} catch (SQLException e) {
				DBUtil.printSQLException(e);
			}
			return user;
		}

	}


