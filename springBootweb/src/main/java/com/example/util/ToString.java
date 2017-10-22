//package com.example.util;
//
//import com.example.exception.Exceptions;
//import com.google.common.collect.Maps;
//import javassist.*;
//
//import java.lang.reflect.Field;
//import java.security.ProtectionDomain;
//import java.util.Iterator;
//import java.util.Map;
//
//import static com.sun.corba.se.impl.util.RepositoryId.cache;
//
///**
// * @Author:lihang
// * @Description:
// * @Date Create in 13:41 2017/7/17
// */
//public class ToString {
//    public static String toString(Object o) {
//        if(o == null) {
//            return "null";
//        } else {
//            ToString.I i = (ToString.I)cache.get(o.getClass().getName());
//            if(i == null) {
//                synchronized(o.getClass()) {
//                    i = (ToString.I)cache.get(o.getClass().getName());
//                    if(i == null) {
//                        ToString.Generator generator = new ToString.Generator(o.getClass());
//
//                        try {
//                            i = (ToString.I)generator.generate().newInstance();
//                            cache.put(o.getClass().getName(), i);
//                        } catch (Exception var6) {
//                            throw Exceptions.newRuntimeExceptionWithoutStackTrace(var6);
//                        }
//                    }
//                }
//            }
//
//            return i.toString(o);
//        }
//    }
//
//    public Class<I> generate(){
//        this.generateBegin();
//        this.generateBody();
//        this.generateEnd();
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.beginSource);
//        Iterator source = this.bodySources.iterator();
//
//        while(source.hasNext()) {
//            String pool = (String)source.next();
//            sb.append(pool);
//        }
//
//        sb.append(this.endSources);
//        String source1 = sb.toString();
//        if(ToString.logSource) {
//            ToString.logger.info("\n{}", source1);
//        }
//
//        ClassPool pool1 = ClassPool.getDefault();
//        ClassClassPath classPath = new ClassClassPath(this.getClass());
//        pool1.insertClassPath(classPath);
//        CtClass cc = pool1.makeClass(ToString.packageName + ".ToStringImpl" + index.incrementAndGet());
//        Class copyClass = null;
//
//        try {
//            cc.addInterface(pool1.get(ToString.I.class.getName()));
//            Iterator e = this.maskKeyFields.iterator();
//
//            while(e.hasNext()) {
//                String maskKeyField = (String)e.next();
//                cc.addField(CtField.make(maskKeyField, cc));
//            }
//
//            cc.addMethod(CtNewMethod.make(source1, cc));
//            if(ToString.dumpClass != null) {
//                CtClass.debugDump = ToString.dumpClass;
//            }
//
//            ClassLoader e1 = this.getDefaultClassLoader();
//            copyClass = cc.toClass(e1, (ProtectionDomain)null);
//            return copyClass;
//        } catch (Exception var9) {
//            throw new RuntimeException(var9);
//        }
//    }
//    public static class Generator{
//        private Class source;
//        private Map<String, Field> fieldMap = Maps.newHashMap();
//        public Generator(Class source) {
//            this.source = source;
//            this.parseFields();
//        }
//        private void parseFields() {
//            for(Class acls = this.source; acls != Object.class; acls = acls.getSuperclass()) {
//                Field[] fields = acls.getDeclaredFields();
//                Field[] var3 = fields;
//                int var4 = fields.length;
//
//                for(int var5 = 0; var5 < var4; ++var5) {
//                    Field field = var3[var5];
//                    if(!this.fieldMap.containsKey(field.getName())) {
//                        this.fieldMap.put(field.getName(), field);
//                    }
//                }
//            }
//
//        }
//    }
//
//    public interface I {
//        String toString(Object var1);
//    }
//}
