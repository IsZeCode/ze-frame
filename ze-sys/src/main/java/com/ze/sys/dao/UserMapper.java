package com.ze.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ze.sys.entity.po.UserPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPo> {
    IPage<UserPo> getUserPage(@Param("po") UserPo userPo,
                              IPage<UserPo> userPoPage);
}