package com.ze.sys.controller;

import com.ze.bean.Result;
import com.ze.page.PageResponse;
import com.ze.sys.entity.SysUser;
import com.ze.sys.entity.po.SysUserPo;
import com.ze.sys.entity.req.PageSysUserReq;
import com.ze.sys.service.SysUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2023-09-17 11:02:29
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @param pageSysUserReq 筛选条件
     * @return 查询结果
     */
    @GetMapping("/getPage")
    public Result<PageResponse<SysUserPo>> queryByPage(@RequestBody PageSysUserReq pageSysUserReq) {
        return Result.ok(this.sysUserService.queryByPage(pageSysUserReq));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SysUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据 可添加未有规范数据插入
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SysUser> add(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SysUser> edit(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据 直接删除 不是 逻辑删除
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sysUserService.deleteById(id));
    }

}

