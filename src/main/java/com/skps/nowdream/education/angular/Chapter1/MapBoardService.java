package com.skps.nowdream.education.angular.Chapter1;

import java.util.HashMap;
import java.util.List;

public interface MapBoardService {

	List<HashMap<String, Object>> getList(HashMap<String, Object> parameterMap);
	int getWriteBoard(HashMap<String, Object> parameterMap);
	List<HashMap<String, Object>> getPlaces(HashMap<String, Object> parameterMap);
	List<HashMap<String, Object>> getInsert(HashMap<String, Object> parameterMap);
	List<HashMap<String, Object>> getUpdate(HashMap<String, Object> parameterMap);
	List<HashMap<String, Object>> getDelete(HashMap<String, Object> parameterMap);


}
