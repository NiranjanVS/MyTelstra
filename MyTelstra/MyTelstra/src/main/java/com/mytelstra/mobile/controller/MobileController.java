package com.mytelstra.mobile.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytelstra.mobile.entity.MobilePlans;
import com.mytelstra.mobile.entity.RechargeInfo;
import com.mytelstra.mobile.entity.UserInfo;
import com.mytelstra.mobile.service.MobileServices;

@RestController
@CrossOrigin
public class MobileController {
	@Autowired
	private MobileServices mobileServices;
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	private String home() {
		return "Mobile Services Here";
	}
	
	@RequestMapping(value="/viewPlans",method = RequestMethod.GET)
	public List<MobilePlans> viewPlans(){
		return mobileServices.viewPlans();
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<UserInfo> users(){
		return mobileServices.userinfo();
	}
	
	/*@RequestMapping(value="/userDetails/{id}", method = RequestMethod.GET)
	public UserInfo userdetailsByID(@PathVariable("id") String id){
		return mobileServices.getUserById(id);
	}*/
	
	@RequestMapping(value="/userDetails", method = RequestMethod.GET)
	public UserInfo userdetails(@RequestBody String id){
		return mobileServices.getUserById(id);
	}
	
	@RequestMapping(value="/rechargeHistory/{id}", method = RequestMethod.GET)
	public List<RechargeInfo> userrechargehistoryById(@PathVariable("id") String id){
		return mobileServices.userRechargeHistory(id);
	}
	
	@RequestMapping(value="/rechargeHistory", method = RequestMethod.GET)
	public List<RechargeInfo> userrechargehistory(@RequestBody String id){
		return mobileServices.userRechargeHistory(id);
	}
	
	/*@RequestMapping(value="/mobilePlan/{id}", method = RequestMethod.GET)
	public MobilePlans viewPlanByID(@PathVariable("id") String id) {
		return mobileServices.getMobilePlanById(id);
	}*/
	
	/*@RequestMapping(value="/currentPlan/{id}",method = RequestMethod.GET)
	public RechargeInfo getCurrentPlanById(@PathVariable("id") String id) {
		return mobileServices.getCurrentPlan(id);
	}*/
	
	@RequestMapping(value="/currentPlan",method = RequestMethod.GET)
	public RechargeInfo getCurrentPlan(@RequestBody String id) {
		return mobileServices.getCurrentPlan(id);
	}
	
	/*@RequestMapping(value="/balance/{id}",method = RequestMethod.GET)
	public Map<String,String> getBalanceById(@PathVariable("id") String id) {
		return mobileServices.getCurrentBalance(id);
	}*/
	
	@RequestMapping(value="/balance",method = RequestMethod.GET)
	public Map<String,String> getBalance(@RequestBody String id) {
		return mobileServices.getCurrentBalance(id);
	}
	
	/*@RequestMapping(value="/recharge/{userid}/{planid}",method = RequestMethod.GET)
	public String rechargeUserGet(@PathVariable("userid") String userid, @PathVariable("planid") String planid) {
		return mobileServices.rechargeUserById(userid,planid);
	}*/
	
	@RequestMapping(value="/recharge",method = RequestMethod.PUT)
	public String rechargeUserPut(@Validated @RequestBody Map<String,String> id) {
		return mobileServices.rechargeUserById(id.get("userid"),id.get("planid"));
	}
}
