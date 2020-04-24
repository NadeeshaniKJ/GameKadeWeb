package com.kanchi.dao;

import com.kanchi.dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User saved successfully, User Details= " + user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createQuery("from User").list();

        for(User user : usersList){
            logger.info("Users List: " + user);
        }

        return usersList;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        logger.info("User loaded successfully, User details= "+user);
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("user updated successfully, user Details= "+user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if(user != null){
            session.delete(user);
        }
        logger.info("Person deleted successfully, person details= "+user );
    }

    @Override
    public String getUserNameById(int id) {
        return null;
    }

    @Override
    public int getUserCount() {
        String hql ="Select count(*) from User";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        int count =Integer.parseInt(query.uniqueResult().toString());
        logger.info("getUserCount="+ count);
        return count; // must use hibernate.query.Query package
    }
}
