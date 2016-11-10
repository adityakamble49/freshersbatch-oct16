package com.aditya.spring_rest_hibernate.dao;

import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.spring_rest_hibernate.entity.Advertise;
import com.aditya.spring_rest_hibernate.entity.User;

import antlr.Token;

public class AdvertiseDaoImp implements AdvertiseDao {

    @Autowired
    public HibernateTemplate hibernateTemplate;

    @Transactional
    public Advertise addAdvertisement(Advertise advertisement) {
        hibernateTemplate.save(advertisement);
        return advertisement;
    }

    @Transactional
    public User addUser(User user) {
        hibernateTemplate.save(user);
        return user;
    }

    @Transactional
    public User checkUser(User user) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("username", user.getUserName()));
        criteria.add(Restrictions.eq("password", user.getPassword()));
        List<?> foundUsers = hibernateTemplate.findByCriteria(criteria);
        if (foundUsers != null && foundUsers.size() != 0) {
            return (User) foundUsers.get(0);
        }
        return null;
    }

    @Transactional
    public boolean generateToken(User user) {
        Token token = new Token(user.getId(),
                new String(Base64.encodeBase64(user.getPassword().getBytes())));
        hibernateTemplate.save(token);
        return false;
    }
}
