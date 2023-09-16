package com.ze.sys.collection;


import com.ze.bean.Result;
import com.ze.sys.entity.dto.UserDto;
import com.ze.sys.entity.req.UserReq;
import com.ze.sys.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserReq userReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        int i = 1 / 0;
        return Result.ok(userService.addUser(userDto));
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        return Result.ok(userService.deleteUser(id));
    }
}
