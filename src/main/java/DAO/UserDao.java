package DAO;

import User.User;
import com.sun.istack.internal.Nullable;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public User getUserByName(String name)  {

        User user = null;
        long id = 0L;
        String sql = "SELECT * FROM user WHERE name = ?";
        try (PreparedStatement preStmt = connection.prepareStatement(sql)) {

            preStmt.setString(1, name);
            ResultSet result = preStmt.executeQuery();
            result.next();
            long idUser = result.getLong(1);
            String nameUser = result.getString(2);
            String loginUser = result.getString(3);
            String passwordUser = result.getString(4);



            user = new User(idUser, nameUser, loginUser, passwordUser);


        } catch (SQLException e) {
            e.printStackTrace();
        } return user;
    }


    public void addUser(User user) {
        String sql ="INSERT INTO user (name, login, password) VALUES (?, ?, ?)";
        try (PreparedStatement preStmt = connection.prepareStatement(sql)) {
            preStmt.setString(1, user.getName());
            preStmt.setString(2, user.getLogin());
            preStmt.setString(3, user.getPassword());

            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
