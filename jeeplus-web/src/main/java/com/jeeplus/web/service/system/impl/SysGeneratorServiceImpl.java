package com.jeeplus.web.service.system.impl;

import com.jeeplus.web.mapper.system.SysGeneratorMapper;
import com.jeeplus.web.service.system.SysGeneratorService;
import com.jeeplus.web.util.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @author:yuzp17311
 * @version:v1.0
 * @date: 2016-12-30 17:39.
 */
@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {

    @Autowired
    private SysGeneratorMapper generatorMapper;

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return generatorMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return generatorMapper.queryTotal(map);
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return generatorMapper.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorMapper.queryColumns(tableName);
    }

    /**
     * 生成代码
     *
     * @param tableNames
     */
    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        ZipOutputStream zip=new ZipOutputStream(outputStream);

        for(String tableName : tableNames){
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
