package com.mytelstra.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.mytelstra.mobile.entity.MobilePlans;
import com.mytelstra.mobile.entity.UserInfo;

@Repository
public interface MobileRepository extends MongoRepository<MobilePlans, String> {
	@Query(value="{'plantype':'base'}")
	List<MobilePlans> findBasePlans();
	@Query(value="{'plantype':'addon'}")
	List<MobilePlans> findAddonPlans();
	@Query(value="{'id' : ?0,'plantype':'base' }")
	Optional<MobilePlans> findBasePlanById(String id);
	@Query(value="{'id' : ?0,'plantype':'addon' }")
	Optional<MobilePlans> findAddonPlanById(String id);
}
