package com.skps.nowdream.education.angular.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.skps.nowdream.education.angular.command.CommandController;

@Repository
public class AngularBbsDAO {
	private static final Logger logger = LoggerFactory.getLogger(AngularBbsDAO.class);
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

	public List<Map> selectOne(Map<String, Object> pMap) {
		logger.info("dao");
		logger.info(pMap.entrySet()+"");
		
		return sqlSession.selectList("com.skps.nowdream.education.angular.mapper.selectOne", pMap);
	}
}
