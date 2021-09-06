package com.mytelstra.mobile.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mytelstra.mobile.entity.MobilePlans;
import com.mytelstra.mobile.entity.RechargeInfo;
import com.mytelstra.mobile.entity.UserInfo;

public interface MobileServices {
	public List<MobilePlans> viewPlans();
	public List<UserInfo> userinfo();
	public UserInfo getUserById(String id);
	public List<RechargeInfo> userRechargeHistory(String id);
	public MobilePlans getMobilePlanById(String id);
	public RechargeInfo getCurrentPlan(String id);
	public Map<String,String> getCurrentBalance(String id);
	public String rechargeUserById(String userid, String planid);
}
