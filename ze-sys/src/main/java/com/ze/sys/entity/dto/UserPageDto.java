package com.ze.sys.entity.dto;

import lombok.Data;

@Data
public class UserPageDto {

    private String name;

    private Integer age;

    private Integer pageIndex;

    private Integer pageSize;
}
