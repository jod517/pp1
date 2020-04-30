package DAO;

import User.User;
<<<<<<< HEAD
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
=======
import com.sun.istack.internal.Nullable;

import java.sql.*;
>>>>>>> 4a6a73886ab8147813e1c4493238f2b2226fbf4c

public class UserDao {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

<<<<<<< HEAD
    public UserDao() {

    }

    public @NotNull
    List<User> getAllUsers() throws SQLException {

        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery("SELECT * FROM user ")
        ) {
            List<User> usersList = new ArrayList<>();

            while (result.next()) {
                User user = new User(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("login"),
                        result.getString("password")

                );
                usersList.add(user);
            }
            return (usersList.isEmpty()) ? Collections.emptyList() : usersList;
        }
    }

    private @Nullable
    User getClientBySqlQuery(final String sql, final String... args)
            throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                stmt.setString(i + 1, args[i]);
            }
            try (ResultSet result = stmt.executeQuery()) {
                User user = null;
                if (result.next()) {
                    user = new User(
                            result.getLong("id"),
                            result.getString("name"),
                            result.getString("login"),
                            result.getString("password")
                    );
                }
                return user;
            }
        }
    }

    public @Nullable
    User getUserByName(final String name) throws SQLException {
        return getClientBySqlQuery("SELECT * FROM user WHERE name=?", name);
    }

    public void addUser(User user) throws SQLException {
        int updatesCount = 0;
        if (getUserByName(user.getName()) == null) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO user (name, login, password) values (?, ?, ?)")
            ) {
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getLogin());
                stmt.setString(3, user.getPassword());
                updatesCount = stmt.executeUpdate();
            }
        }
        if (updatesCount != 1) {
            throw new IllegalStateException("Error while adding client!");
=======
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
>>>>>>> 4a6a73886ab8147813e1c4493238f2b2226fbf4c
        }
    }
}
