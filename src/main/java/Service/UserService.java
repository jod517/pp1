package Service;

import DAO.UserDao;
import User.User;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import exception.DBException;

import java.sql.*;
import java.util.List;


public class UserService {

    public UserService() {
    }

    public void updateUser(User User) {
        UserDao dao = getUserDAO();
        dao.updateUser(User);
    }

    public User getUserById(long id) {
        UserDao dao = getUserDAO();
        return dao.getUserById(id);
    }
    public boolean deleteUser(Long id)  {
        UserDao dao = getUserDAO();
        return dao.deleteUser(id);
    }

    public @NotNull
    List<User> getAllUsers() {
        try  {
            UserDao dao = getUserDAO();
            return dao.getAllUsers();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    public @Nullable
    User getUserByName(String name)  {
        try  {
            UserDao dao = getUserDAO();
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
            UserDao dao = getUserDAO();
            dao.addUser(user);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());


            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db3?").              //db name
                    append("user=root&").           //login
                    append("password=simonova12&").    //password
                    append("serverTimezone=UTC");   //timezone

            System.out.println("URL: " + url + "\n");
            return DriverManager.getConnection(url.toString());

        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
    private static UserDao getUserDAO() {
        return new UserDao(getMysqlConnection());
    }
}
