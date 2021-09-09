package com.mytelstra.mobile.service;
import java.util.List;
import java.util.Map;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mytelstra.mobile.entity.ActivePlan;
import com.mytelstra.mobile.entity.Balance;
import com.mytelstra.mobile.entity.MobilePlans;
import com.mytelstra.mobile.entity.RechargeInfo;
import com.mytelstra.mobile.entity.UsageInfo;
import com.mytelstra.mobile.entity.UserInfo;

public interface MobileServices {
	public List<MobilePlans> viewPlans();
	public List<UserInfo> userinfo();
	public UserInfo getUserById(String id);
	public List<RechargeInfo> userRechargeHistory(String id);
	public MobilePlans getMobilePlanById(String id);
	public List<ActivePlan> getCurrentPlan(String id);
	public Balance getCurrentBalance(String id);
	public String rechargeUserById(String userid, String planid);
	public List<UsageInfo> getUsageInfoById(String userid);
	public boolean createNewUser(String userid);
	public String addusage(Map<String,String> usage, String userid);
}
