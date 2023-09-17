package com.ze.sys.controller;


import com.ze.bean.Result;
import com.ze.sys.entity.dto.UserDto;
import com.ze.sys.entity.dto.UserPageDto;
import com.ze.sys.entity.req.UserPageReq;
import com.ze.sys.entity.req.UserReq;
import com.ze.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户Controller")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户")
    public Result addUser(@RequestBody UserReq userReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        return Result.ok(userService.addUser(userDto));
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        return Result.ok(userService.deleteUser(id));
    }

    @GetMapping("/getUserPage")
    public Result getUserPage(@RequestBody UserPageReq userPageReq) {
        UserPageDto userPageDto = new UserPageDto();
        BeanUtils.copyProperties(userPageReq, userPageDto);
        return Result.ok(userService.getUserPage(userPageDto));
    }


}
