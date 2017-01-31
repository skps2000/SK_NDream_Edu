package com.skps.nowdream.education.angular.Chapter1;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MapBoardDao {

	private static final Logger logger = LoggerFactory.getLogger(MapBoardDao.class);
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public List<HashMap<String, Object>> getList(HashMap<String, Object> parameterMap) {
		logger.info("getList : dao");
		List<HashMap<String,Object>> resultMap = sqlSession.selectList("com.skps.nowdream.education.angular.MapBoardQuery.getList",parameterMap);
		return resultMap;
	}
	
	public List<HashMap<String, Object>> getPlaces(HashMap<String, Object> parameterMap) {
		List<HashMap<String,Object>> resultMap = sqlSession.selectList("com.skps.nowdream.education.angular.MapBoardQuery.getPlaces",parameterMap);
		return resultMap;
	}
	
	public int getWriteBoard(HashMap<String, Object> parameterMap) {
			int result = 0;
			result = sqlSession.insert("com.skps.nowdream.education.angular.MapBoardQuery.getWriteBoard", parameterMap);
			if(result == 1) result = sqlSession.insert("com.skps.nowdream.education.angular.MapBoardQuery.getWritePlace", parameterMap);
			
		return result;
	}
	
	
	

} 
