package com.jsdx.base;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <T>
 * @param <PK>
 */
public class BaseDao<T extends BaseEntity, PK extends Serializable> extends SqlSessionDaoSupport {

    private String namespace;

    public static final String SQLID_INSERT = "insert";
    public static final String SQLID_INSERT_BATCH = "insertBatch";
    public static final String SQLID_UPDATE = "update";
    public static final String SQLID_UPDATE_PARAM = "updateParam";
    public static final String SQLID_UPDATE_BATCH = "updateBatch";
    public static final String SQLID_DELETE = "delete";
    public static final String SQLID_DELETE_PARAM = "deleteParam";
    public static final String SQLID_DELETE_BATCH = "deleteBatch";
    public static final String SQLID_TRUNCATE = "truncate";
    public static final String SQLID_SELECT = "select";
    public static final String SQLID_SELECT_PK = "selectPk";
    public static final String SQLID_SELECT_PARAM = "selectParam";
    //public static final String SQLID_SELECT_FK = "selectFk";
    public static final String SQLID_COUNT = "count";
    public static final String SQLID_COUNT_PARAM = "countParam";

    public BaseDao(){
        ParameterizedType g_type=(ParameterizedType)getClass().getGenericSuperclass();
        Class <T> entityClass = (Class <T>) g_type.getActualTypeArguments()[0];
        this.namespace=entityClass.getPackage().getName()+".mapper";
    }

    @Resource(name = "sqlSessionTemplate")
    public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public int insert(T entity) {
        entity.setCreateTime(new Date());
        entity.setCreateUserId(1);
        entity.setDelFlag(0);

        int rows = 0;
        try {
            rows = getSqlSession().insert(namespace + "." + SQLID_INSERT, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int update(T entity) {
        int rows = 0;
        try {
            rows = getSqlSession().update(namespace + "." + SQLID_UPDATE, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int updateParam(Map param) {
        int rows = 0;
        try {
            rows = getSqlSession().update(namespace + "." + SQLID_UPDATE_PARAM, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int delete(PK primaryKey) {
        int rows = 0;
        try {
            rows = getSqlSession().delete(namespace + "." + SQLID_DELETE, primaryKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int deleteParam(Map param) {
        int rows = 0;
        try {
            rows = getSqlSession().delete(namespace + "." + SQLID_DELETE_PARAM, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int truncate() {
        int rows = 0;
        try {
            rows = getSqlSession().delete(namespace + "." + SQLID_TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int count() {
        int result = 0;
        try {
            result = getSqlSession().selectOne(namespace + "." + SQLID_COUNT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int count(Object param) {
        int result = 0;
        try {
            result = getSqlSession().selectOne(namespace + "." + SQLID_COUNT_PARAM, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public T get(PK primaryKey) {
        try {
            return getSqlSession().selectOne(namespace + "." + SQLID_SELECT_PK, primaryKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> select() {
        try {
            return getSqlSession().selectList(namespace + "." + SQLID_SELECT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<T> selectParam(Map param) {
        try {
            return getSqlSession().selectList(namespace + "." + SQLID_SELECT_PARAM, param);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PagingResult<T> selectPagination(PageEntity pageEntity) {
        try {
            int page = pageEntity.getPage() == null || "".equals(pageEntity.getPage()) ? 1 : pageEntity.getPage();
            int size = pageEntity.getSize() == null || "".equals(pageEntity.getSize()) ? 15 : pageEntity.getSize();

            RowBounds rowBounds = new RowBounds((page - 1) * size, size);

            Map param = pageEntity.getParams();
            if (param != null) {
                param.put("orderColumn", pageEntity.getOrderColumn());
                param.put("orderTurn", pageEntity.getOrderTurn());
            } else {
                param = new HashMap();
                param.put("orderColumn", pageEntity.getOrderColumn());
                param.put("orderTurn", pageEntity.getOrderTurn());
            }

            List<T> resultList = getSqlSession().selectList(namespace + "." + SQLID_SELECT_PARAM, param, rowBounds);
            int totalSize = count(pageEntity.getParams());

            PagingResult<T> pagingResult = new PagingResult<T>();
            pagingResult.setCurrentPage(page);
            pagingResult.setPageSize(pageEntity.getSize());
            pagingResult.setTotalSize(totalSize);
            pagingResult.setResultList(resultList);
            return pagingResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertBatch(List<T> list) {
        try {
            return getSqlSession().insert(namespace + "." + SQLID_INSERT_BATCH, list);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateBatch(List<T> list) {
        int rows = 0;
        try {
            for (T t : list) {
                rows = rows + getSqlSession().update(namespace + "." + SQLID_UPDATE_BATCH, t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;

    }

    public int deleteBatch(List<PK> list) {
        try {
            return getSqlSession().delete(namespace + "." + SQLID_DELETE_BATCH, list);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}

