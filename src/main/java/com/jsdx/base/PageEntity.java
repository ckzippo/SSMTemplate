package com.jsdx.base;

import java.util.Map;

/**
 * 分页实体类
 * @author ckzippo
 */
public class PageEntity {

    private Integer page = 1;
    private Integer size = 10;
    private Map params = null;
    private String orderColumn = "id";
    private String orderTurn = "DESC";

    public PageEntity(Integer page) {
        this.page = (page != null && page != 0) ? page : 1;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderTurn() {
        return orderTurn;
    }

    public void setOrderTurn(String orderTurn) {
        this.orderTurn = orderTurn;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}

