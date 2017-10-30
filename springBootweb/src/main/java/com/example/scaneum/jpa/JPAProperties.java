///*
// *
// * Copyright (c) 2016 All Rights Reserved
// */
//
///*
// * 修订记录:
// *  2016-12-25 14:00 创建
// */
//package com.example.scaneum.jpa;
//
//import com.google.common.collect.Maps;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import java.util.Map;
//
//import static com.example.scaneum.jpa.JPAProperties.PREFIX;
//
///**
// *
// */
//@ConfigurationProperties(prefix = PREFIX)
//@Getter
//@Setter
//public class JPAProperties {
//	public static final String PREFIX = "zds.jpa";
//	public static final String ENABLE_KEY = PREFIX + ".enable";
//	private boolean enable = true;
//	private boolean openEntityManagerInViewFilterEnable = true;
//	private Map<String,String> entityPackagesToScan= Maps.newHashMap();
//
//	public JPAProperties() {
//		entityPackagesToScan.put("app0", "com.example.**.entity");
////		entityPackagesToScan.put("components0", COMPONENTS_PACKAGE+".**.entity");
//
//	}
//}
