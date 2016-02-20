package com.zet.business.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zet.business.base.dao.BaseDAO;

/**
 * 
 * @author manle
 * 
 */
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> read(String queryName, Object[] param, Class[] entities) {

        Query query = getSessionFactory().getCurrentSession().getNamedQuery(queryName);

        SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(query.getQueryString());

        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                sqlQuery.setParameter(i, param[i]);
            }
        }
        if (entities != null) {
            for (Class clazz : entities) {
                sqlQuery.addEntity(clazz);
            }
        }
        return sqlQuery.list();

    }

    public Integer save(String queryName, Object[] param) {

        Query query = getSessionFactory().getCurrentSession().getNamedQuery(queryName);
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                query.setParameter(i, param[i]);
            }
        }
        return query.executeUpdate();
    }

}
