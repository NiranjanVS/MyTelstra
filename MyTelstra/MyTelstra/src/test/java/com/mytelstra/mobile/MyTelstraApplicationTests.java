package com.mytelstra.mobile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mytelstra.mobile.entity.RechargeInfo;
import com.mytelstra.mobile.entity.UserInfo;
import com.mytelstra.mobile.controller.MobileController;
import com.mytelstra.mobile.entity.MobilePlans;
import com.mytelstra.mobile.repository.MobileRepository;
import com.mytelstra.mobile.repository.UserRepository;

@SpringBootTest
class MyTelstraApplicationTests {

	@Autowired
	MobileRepository mobilerepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired 
	MobileController mobcontroller;

	@Test
	void testhome() throws Exception {
		assertEquals("Mobile Services Here",mobcontroller.home());
	}
	
	@Test
	void testViewPlans() throws Exception {
		
		List<MobilePlans> plans = mobcontroller.viewPlans();
		assertThat(plans).size().isPositive();
	}
	
	@Test
	void testUsers() throws Exception {
		
		List<UserInfo> users = mobcontroller.users();
		assertThat(users).size().isPositive();
	}
	
//	@Test
//	void testActivePlan() throws Exception{
//		RechargeInfo activeplan = mobcontroller.getCurrentPlan("100007");
//		assertEquals(null,activeplan.getPlanID());
//	}
	
	@Test
	void testUserDetais() throws Exception{
		UserInfo user = mobcontroller.userdetails("10001");
		assertEquals("Niranjan V S",user.getUsername());
		assertEquals("7485596142",user.getMobilenumber());
		assertThat(user.getPlanshistory()).size().isPositive();
	}
	
	@Test
	void testRechargeHistory() throws Exception{
		List<RechargeInfo> rechargeHistory = mobcontroller.userrechargehistory("10008");
		assertThat(rechargeHistory).size().isEqualTo(0);
	}
	
//	@Test
//	void testCurrentBalance() throws Exception{
//		Map<String,String> balance = mobcontroller.getBalance("10001");
//		assertEquals("56.0 GB",balance.get("Data"));
//		assertEquals("1000",balance.get("Voice"));
//		assertEquals("100.0",balance.get("SMS"));
//	}
	
	@Test
	void testRecharge() throws Exception{
		Map<String,String> details  =new HashMap<>();
		details.put("userid","10010");
		details.put("planid","TELMOB20210005");
		String recharge = mobcontroller.rechargeUserPut(details);
		assertEquals("Recharge Failed  - You Have an Active Plan", recharge);
	}
}
