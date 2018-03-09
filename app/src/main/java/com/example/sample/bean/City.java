package com.example.sample.bean;

import com.example.sample.dao.CityDao;
import com.example.sample.dao.DaoSession;
import com.example.sample.dao.SchoolDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/12/29
 * 描述:
 */
@Entity
public class City {

    /**
     * id : 1
     * name : 福建省
     */

    @Id
    private int id;
    private String name;
    @ToMany(referencedJoinProperty = "pid")
    private List<School> schools;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 448079911)
    private transient CityDao myDao;

    @Generated(hash = 1551848712)
    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 750791287)
    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1032631192)
    public List<School> getSchools() {
        if (schools == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SchoolDao targetDao = daoSession.getSchoolDao();
            List<School> schoolsNew = targetDao._queryCity_Schools(id);
            synchronized (this) {
                if (schools == null) {
                    schools = schoolsNew;
                }
            }
        }
        return schools;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1489343692)
    public synchronized void resetSchools() {
        schools = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 293508440)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCityDao() : null;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
