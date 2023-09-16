package com.ze.sys.entity.req;

import lombok.Data;

/**
 * 和 mp 默认给的类 PageRequest 差不多
 */
@Data
public class UserPageReq {
    /**
     * where 条件
     */
    private String name;

    /**
     * where 条件
     */
    private Integer age;

    /**
     * 分页页数(应该是pageNo)
     */
    private Integer pageIndex;

    /**
     * 每页数量
     */
    private Integer pageSize;
}
