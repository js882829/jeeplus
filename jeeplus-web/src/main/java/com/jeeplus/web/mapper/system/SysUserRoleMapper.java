package com.jeeplus.web.mapper.system;

import com.jeeplus.web.entities.system.SysUserRoleEntity;
import com.jeeplus.web.mapper.BaseMapper;

import java.util.List;

/**
 * 用户与角色对应关系
 * @author:yuzp17311
 * @version:v1.0
 * @date: 2016-12-12 9:46.
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

}
