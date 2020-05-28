package Service;

import DAO.UserHibernateDAO;
import User.User;
import exception.DBException;
import org.hibernate.SessionFactory;
import utill.DBHelper;

import java.util.List;


public class UserService {

    private static UserService userService;

    private SessionFactory sessionFactory;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public UserService() {
    }

    public void updateUser(User user) {
//        UserJDBCDao dao = getUserDAO();
//        dao.updateUser(user);
        UserHibernateDAO dao = new UserHibernateDAO(sessionFactory.openSession());
        dao.updateUser(user);
    }

    public User getUserById(long id) {
//        UserJDBCDao dao = getUserDAO();
//        return dao.getUserById(id);
        UserHibernateDAO dao = new UserHibernateDAO(sessionFactory.openSession());
        return dao.getUserById(id);
    }


    public boolean deleteUser(Long id)  {
//        UserJDBCDao dao = getUserDAO();
//        return dao.deleteUser(id);
        new UserHibernateDAO(sessionFactory.openSession()).deleteUser(id);
        return true;
    }


          public List<User> getAllUsers() {
//        try  {
//            UserJDBCDao dao = getUserDAO();
//            return dao.getAllUsers();
//        } catch (SQLException e){
//            throw new RuntimeException(e);
//        }
        List<User> list = null;
              UserHibernateDAO dao =new UserHibernateDAO(sessionFactory.openSession());
              list = dao.getAllUsers();
              return list;
    }



   public User getUserByName(String name)  {
//        try  {
//            UserJDBCDao dao = getUserDAO();
//            return dao.getUserByName(name);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
       UserHibernateDAO dao = new UserHibernateDAO(sessionFactory.openSession());
       return dao.getUserByName(name);
    }

    public boolean addUser(User user) throws DBException {
//
//        try  {
//            UserJDBCDao dao = getUserDAO();
//            dao.addUser(user);
//            return true;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        UserHibernateDAO dao = new UserHibernateDAO(sessionFactory.openSession());
        dao.addUser(user);
        return true;
    }

//    private static UserJDBCDao getUserDAO() {
//        return new UserJDBCDao(DBHelper.getConnection());
//
//    }
}
