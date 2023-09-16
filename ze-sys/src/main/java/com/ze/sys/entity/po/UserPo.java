package com.ze.sys.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ze.entity.BaseEntity;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserPo extends BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;
}
