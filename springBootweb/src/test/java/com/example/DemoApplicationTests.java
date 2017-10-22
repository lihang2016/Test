package com.example;

import com.example.common.udc.UDC;
import com.example.member.app.dto.LoginDto;
import com.example.member.app.service.MemberAppService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

	@Before
	public void test(){

	}

}
