package DAO;

import User.User;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

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
        }
    }
}
