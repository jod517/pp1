package Service;

import DAO.UserDao;
import User.User;
import com.sun.istack.internal.Nullable;
import exception.DBException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {

    public UserService() {
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db3?").          //db name
                    append("user=root&").          //login
                    append("password=simonova12");       //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDao getUserDAO() {
        return new UserDao(getMysqlConnection());
    }

    public static User getUserByName(String name) { // Почему нет исключения?????
        return getUserDAO().getUserByName(name);
    }

    public static boolean addUser(User user) throws SQLException {
        if (getUserByName(user.getName()) == null) {
            getUserDAO().addUser(user);
            return true;
        }
        return false;
    }
}
