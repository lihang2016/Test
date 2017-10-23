package com.example;

import cn.fh.pkgscanner.PkgScanner;
import com.example.common.udc.UDC;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.service.MemberAppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private MemberAppService memberAppService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUDC(){
		LoginDto loginDto=new LoginDto();
		loginDto.setSex(UDC.newUDCWithItemCode("sex", "man"));
		memberAppService.findByPhoneAndPassword(loginDto);
	}

	@Test
	public void testScan(){
		Long startTime=System.currentTimeMillis();
		PkgScanner scanner = new PkgScanner("com.example", RestController.class);
		try {
			List<String> stringList=scanner.scan();
			Long endTime=System.currentTimeMillis();
			System.out.println("总共用时:"+(endTime-startTime)+"ms");
			for(String s:stringList){
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





}
