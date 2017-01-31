package com.skps.nowdream.education.angular.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skps.nowdream.education.angular.Dao.AngularBbsDAO;
import com.skps.nowdream.education.angular.Service.AngularBbsService;
import com.skps.nowdream.education.angular.command.CommandController;

@Service
public class AngularBbsServiceImplement implements AngularBbsService{
	private static final Logger logger = LoggerFactory.getLogger(AngularBbsServiceImplement.class);
	
	@Autowired
	private AngularBbsDAO angularBbsDao;

	@Override
	public List<Map> selectOne(Map<String, Object> pMap) {
		logger.info("service");
		
		return angularBbsDao.selectOne(pMap);
	}
	
	
	
	
	

}
