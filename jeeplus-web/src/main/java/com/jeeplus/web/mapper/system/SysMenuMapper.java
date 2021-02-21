package com.jeeplus.web.mapper.system;

import com.jeeplus.web.entities.system.SysMenuEntity;
import com.jeeplus.web.mapper.BaseMapper;

import java.util.List;

/**
 * 菜单管理
 * @author:yuzp17311
 * @version:v1.0
 * @date: 2016-12-12 9:41.
 */
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

}
