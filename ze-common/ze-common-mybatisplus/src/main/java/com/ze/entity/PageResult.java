package com.ze.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 每页的记录数
     */
    private Long size;

    /**
     * 当前页数
     */
    private Long current;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 数据集合
     */
    private List<T> records = Collections.emptyList();

    public void loadData(IPage<T> pageData) {
        this.setTotal(pageData.getTotal());
        this.setSize(pageData.getSize());
        this.setCurrent(pageData.getCurrent());
        this.setPages(pageData.getPages());
        this.setRecords(pageData.getRecords());
    }

}