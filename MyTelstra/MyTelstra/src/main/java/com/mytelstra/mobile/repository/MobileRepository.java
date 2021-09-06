package com.mytelstra.mobile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mytelstra.mobile.entity.MobilePlans;

@Repository
public interface MobileRepository extends MongoRepository<MobilePlans, String> {
	
}
