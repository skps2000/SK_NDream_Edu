package com.skps.nowdream.education.angular.Chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapBoardServiceImplement implements MapBoardService{

	private static final Logger logger = LoggerFactory.getLogger(MapBoardServiceImplement.class);
	
	@Autowired
	private MapBoardDao mapDao;
	
	@Override
	public List<HashMap<String, Object>> getList(HashMap<String,Object> parameterMap){
		logger.info("getList : Service");
		List<HashMap<String,Object>> resultMap = mapDao.getList(parameterMap);
		
		return resultMap;
	}
	
	@Override
	public List<HashMap<String, Object>> getPlaces(HashMap<String,Object> parameterMap){
		List<HashMap<String,Object>> resultMap = mapDao.getPlaces(parameterMap);
		return resultMap;
	}

	@Override
	public List<HashMap<String, Object>> getInsert(HashMap<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> getUpdate(HashMap<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> getDelete(HashMap<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWriteBoard(HashMap<String, Object> parameterMap) {
		int result = mapDao.getWriteBoard(parameterMap);
		return result;
	}

}
