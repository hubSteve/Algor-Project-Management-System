package com.algor.codepool.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;

public class QueryUtils<T> {

    private T t;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    public QueryUtils(T t) {
        this.t = t;
    }

    public String sqlBuilder() {
        Class<?> bean = t.getClass();
        Table table = bean.getAnnotation(Table.class);
        StringBuilder fieldBuilder = new StringBuilder("select ");
        Field[] fields = bean.getDeclaredFields();
        StringBuilder queryBuilder = new StringBuilder("where ");
        int fieldCnt = 0;
        for (Field f : fields) {
            Column annotation = f.getAnnotation(Column.class);
            if (annotation != null) {
                fieldBuilder.append(annotation.name()).append(", ");
            }
            f.setAccessible(true);
            Object o;
            try {
                o = f.get(t);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (o != null) {
                if (fieldCnt > 0) {
                    queryBuilder.append(" and ");
                }
                ++fieldCnt;
                queryBuilder
                        .append(annotation.name()).append(" = ")
                        .append("'")
                        .append(o)
                        .append("'");
            }
        }
        String fieldStr = fieldBuilder.substring(0, fieldBuilder.length() - 2);
        return fieldStr + " from " + table.name() + " " + queryBuilder;
    }

    public static boolean isEmpty(Object t) {
        Class<?> aClass = t.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(t) != null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
