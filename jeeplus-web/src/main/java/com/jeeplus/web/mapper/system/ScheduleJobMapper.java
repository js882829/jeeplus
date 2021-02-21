package com.jeeplus.web.mapper.system;

import com.jeeplus.web.entities.system.ScheduleJobEntity;
import com.jeeplus.web.mapper.BaseMapper;

import java.util.Map;

/**
 * 定时任务
 * @author:yuzp17311
 * @version:v1.0
 * @date: 2016-12-12 9:37.
 */
public interface ScheduleJobMapper extends BaseMapper<ScheduleJobEntity> {

    /**

     * 批量更新状态

     */
    int updateBatch(Map<String, Object> map);

}
