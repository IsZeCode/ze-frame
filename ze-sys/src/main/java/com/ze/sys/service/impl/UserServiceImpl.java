package com.ze.sys.service.impl;

import com.ze.sys.entity.dto.UserDto;
import com.ze.sys.entity.po.UserPo;
import com.ze.sys.mapper.UserMapper;
import com.ze.sys.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        int count = userMapper.insert(userPo);
        return count;
    }

    @Override
    public int deleteUser(Integer id) {
        int count = userMapper.deleteById(id);
        return count;
    }
}