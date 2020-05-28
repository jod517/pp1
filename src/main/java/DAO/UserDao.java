package DAO;

import User.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO  {

    void updateUser(User user);
    User getUserById(long id);
    boolean deleteUser(Long id);
    List<User> getAllUsers() throws SQLException;
    User getUserByName(String name) throws SQLException;
    boolean addUser(User user) throws SQLException;


}
