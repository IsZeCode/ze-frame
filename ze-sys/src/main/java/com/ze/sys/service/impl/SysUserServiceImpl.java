package com.ze.sys.service.impl;

import com.ze.page.PageResponse;
import com.ze.sys.convert.SysUserPoConvert;
import com.ze.sys.entity.SysUser;
import com.ze.sys.dao.SysUserDao;
import com.ze.sys.entity.po.SysUserPo;
import com.ze.sys.entity.req.PageSysUserReq;
import com.ze.sys.service.SysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-09-17 11:02:33
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     * Cacheable 添加缓存
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    // 得写在 server 层
    @Cacheable(cacheNames = "SysUser", key = "'querySysUserById'+#id")
    public SysUser queryById(Long id) {
        System.out.println("我在找数据库 哦");
        return this.sysUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param pageSysUserReq 筛选条件
     * @return 查询结果
     */
    @Override
    public PageResponse<SysUser> queryByPage(PageSysUserReq pageSysUserReq) {

        /**
         * 效率慢的问题
         */
//        SysUserPo sysUserPo = new SysUserPo();
//        BeanUtils.copyProperties(pageSysUserReq, sysUserPo);

        SysUserPo sysUserPo = SysUserPoConvert.INSTANCE.convertDtoToPo(pageSysUserReq);

        PageResponse<SysUser> pageResponse = new PageResponse<>();
        // 获取页码
        pageResponse.setCurrent(pageSysUserReq.getPageNo());
        // 获取每一页的数量
        pageResponse.setPageSize(pageResponse.getPageSize());
        // 开始的 index
        long pageStart = (pageSysUserReq.getPageNo() - 1) * pageSysUserReq.getPageSize();
        // 总计
        long total = this.sysUserDao.count(sysUserPo);
        List<SysUser> sysUsers = this.sysUserDao.queryAllByLimit(sysUserPo, pageStart, total);
        pageResponse.setTotal(total);
        pageResponse.setRecords(sysUsers);
        return pageResponse;
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     * CacheEvict 清理缓存
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(cacheNames = "SysUser", key = "'querySysUserById'+#sysUser.id")
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return sysUser;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserDao.deleteById(id) > 0;
    }
}
