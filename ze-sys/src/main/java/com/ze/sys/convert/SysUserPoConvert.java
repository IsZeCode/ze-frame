package com.ze.sys.convert;

import com.ze.sys.entity.po.SysUserPo;
import com.ze.sys.entity.req.PageSysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 一定要使用org.mapstruct包下的@Mapper注解
 */
@Mapper
public interface SysUserPoConvert {
    SysUserPoConvert INSTANCE = Mappers.getMapper(SysUserPoConvert.class);

    /**
     * 可用 @Mapping(source = "",target = "")
     * 对类型进行转换
     *
     * @param pageSysUserReq
     * @return
     */
    SysUserPo convertDtoToPo(PageSysUserReq pageSysUserReq);

}