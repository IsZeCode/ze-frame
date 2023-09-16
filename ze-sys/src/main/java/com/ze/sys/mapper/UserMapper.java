package com.ze.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ze.sys.entity.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPo> {
}