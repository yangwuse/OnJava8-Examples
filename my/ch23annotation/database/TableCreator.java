package my.ch23annotation.database;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

import bookcode.annotations.database.Constraints;
import bookcode.annotations.database.DBTable;
import bookcode.annotations.database.SQLInteger;
import bookcode.annotations.database.SQLString;

public class TableCreator {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        // 类名包含完整的从类路径到当前文件的包名
        // my.ch23annotation.TableCreator.class
        for (String className : args) {
            // Class.forName 根据完整类名加载类(.class)
            Class<?> cl = Class.forName(className);
            // 反射获取类的「数据库表」注解对象
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class "
                + className);
                continue;
            }
            String tableName = dbTable.name();
            // 如果表名为空 使用类名替代
            if (tableName.length() < 1) 
                tableName = cl.getName().toUpperCase();
            // 遍历类的字段 存储各个字段的注解信息
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                // 存储该字段所有注解
                Annotation[] anns = field.getDeclaredAnnotations();
                // 不是一个注解字段
                if (anns.length < 1)
                    continue; 
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger)anns[0];
                    // 如果未指定 name 使用字段名替代
                    if (sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(columnName + " INT" + 
                        getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // 如果未指定 name 使用字段名替代
                    if (sString.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();
                    columnDefs.add(columnName + " VARCHAR(" + 
                        sString.value() + ")" + getConstraints(sString.constraints()));
                }
                StringBuilder createdCommand = new StringBuilder(
                    " CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) 
                    createdCommand.append("\n    " + columnDef + ",");
                // 删除最后一个逗号
                createdCommand.deleteCharAt(createdCommand.length() - 1);
                createdCommand.append(");");
                System.out.println("Table Creation SQL for " + className +
                " is:\n" + createdCommand);
            }
        }
    }

    public static String getConstraints(Constraints constraints) {
        StringBuilder sb = new StringBuilder();
        if (!constraints.allowNull()) 
            sb.append(" NOT NULL");
        if (constraints.primaryKey())
            sb.append(" PRIMARY KEY");
        if (constraints.unique())
            sb.append(" UNIQUE");
        return sb.toString();
    }
}
