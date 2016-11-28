package com.jsdx.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Max on 2016/10/18.
 */
public class BaseService<T extends BaseEntity, PK extends Serializable> {

    @Autowired
    private BaseDao<T, PK> dao;

    public boolean insert(T entity) {
        int result = dao.insert(entity);
        if (result == 0)
            return false;
        else
            return true;
    }

    public boolean delete(PK primaryKey) {
        int result = dao.delete(primaryKey);
        if (result == 0)
            return false;
        else
            return true;
    }

    public boolean update(T entity) {
        int result = dao.update(entity);
        if (result == 0)
            return false;
        else
            return true;
    }

    public T get(PK primaryKey){
        return dao.get(primaryKey);
    }

    public PagingResult<T> selectPagination(PageEntity pageEntity) {
        return dao.selectPagination(pageEntity);
    }

    public List<T> select() {
        return dao.select();
    }
}
