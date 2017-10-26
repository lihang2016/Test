package com.example;

//import cn.fh.pkgscanner.PkgScanner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by 96230 on 2017/4/17.
 */
@Component
@ConfigurationProperties(prefix = "book")
public class AuthorSettings {

    private String author;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public static void main(String[] args) {
//        testScan();
//    }

//    public static  <T> void testScan(){
//        System.out.println("扫描全部枚举类开始");
//        Long startTime=System.currentTimeMillis();
//        PkgScanner scanner = new PkgScanner("com.example", Entity.class);//
//        try {
//            List<String> stringList=scanner.scan();//扫描实体。返回包名路径
//            stringList=asList("com.example.member.domain.entity.Member");
//            Long endTime=System.currentTimeMillis();
//            System.out.println("总共用时:"+(endTime-startTime)+"ms");
//            for(String s:stringList){
//                Class cls=  Class.forName(s);//加载实体类
//                Field[] fields=cls.getDeclaredFields();//加载实体类的字段
//                for(Field field:fields){
//                    if(field.getType().isEnum()){
//                      Column column= field.getAnnotation(Column.class);
//                        if(column!=null){
//                            System.out.println(column.columnDefinition());
//                        }
//                        Method toName = field.getType().getMethod("getMsg");
//                        Method getCode = field.getType().getMethod("getCode");
//                        T[] tClass= (T[]) field.getType().getEnumConstants();
//                        System.out.println(tClass.length);
//                        for(T t:tClass){
//                            System.out.println("值:"+toName.invoke(t)+"");
//                            System.out.println("code:"+getCode.invoke(t));
//                        }
//                    }
//
//                }
//            }
//            System.out.println("扫描枚举加入缓存成功。");
//            System.out.println("扫描全部枚举类结束");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
}
