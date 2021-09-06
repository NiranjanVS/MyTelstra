package com.mytelstra.mobile.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mytelstra.mobile.entity.MobilePlans;
import com.mytelstra.mobile.entity.RechargeInfo;
import com.mytelstra.mobile.entity.UserInfo;
import com.mytelstra.mobile.repository.MobileRepository;
import com.mytelstra.mobile.repository.UserRepository;


@Service
public class MobileServicesImpl implements MobileServices{
	
	@Autowired
	private MobileRepository mobilerepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private MongoClient client;

	@Override
	public List<MobilePlans> viewPlans() {
		
		List<MobilePlans> mobileplans = mobilerepo.findAll();
		
		for(MobilePlans p: mobileplans)
			System.out.println(p);
		
		return mobileplans;
	}

	@Override
	public List<UserInfo> userinfo() {
		
		List<UserInfo> userinfo = userrepo.findAll();
		for(UserInfo u:userinfo)
			System.out.println(u);
		
		return userinfo;
	}

	@Override
	public List<RechargeInfo> userRechargeHistory(String id) {
		// TODO Auto-generated method stub
		Optional<UserInfo> userinfo = userrepo.findById(id);
		List<RechargeInfo> rechargehistory = new ArrayList<RechargeInfo>();
		
		try {
			rechargehistory = userinfo.get().getPlanshistory();
		}catch(Exception e) {
			//if the user not found with _id=id
			System.out.println("No Such User Found");
			rechargehistory.add(0,null);
			return null;
		}
		/*List<MobilePlans> history = new ArrayList<MobilePlans>();
		
		
		//if user exists and has no recharges history
		if(rechargehistory.get(0)==null) {
			System.out.println("No Data Found");
			return new ArrayList<MobilePlans>();
		}
		
		//if user id present and has recharges history, we fetch recharge details using Mobile data plan id
		for(RechargeInfo s:rechargehistory) {
			MobilePlans p = getMobilePlanById(s.getPlanId());
			history.add(p);
		}
		return history;*/
		return rechargehistory;
	}


	@Override
	public UserInfo getUserById(String id) {
		// TODO Auto-generated method stub
		Optional<UserInfo> userinfo = userrepo.findById(id);
		if(!userinfo.isPresent())
			return new UserInfo();
		System.out.println(userinfo.get());
		return userinfo.get();
	}

	@Override
	public MobilePlans getMobilePlanById(String id) {
		Optional<MobilePlans> planinfo = mobilerepo.findById(id);
		if(!planinfo.isPresent())
			return new MobilePlans();
		System.out.println(planinfo.get());
		return planinfo.get();
	}

	@Override
	public RechargeInfo getCurrentPlan(String id) {
		Optional<UserInfo> userinfo = userrepo.findById(id);
		if(!userinfo.isPresent() || userinfo.get().getActiveplan()==null)
			//return null;
			return new RechargeInfo();
		System.out.println(userinfo.get().getActiveplan());
		return userinfo.get().getActiveplan();
	}

	@Override
	public Map<String, String> getCurrentBalance(String id) {
		
		Map<String,String> balances = new HashMap<String,String>();
		balances.put("Data","0.0 GB");
		balances.put("Voice","0");
		balances.put("SMS","0");
		
		
		Optional<UserInfo> userinfo = userrepo.findById(id);
		if(!userinfo.isPresent() || userinfo.get().getActiveplan()==null)
			return balances;
			//return new HashMap<String,String>();
		//Map<String,String> balances = new HashMap<String,String>();
		balances.put("Data",Double.toString(userinfo.get().getDataremaining())+" GB");
		balances.put("Voice",Integer.toString(userinfo.get().getVoiceremaining()));
		balances.put("SMS",Double.toString(userinfo.get().getSmsremaining()));
		return balances;
	}

	@Override
	public String rechargeUserById(String userid, String planid) {
		Optional<UserInfo> userinfo = userrepo.findById(userid);
		Optional<MobilePlans> planinfo  = mobilerepo.findById(planid);
		if(!userinfo.isPresent())
			return "No User Found";
		if(!planinfo.isPresent())
			return "No Such Plans Exist";
		UserInfo user = userinfo.get();
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date todate = new Date();
		String today = simpleDateFormat.format(new Date());
		
		Date currentPlanExpiry = null;
		
		
		if(user.getActiveplan()!=null) {

			try {
				currentPlanExpiry = simpleDateFormat.parse(user.getActiveplan().getDateOfExpiry());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(todate.compareTo(currentPlanExpiry)<=0) {
				return "Recharge not possible as you have an active plan\n"+"And Your current plan is\n"+mobilerepo.findById(user.getActiveplan().getPlanID()).get();
			}
		}
		
		
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(simpleDateFormat.parse(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, planinfo.get().getDuration());
		
		String Lastdate = simpleDateFormat.format(cal.getTime());
		
		System.out.println(today);
		System.out.println(planinfo.get().getDuration());
		
		
		RechargeInfo rinfo = new RechargeInfo();
		rinfo.setPlanID(planinfo.get().getId());
		rinfo.setDateOfRecharge(today);
		rinfo.setDateOfExpiry(Lastdate);
		System.out.println(Lastdate);
		rinfo.setPaymentMode("online");
		rinfo.setTransactionId(UUID.randomUUID().toString());
		
		List<RechargeInfo> history = user.getPlanshistory();
		history.add(rinfo);
		user.setPlanshistory(history);
		
		user.setActiveplan(rinfo);
		
		user.setDataremaining(planinfo.get().getData());
		user.setVoiceremaining(planinfo.get().getVoice());
		user.setSmsremaining(planinfo.get().getSms());
		
		
		userrepo.save(user);
		System.out.println(user);
		
		return "Recharge Successful\n"+userrepo.findById(userid).get();
	}

}
