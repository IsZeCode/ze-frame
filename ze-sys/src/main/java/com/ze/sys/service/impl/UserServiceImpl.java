package com.ze.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ze.entity.PageResult;
import com.ze.sys.entity.dto.UserDto;
import com.ze.sys.entity.dto.UserPageDto;
import com.ze.sys.entity.po.UserPo;
import com.ze.sys.dao.UserMapper;
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

    @Override
    public PageResult<UserPo> getUserPage(UserPageDto userPageDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userPageDto, userPo);
        // 首先创建一个Page对象，传入当前偏移量和页面大小
        IPage<UserPo> userPoPage = new Page<>(userPageDto.getPageIndex(), userPageDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPo, userPoPage);
        PageResult<UserPo> userPoPageResult = new PageResult<>();
        // 调用自定义的分页工具类PageResult，将结果进行装载
        userPoPageResult.loadData(userPage);
        return userPoPageResult;
    }
}