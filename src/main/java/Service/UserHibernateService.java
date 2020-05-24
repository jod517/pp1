package Service;

import org.hibernate.SessionFactory;
import utill.DBHelper;

public class UserHibernateService {

    private static UserHibernateService userHibernateService;

    private SessionFactory sessionFactory;

    private UserHibernateService(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory}

public static UserHibernateService getInstance(){
        if (userHibernateService == null) {
            userHibernateService = new UserHibernateService(DBHelper.getSessionFactory());
        }
        return userHibernateService;
}


}
