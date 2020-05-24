package Service;

import DAO.UserJDBCDao;
import User.User;
import com.mysql.cj.xdevapi.SessionFactory;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import exception.DBException;
import utill.DBHelper;

import java.sql.*;
import java.util.List;


public class UserService {

    public UserService() {
    }

    public void updateUser(User User) {
        UserJDBCDao dao = getUserDAO();
        dao.updateUser(User);
    }

    public User getUserById(long id) {
        UserJDBCDao dao = getUserDAO();
        return dao.getUserById(id);
    }
    public boolean deleteUser(Long id)  {
        UserJDBCDao dao = getUserDAO();
        return dao.deleteUser(id);
    }

    public @NotNull
    List<User> getAllUsers() {
        try  {
            UserJDBCDao dao = getUserDAO();
            return dao.getAllUsers();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    public @Nullable
    User getUserByName(String name)  {
        try  {
            UserJDBCDao dao = getUserDAO();
            return dao.getUserByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addUser(User user) throws DBException {
           if (getUserByName(user.getName()) != null) {
            return false;
        }
        try  {
            UserJDBCDao dao = getUserDAO();
            dao.addUser(user);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserJDBCDao getUserDAO() {
        return new UserJDBCDao(DBHelper.getConnection());
    }
}
