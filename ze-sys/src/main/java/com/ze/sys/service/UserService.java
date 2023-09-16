package com.ze.sys.service;

import com.ze.sys.entity.dto.UserDto;

public interface UserService {
    int addUser(UserDto userDto);

    int deleteUser(Integer id);
}
