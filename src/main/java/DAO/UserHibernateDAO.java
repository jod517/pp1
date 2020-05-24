package DAO;



import User.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private Session session;
    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public void updateUser(User user) {
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();

    }

    @Override
    public User getUserById(long id) {
        session.beginTransaction();
        User user = (User) session.load(User.class,id);
        session.close();
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        session.beginTransaction();
        User user = null;
        user = getUserById(id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        session.beginTransaction();
        List<User> allusers = session.createQuery("FROM User").list();
        session.getTransaction().commit();
        session.close();
        return allusers;
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        session.beginTransaction();
        user = (User)session.get(User.class, name);
        session.getTransaction().commit();
        return user;


    }

    @Override
    public boolean addUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
