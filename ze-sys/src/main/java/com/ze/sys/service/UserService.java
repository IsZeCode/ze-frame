package com.ze.sys.service;

import com.ze.entity.PageResult;
import com.ze.sys.entity.dto.UserDto;
import com.ze.sys.entity.dto.UserPageDto;
import com.ze.sys.entity.po.UserPo;

public interface UserService {
    int addUser(UserDto userDto);

    int deleteUser(Integer id);

    PageResult<UserPo> getUserPage(UserPageDto userPageDto);
}
