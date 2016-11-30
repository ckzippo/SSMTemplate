package com.jsdx.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author ckzippo
 */
public class BaseService<T extends BaseEntity, PK extends Serializable> {

    @Autowired
    private BaseDao<T, PK> dao;

    public boolean insert(T entity) {
        return dao.insert(entity) == 0 ? false : true;
    }

    public boolean delete(PK primaryKey) {
        return dao.delete(primaryKey) == 0 ? false : true;
    }

    public boolean update(T entity) {
        return dao.update(entity) == 0 ? false : true;
    }

    public T get(PK primaryKey) {
        return dao.get(primaryKey);
    }

    public PagingResult<T> selectPagination(PageEntity pageEntity) {
        return dao.selectPagination(pageEntity);
    }

    public List<T> select() {
        return dao.select();
    }
}
