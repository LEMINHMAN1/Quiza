package com.zet.business.base.dao;

import java.util.List;

public interface BaseDAO<T> {

    @SuppressWarnings("rawtypes")
    public List<T> read(String queryName, Object[] param, Class[] entities);

    public Integer save(String queryName, Object[] param);
}