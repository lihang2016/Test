package com.example.mybatisMapper;

import com.google.common.collect.Maps;
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;
import java.util.Map;

/**
 * @Author:lihang
 * @Description:
 * @Date Create in 10:16 2017/10/26
 */
public class InsterDemoMapper extends MapperTemplate {
    public InsterDemoMapper(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    public String instartList(MappedStatement ms){
        final Class<?> entityClass = getEntityClass(ms);
        //将返回值修改为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        Map<String, Class<?>> fieldsTypes = Maps.newHashMap();
        EntityTable entityTable = EntityHelper.getEntityTable(entityClass);
        for (EntityColumn column : entityTable.getEntityClassColumns()) {
            fieldsTypes.put(column.getProperty(), column.getJavaType());
        }
        System.out.println(sql.toString());
        System.out.println("进来了");
        return sql.toString();
    }

}
