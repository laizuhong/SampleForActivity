package com.example.sample.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.sample.bean.BookBean;
import com.example.sample.bean.City;
import com.example.sample.bean.School;

import com.example.sample.dao.BookBeanDao;
import com.example.sample.dao.CityDao;
import com.example.sample.dao.SchoolDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookBeanDaoConfig;
    private final DaoConfig cityDaoConfig;
    private final DaoConfig schoolDaoConfig;

    private final BookBeanDao bookBeanDao;
    private final CityDao cityDao;
    private final SchoolDao schoolDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookBeanDaoConfig = daoConfigMap.get(BookBeanDao.class).clone();
        bookBeanDaoConfig.initIdentityScope(type);

        cityDaoConfig = daoConfigMap.get(CityDao.class).clone();
        cityDaoConfig.initIdentityScope(type);

        schoolDaoConfig = daoConfigMap.get(SchoolDao.class).clone();
        schoolDaoConfig.initIdentityScope(type);

        bookBeanDao = new BookBeanDao(bookBeanDaoConfig, this);
        cityDao = new CityDao(cityDaoConfig, this);
        schoolDao = new SchoolDao(schoolDaoConfig, this);

        registerDao(BookBean.class, bookBeanDao);
        registerDao(City.class, cityDao);
        registerDao(School.class, schoolDao);
    }
    
    public void clear() {
        bookBeanDaoConfig.clearIdentityScope();
        cityDaoConfig.clearIdentityScope();
        schoolDaoConfig.clearIdentityScope();
    }

    public BookBeanDao getBookBeanDao() {
        return bookBeanDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public SchoolDao getSchoolDao() {
        return schoolDao;
    }

}